package tasks;

import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import java.util.Scanner;

import static tasks.Queries.*;

public class AddingNewAddressAndUpdatingEmployee extends Task {

    private static final String addressText = "Vitoshka 15";
    private Scanner scanner;

    public AddingNewAddressAndUpdatingEmployee(EntityManager manager) {
        super(manager);
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        Address address = new Address();
        address.setText(addressText);

        System.out.println("Enter employee last name: ");
        String employeeLastName = scanner.nextLine();
        Employee employeeToUpdate = findEmployee(employeeLastName);

        addNewAddress(address);
        updateEmployeeName(employeeToUpdate, address);

        getManager().close();
    }

    private void addNewAddress(Address address) {
        getManager().getTransaction().begin();

        getManager().persist(address);

        getManager().getTransaction().commit();

        System.out.println("Successfully added town!");
    }

    private Employee findEmployee(String employeeLastName) {

        return getManager()
                .createQuery(GET_EMPLOYEE_BY_LAST_NAME, Employee.class)
                .setParameter("last_name", employeeLastName)
                .getSingleResult();
    }

    private void updateEmployeeName(Employee employee, Address address) {
        getManager().getTransaction().begin();

        getManager().detach(employee);

        employee.setAddress(address);

        getManager().merge(employee);

        getManager().getTransaction().commit();
        System.out.println("Successfully updated employee!");
    }
}
