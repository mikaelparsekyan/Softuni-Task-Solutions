package tasks;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.Scanner;

import static tasks.Queries.GET_EMPLOYEE_NAME;

public class ContainsEmployee extends Task {
    private Scanner scanner;

    public ContainsEmployee(EntityManager manager) {
        super(manager);
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        System.out.println("Enter employee name: ");
        String employeeName = scanner.nextLine();

        try {
            getManager()
                    .createQuery(GET_EMPLOYEE_NAME, Employee.class)
                    .setParameter("name", employeeName).getSingleResult();

            System.out.println("Yes");
        } catch (NoResultException e) {
            System.out.println("No");
        }
    }
}
