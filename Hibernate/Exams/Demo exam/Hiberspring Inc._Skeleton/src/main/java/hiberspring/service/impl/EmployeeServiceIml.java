package hiberspring.service.impl;

import hiberspring.constants.FileImportPath;
import hiberspring.domain.dto.EmployeesImportDto;
import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Employee;
import hiberspring.domain.entities.EmployeeCard;
import hiberspring.repository.EmployeeRepository;
import hiberspring.service.BranchService;
import hiberspring.service.EmployeeCardService;
import hiberspring.service.EmployeeService;
import hiberspring.util.ValidationUtil;
import hiberspring.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceIml implements EmployeeService {
    @Autowired
    private final EmployeeRepository employeeRepository;
    @Autowired
    private final ValidationUtil validationUtil;
    @Autowired
    private final BranchService branchService;
    @Autowired
    private final EmployeeCardService cardService;
    @Autowired
    private final XmlParser xmlParser;
    @Autowired
    private final ModelMapper modelMapper;

    public EmployeeServiceIml(EmployeeRepository employeeRepository,
                              ValidationUtil validationUtil,
                              BranchService branchService,
                              EmployeeCardService cardService,
                              XmlParser xmlParser, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.validationUtil = validationUtil;
        this.branchService = branchService;
        this.cardService = cardService;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean employeesAreImported() {
        return employeeRepository.count() > 0;
    }

    @Override
    public String readEmployeesXmlFile() throws IOException {
        return Files.readString(Path.of(FileImportPath.EMPLOYEES_IMPORT_PATH));
    }

    @Override
    public String importEmployees() throws JAXBException, FileNotFoundException {
        StringBuilder result = new StringBuilder();
        EmployeesImportDto employeesImportDto = xmlParser.parseXml(EmployeesImportDto.class,
                FileImportPath.EMPLOYEES_IMPORT_PATH);

        employeesImportDto.getEmployees().stream()
                .forEach(employeeImportDto -> {
                    Employee employee = modelMapper.map(employeeImportDto, Employee.class);
                    EmployeeCard employeeCard = cardService
                            .getCardByNumber(employeeImportDto.getCard());
                    Branch branch = branchService.getBranchByName(employeeImportDto.getBranch());
                    if (employeeCard != null && branch != null) {
                        employee.setBranch(branch);
                        employee.setCard(employeeCard);
                        if (validationUtil.isValid(employee)) {
                            if (checkIfCardIsNotTaken(employeeCard.getNumber())) {
                                employeeRepository.saveAndFlush(employee);
                                result.append(String.format("Successfully imported Employee %s %s.",
                                        employeeImportDto.getFirstName(), employeeImportDto.getLastName()));
                            } else {
                                result.append("Card is taken!");
                            }
                        } else {
                            result.append("Error: Invalid data.");
                        }
                    } else {
                        result.append("Branch ot card not exist in database!");
                    }
                    result.append(System.lineSeparator());
                });
        return result.toString();
    }

    private boolean checkIfCardIsNotTaken(String cardNumber) {
        for (Employee employee : employeeRepository.getEmployeesByCardNotNull()) {
            if (employee.getCard().getNumber().equals(cardNumber)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String exportProductiveEmployees() {
        StringBuilder result = new StringBuilder();
        employeeRepository.findAll().stream()
                .filter(employee -> employee.getBranch().getProducts().size() >= 1)
                .sorted((e1, e2) -> {
                    int r = (e1.getFirstName() + " " + e1.getLastName())
                            .compareTo(e2.getFirstName() + " " + e2.getLastName());

                    if (r == 0) {
                        r = Integer.compare(e2.getPosition().length(),
                                e1.getPosition().length());
                    }
                    return r;
                })
                .forEach(employee -> {
                    result.append(String.format("Name: %s",
                            employee.getFirstName() + " " + employee.getLastName()))
                            .append(System.lineSeparator());
                    result.append(String.format("Position: %s",
                            employee.getPosition()))
                            .append(System.lineSeparator());
                    result.append(String.format("Card Number: %s",
                            employee.getCard().getNumber()))
                            .append(System.lineSeparator());
                    result.append("-------------------------")
                            .append(System.lineSeparator());
                });
        return result.toString();
    }
}
