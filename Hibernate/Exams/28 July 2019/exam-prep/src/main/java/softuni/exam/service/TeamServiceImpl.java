package softuni.exam.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.constants.FileImportPath;
import softuni.exam.domain.dtos.in.team.TeamsImportDto;
import softuni.exam.domain.entities.Picture;
import softuni.exam.domain.entities.Team;
import softuni.exam.repository.PictureRepository;
import softuni.exam.repository.TeamRepository;
import softuni.exam.util.ValidatorUtil;
import softuni.exam.util.XmlParser;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


@Service
@Transactional
public class TeamServiceImpl implements TeamService {
    @Autowired
    private final TeamRepository teamRepository;
    @Autowired
    private final PictureRepository pictureRepository;
    @Autowired
    private final XmlParser xmlParser;
    @Autowired
    private final ValidatorUtil validatorUtil;
    @Autowired
    private final ModelMapper modelMapper;

    public TeamServiceImpl(TeamRepository teamRepository, PictureRepository pictureRepository, XmlParser xmlParser, ValidatorUtil validatorUtil, ModelMapper modelMapper) {
        this.teamRepository = teamRepository;
        this.pictureRepository = pictureRepository;
        this.xmlParser = xmlParser;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public String importTeams() throws JAXBException, FileNotFoundException {
        StringBuilder result = new StringBuilder();
        TeamsImportDto teamsImportDto = xmlParser.convertFromFile(FileImportPath.TEAMS_IMPORT_FILE_PATH,
                TeamsImportDto.class);

        teamsImportDto.getTeams().forEach(team -> {

            Team mappedTeam = modelMapper.map(team, Team.class);
            Picture teamPicture = pictureRepository.findByUrl(team.getPicture().getUrl());

            if (validatorUtil.isValid(mappedTeam) && teamPicture != null &&
                    validatorUtil.isValid(teamPicture)) {

                mappedTeam.setPicture(teamPicture);
                teamRepository.saveAndFlush(mappedTeam);

                result.append(String.format("Successfully imported - %s%n",
                        team.getName()));
            } else {
                result.append("Invalid team").append(System.lineSeparator());
            }
        });
        return result.toString();
    }

    @Override
    public boolean areImported() {
        return teamRepository.findAll().size() > 0;
    }

    @Override
    public String readTeamsXmlFile() throws IOException {
        return Files.readString(Path.of(FileImportPath.TEAMS_IMPORT_FILE_PATH));
    }

}
