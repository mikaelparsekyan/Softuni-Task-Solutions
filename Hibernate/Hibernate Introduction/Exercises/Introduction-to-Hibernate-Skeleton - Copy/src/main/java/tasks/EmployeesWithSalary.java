package tasks;

import entities.Employee;

import javax.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;

import static tasks.Queries.GET_EMPLOYEES_WITH_SALARY_MORE_THAN;

public class EmployeesWithSalary extends Task {
    private BigDecimal minSalary = new BigDecimal(50000);

    public EmployeesWithSalary(EntityManager manager) {
        super(manager);
    }

    @Override
    public void run() {
        System.out.printf("All employees with salary more than %d%n: ", minSalary.intValue());

        List<Employee> employees = getManager().createQuery(GET_EMPLOYEES_WITH_SALARY_MORE_THAN, Employee.class)
                .setParameter("min_salary", minSalary).getResultList();

        printEmployees(employees);

    }

    private void printEmployees(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee.getFirstName());
        }
    }
}
