package hiberspring.service;


import hiberspring.domain.entities.Branch;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public interface BranchService {

    Boolean branchesAreImported();

    String readBranchesJsonFile() throws IOException;

    String importBranches(String branchesFileContent) throws FileNotFoundException;

    Branch getBranchByName(String name);
}
