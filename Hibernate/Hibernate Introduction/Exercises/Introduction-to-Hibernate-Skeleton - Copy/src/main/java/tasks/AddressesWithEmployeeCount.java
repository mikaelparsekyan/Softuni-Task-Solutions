package tasks;

import entities.Address;

import javax.persistence.EntityManager;

import java.util.List;

import static tasks.Queries.FIND_ADDRESSES;

public class AddressesWithEmployeeCount extends Task {
    public AddressesWithEmployeeCount(EntityManager manager) {
        super(manager);
    }

    @Override
    public void run() {
        List<Address> addresses = getManager()
                .createQuery(FIND_ADDRESSES, Address.class)
                .setMaxResults(10)
                .getResultList();

        printAddresses(addresses);
    }

    private void printAddresses(List<Address> addresses) {
        for (Address address : addresses) {
            System.out.printf("%s, %s%n",
                    address.getText(),
                    address.getTown().getName());
        }

    }
}
