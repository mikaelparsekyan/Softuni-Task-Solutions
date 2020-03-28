package hiberspring.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hiberspring.constants.FileImportPath;
import hiberspring.domain.dto.BranchesImportDto;
import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Town;
import hiberspring.repository.BranchRepository;
import hiberspring.service.BranchService;
import hiberspring.service.TownService;
import hiberspring.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

@Service
public class BranchServiceImpl implements BranchService {
    @Autowired
    private final BranchRepository branchRepository;
    @Autowired
    private final Gson gson;
    @Autowired
    private final ValidationUtil validationUtil;
    @Autowired
    private final TownService townService;
    @Autowired
    private final ModelMapper modelMapper;

    public BranchServiceImpl(BranchRepository branchRepository, Gson gson, ValidationUtil validationUtil, TownService townService, ModelMapper modelMapper) {
        this.branchRepository = branchRepository;
        this.gson = gson;

        this.validationUtil = validationUtil;
        this.townService = townService;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean branchesAreImported() {
        return branchRepository.count() > 0;
    }

    @Override
    public String readBranchesJsonFile() throws IOException {
        return Files.readString(Path.of(FileImportPath.BRANCHES_IMPORT_PATH));
    }

    @Override
    public String importBranches(String branchesFileContent) throws FileNotFoundException {
        StringBuilder result = new StringBuilder();
        List<BranchesImportDto> branches = gson.fromJson(branchesFileContent,
                new TypeToken<LinkedList<BranchesImportDto>>() {
                }.getType());

        branches.forEach(branchesImportDto -> {
            boolean success = false;
            if (validationUtil.isValid(branchesImportDto)) {
                Town town = townService.getTownsByName(branchesImportDto.getTown());
                if (town != null) {
                    result.append(String.format("Successfully imported Branch %s.",
                            branchesImportDto.getName()));
                    Branch branch = modelMapper.map(branchesImportDto, Branch.class);
                    branch.setTown(townService.getTownsByName(branchesImportDto.getTown()));
                    branchRepository.saveAndFlush(branch);
                    success = true;
                }
            }
            if (!success) {
                result.append("Error: Invalid data.");
            }
            result.append(System.lineSeparator());
        });
        return result.toString();
    }

    @Override
    public Branch getBranchByName(String name) {
        return branchRepository.getBranchByName(name);
    }
}
