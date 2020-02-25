package tasks;

import entities.Town;

import javax.persistence.EntityManager;
import java.util.List;

public class RemoveObjects extends Task {
    public RemoveObjects(EntityManager manager) {
        super(manager);
    }

    @Override
    public void run() {
        List<Town> towns = getManager()
                .createQuery(Queries.PERSIST_ALL_TOWNS, Town.class)
                .getResultList();

        getManager().getTransaction().begin();

        towns.forEach(getManager()::detach);

        printTowns(towns);

        towns.forEach(getManager()::merge);

        getManager().flush();
        getManager().getTransaction().commit();
    }

    private void printTowns(List<Town> towns) {
        for (Town town : towns) {
            town.setName(town.getName().toLowerCase());
        }
    }
}
