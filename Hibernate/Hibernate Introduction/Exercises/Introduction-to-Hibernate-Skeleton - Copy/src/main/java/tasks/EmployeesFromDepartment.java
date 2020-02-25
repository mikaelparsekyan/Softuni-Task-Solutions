package tasks;

import entities.Employee;

import javax.persistence.EntityManager;

import java.util.List;

import static tasks.Queries.GET_EMPLOYEES_FROM_DEPARTMENT;

public class EmployeesFromDepartment extends Task {

    public EmployeesFromDepartment(EntityManager manager) {
        super(manager);
    }

    @Override
    public void run() {
        List<Employee> employees = getManager()
                .createQuery(GET_EMPLOYEES_FROM_DEPARTMENT, Employee.class)
                .getResultList();

        System.out.println("All employees from 'Research and Development' department.");
        printEmployees(employees);
    }

    private void printEmployees(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.printf("%s %s from Research and Development - $%.2f%n",
                    employee.getFirstName(), employee.getLastName(),
                    employee.getSalary().floatValue());
        }
    }
}
