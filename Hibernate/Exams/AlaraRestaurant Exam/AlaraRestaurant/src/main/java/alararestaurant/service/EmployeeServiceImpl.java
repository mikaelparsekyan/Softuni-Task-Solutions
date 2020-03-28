package alararestaurant.service;

import alararestaurant.constants.FileImportPaths;
import alararestaurant.domain.dtos.EmployeesImportDto;
import alararestaurant.domain.entities.Employee;
import alararestaurant.domain.entities.Position;
import alararestaurant.repository.EmployeeRepository;
import alararestaurant.repository.PositionRepository;
import alararestaurant.util.FileUtil;
import alararestaurant.util.ValidationUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private final EmployeeRepository employeeRepository;
    @Autowired
    private final PositionRepository positionRepository;
    @Autowired
    private final FileUtil fileUtil;
    @Autowired
    private final ValidationUtil validationUtil;
    @Autowired
    private final Gson gson;
    @Autowired
    private final ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, PositionRepository positionRepository, FileUtil fileUtil, ValidationUtil validationUtil, Gson gson, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.positionRepository = positionRepository;
        this.fileUtil = fileUtil;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean employeesAreImported() {
        return this.employeeRepository.count() > 0;
    }

    @Override
    public String readEmployeesJsonFile() {
        return fileUtil.readFile(FileImportPaths.EMPLOYEES_IMPORT_PATH);
    }

    @Override
    public String importEmployees(String employees) {
        StringBuilder result = new StringBuilder();

        LinkedList<EmployeesImportDto> employeeList = gson.fromJson(employees,
                new TypeToken<LinkedList<EmployeesImportDto>>() {
                }.getType());
        System.out.println();
        for (EmployeesImportDto employee : employeeList) {
            Employee mappedEmployee = modelMapper.map(employee, Employee.class);
            Position position = positionRepository
                    .getPositionByName(employee.getPosition());

            if (position == null) {
                position = new Position();
                position.setName(employee.getPosition());
            }
            mappedEmployee.setPosition(position);
            if (validationUtil.isValid(mappedEmployee)
                    && validationUtil.isValid(position)) {

                employeeRepository.saveAndFlush(mappedEmployee);

                result.append(
                        String.format("Record %s successfully imported.",
                                employee.getName()));
            } else {
                result.append("Invalid data format.");
            }
            result.append(System.lineSeparator());
        }
        return result.toString();
    }
}
