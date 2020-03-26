package softuni.exam.service;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.constants.FileImportPath;
import softuni.exam.domain.entities.Player;
import softuni.exam.repository.PlayerRepository;
import softuni.exam.util.ValidatorUtil;

import javax.transaction.Transactional;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private final PlayerRepository playerRepository;
    @Autowired
    private final ValidatorUtil validatorUtil;
    @Autowired
    private final ModelMapper modelMapper;
    @Autowired
    private final Gson gson;

    public PlayerServiceImpl(PlayerRepository playerRepository, ValidatorUtil validatorUtil, ModelMapper modelMapper, Gson gson) {
        this.playerRepository = playerRepository;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }


    @Override
    public String importPlayers() throws FileNotFoundException {
        StringBuilder result = new StringBuilder();
        List<Player> playersImportDto = gson.fromJson(
                new FileReader(FileImportPath.PLAYERS_IMPORT_FILE_PATH),
                new TypeToken<List<Player>>() {
                }.getType());

        playersImportDto.forEach(player -> {
            if (validatorUtil.isValid(player)) {
                playerRepository.saveAndFlush(player);
                result.append(String.format("Successfully imported player: %s %s%n",
                        player.getFirstName(), player.getLastName()));
            } else {
                result.append("Invalid player").append(System.lineSeparator());
            }
        });
        return result.toString();
    }

    @Override
    public boolean areImported() {
        return playerRepository.findAll().size() > 0;
    }

    @Override
    public String readPlayersJsonFile() throws IOException {
        return Files.readString(Path.of(FileImportPath.PLAYERS_IMPORT_FILE_PATH));
    }

    @Override
    public String exportPlayersWhereSalaryBiggerThan() {
        BigDecimal salary = new BigDecimal(100000);
        StringBuilder result = new StringBuilder();
        List<Player> players = playerRepository
                .getPlayersBySalaryGreaterThanOrderBySalaryDesc(salary);
        for (Player player : players) {
            result.append(player.toString());
        }

        return result.toString();
    }

    @Override
    public String exportPlayersInATeam() {
        String teamName = "North Hub";
        StringBuilder result = new StringBuilder(
                String.format("Team: %s", teamName)).append(System.lineSeparator());
        List<Player> players = playerRepository
                .getPlayersByTeam_NameEqualsOrderById(teamName);

        for (Player player : players) {
            result.append(String.format(
                    "   Player name: %s %s - %s%n" +
                            "   Number: %d%n",
                    player.getFirstName(),
                    player.getLastName(),
                    player.getPosition(),
                    player.getNumber()
            ));
        }
        return result.toString();
    }


}
