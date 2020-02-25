package tasks;

import entities.Employee;

import javax.persistence.EntityManager;

import java.util.List;
import java.util.Scanner;

import static tasks.Queries.FIND_EMPLOYEE_BY_PATTERN;

public class FindEmployeesByFirstName extends Task {
    private Scanner scanner;

    public FindEmployeesByFirstName(EntityManager manager) {
        super(manager);
        scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        System.out.println("Enter pattern: ");
        String pattern = scanner.nextLine();

        List<Employee> employees = getEmployeesByPattern(pattern);

        printEmployees(employees);

    }

    private void printEmployees(List<Employee> employees) {
        for (Employee e : employees) {
            System.out.printf("%s %s - %s - ($%.2f)%n",
                    e.getFirstName(), e.getLastName(),
                    e.getJobTitle(), e.getSalary().floatValue());
        }
    }

    private List<Employee> getEmployeesByPattern(String pattern) {
        return getManager()
                .createQuery(FIND_EMPLOYEE_BY_PATTERN, Employee.class)
                .setParameter("pattern", pattern + "%")
                .getResultList();
    }
}
