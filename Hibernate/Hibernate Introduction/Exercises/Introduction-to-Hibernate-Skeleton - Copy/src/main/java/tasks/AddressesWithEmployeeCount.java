package tasks;

import entities.Address;

import javax.persistence.EntityManager;

import java.util.List;

import static tasks.Queries.FIND_ADDRESSES;

public class AddressesWithEmployeeCount extends Task {
    public AddressesWithEmployeeCount(EntityManager manager) {
        super(manager);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void run() {
        List<Object[]> columns = getManager()
                .createQuery(FIND_ADDRESSES)
                .setMaxResults(10)
                .getResultList();

        for (Object[] column : columns) {
            String addressText = (String) column[0];
            String townName = (String) column[1];
            long employeesCount = (long) column[2];
            System.out.printf("%s, %s - %d employees%n", addressText, townName,
                    (int) employeesCount);
        }

    }

    private void printAddresses(List<Address> addresses) {
        for (Address address : addresses) {
            System.out.printf("%s, %s%n",
                    address.getText(),
                    address.getTown().getName());
        }

    }
}
