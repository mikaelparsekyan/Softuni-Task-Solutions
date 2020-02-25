package tasks;

import entities.Employee;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

import static tasks.Queries.GET_EMPLOYEES;

public class IncreaseSalaries extends Task {
    public IncreaseSalaries(EntityManager manager) {
        super(manager);
    }

    @Override
    public void run() {
        List<Employee> employees = getEmployees();

        getManager().getTransaction().begin();

        employees.forEach(getManager()::detach);

        employees.forEach(e -> e.setSalary(e.getSalary()
                .multiply(new BigDecimal(1.12))));

        employees.forEach(getManager()::merge);

        getManager().getTransaction().commit();

        printEmployees(employees);
    }

    private void printEmployees(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.printf("%s %s ($%.2f)%n",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getSalary().floatValue());
        }
    }

    private List<Employee> getEmployees() {
        return getManager()
                .createQuery(GET_EMPLOYEES, Employee.class)
                .getResultList();
    }
}
