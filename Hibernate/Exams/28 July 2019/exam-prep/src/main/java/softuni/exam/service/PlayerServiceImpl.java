package softuni.exam.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.repository.PlayerRepository;

import javax.transaction.Transactional;
import java.io.FileNotFoundException;
import java.io.IOException;


@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


    @Override
    public String importPlayers() throws FileNotFoundException {
        return "";
    }

    @Override
    public boolean areImported() {
        return playerRepository.findAll().size() > 0;
    }

    @Override
    public String readPlayersJsonFile() throws IOException {
        return "";
    }

    @Override
    public String exportPlayersWhereSalaryBiggerThan() {
        return "";
    }

    @Override
    public String exportPlayersInATeam() {
        return "";
    }


}
