package CompanyRoster;

import java.util.List;

public class Department {
    String name;
    List<Employee> employees;


    Department(String name) {
        this.name = name;
    }

    List<Employee> getEmployees() {
        return employees;
    }

    void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }


}
