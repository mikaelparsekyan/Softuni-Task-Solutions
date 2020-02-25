package tasks;

import javax.persistence.EntityManager;

public class IncreaseSalaries extends Task {
    public IncreaseSalaries(EntityManager manager) {
        super(manager);
    }

    @Override
    public void run() {

    }
}
