package hiberspring.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hiberspring.constants.FileImportPath;
import hiberspring.domain.entities.Town;
import hiberspring.repository.TownRepository;
import hiberspring.service.TownService;
import hiberspring.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

@Service
public class TownServiceImpl implements TownService {
    @Autowired
    private final TownRepository townRepository;
    @Autowired
    private final Gson gson;
    @Autowired
    private final ValidationUtil validationUtil;

    public TownServiceImpl(TownRepository townRepository, Gson gson, ValidationUtil validationUtil) {
        this.townRepository = townRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public Boolean townsAreImported() {
        return townRepository.count() > 0;
    }

    @Override
    public String readTownsJsonFile() throws IOException {
        return Files.readString(Paths.get(FileImportPath.TOWNS_IMPORT_PATH));
    }

    @Override
    public String importTowns(String townsFileContent) throws FileNotFoundException {
        StringBuilder result = new StringBuilder();
        List<Town> townList = gson.fromJson(townsFileContent,
                new TypeToken<LinkedList<Town>>() {
                }.getType());

        townList.forEach(town -> {
            if (validationUtil.isValid(town)) {
                if (townRepository.findByName(town.getName()) == null) {
                    townRepository.saveAndFlush(town);
                    result.append(String.format("Successfully imported Town %s.",
                            town.getName()));
                } else {
                    result.append("This town is already in DB!");
                }
            } else {
                result.append("Error: Invalid data");
            }
            result.append(System.lineSeparator());
        });
        return result.toString();
    }

    @Override
    public Town getTownsByName(String name) {
        return townRepository.findByName(name);
    }
}
