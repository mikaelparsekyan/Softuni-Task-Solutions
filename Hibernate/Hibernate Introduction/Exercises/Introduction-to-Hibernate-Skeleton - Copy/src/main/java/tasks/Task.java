package tasks;

import javax.persistence.EntityManager;

public abstract class Task implements Runnable {
    private EntityManager manager;

    public Task(EntityManager manager) {
        this.manager = manager;
    }

    public EntityManager getManager() {
        return manager;
    }
}
