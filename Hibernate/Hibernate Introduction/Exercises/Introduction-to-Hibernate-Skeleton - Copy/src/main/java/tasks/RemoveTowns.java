package tasks;

import entities.Address;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import java.util.List;
import java.util.Scanner;

import static tasks.Queries.*;

public class RemoveTowns extends Task {
    private Scanner scanner;
    public RemoveTowns(EntityManager manager) {
        super(manager);
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        String townName = scanner.nextLine();

        try {
            Town town = getTownByName(townName);

            long count = getCountOfDeletedAddresses(town);

            removeAddressesByTown(town);

            getManager().remove(town);

            printCountOfDeletedAddresses(count, townName);
        } catch (NoResultException e) {
            System.err.println("Town doesn't exists!");
        }
    }

    private long getCountOfDeletedAddresses(Town town) {
        return getManager().
                createQuery(GET_COUNT_OF_DELETED_ADDRESSES, Long.class)
                .setParameter("id", town.getId())
                .getSingleResult();
    }

    private void printCountOfDeletedAddresses(long count, String townName) {
        String word = "addresses";
        if (count == 1) {
            word = "address";
        }
        System.out.printf("%d %s in %s deleted%n",
                (int) count, word, townName);
    }

    private Town getTownByName(String townName) {
        return getManager()
                .createQuery(GET_TOWN_BY_NAME, Town.class)
                .setParameter("name", townName)
                .getSingleResult();
    }

    private void removeAddressesByTown(Town town) {
        List<Address> addresses = getManager()
                .createQuery(GET_ADDRESSES, Address.class)
                .setParameter("id", town.getId())
                .getResultList();

        addresses.forEach(getManager()::remove);
    }
}
