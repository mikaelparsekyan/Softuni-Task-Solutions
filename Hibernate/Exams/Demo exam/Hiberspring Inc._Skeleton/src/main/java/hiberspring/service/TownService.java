package hiberspring.service;


import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Town;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public interface TownService {

    Boolean townsAreImported();

    String readTownsJsonFile() throws IOException;

    String importTowns(String townsFileContent) throws FileNotFoundException;

    Town getTownsByName(String name);
}
