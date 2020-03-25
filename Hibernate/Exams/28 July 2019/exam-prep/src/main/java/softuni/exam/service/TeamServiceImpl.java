package softuni.exam.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.repository.TeamRepository;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;


@Service
@Transactional
public class TeamServiceImpl implements TeamService {
    @Autowired
    private final TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public String importTeams() throws JAXBException, FileNotFoundException {
        return "";
    }

    @Override
    public boolean areImported() {
        return teamRepository.findAll().size() > 0;
    }

    @Override
    public String readTeamsXmlFile() throws IOException {
        return "asd";
    }

}
