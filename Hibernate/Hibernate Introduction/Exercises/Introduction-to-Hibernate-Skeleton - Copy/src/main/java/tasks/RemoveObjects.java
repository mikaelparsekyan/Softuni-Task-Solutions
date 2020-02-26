package tasks;

import entities.Town;

import javax.persistence.EntityManager;
import java.util.List;

import static tasks.Queries.GET_ALL_TOWNS;

public class RemoveObjects extends Task {

    public RemoveObjects(EntityManager manager) {
        super(manager);
    }

    @Override
    public void run() {
        List<Town> detachedTowns = getManager()
                .createQuery(Queries.PERSIST_ALL_TOWNS, Town.class)
                .getResultList();

        getManager().getTransaction().begin();

        detachedTowns.forEach(getManager()::detach);

        transformNames(getAttachedTowns());

        detachedTowns.forEach(getManager()::merge);

        getManager().flush();
        getManager().getTransaction().commit();

        printTowns(getAttachedTowns());

    }


    private void transformNames(List<Town> towns) {
        towns.forEach(t -> t.setName(t.getName().toLowerCase()));
    }

    private List<Town> getAttachedTowns() {
        return getManager()
                .createQuery(GET_ALL_TOWNS, Town.class)
                .getResultList();
    }

    private void printTowns(List<Town> towns) {
        for (Town town : towns) {
            System.out.println(town.getName());
        }
    }
}
