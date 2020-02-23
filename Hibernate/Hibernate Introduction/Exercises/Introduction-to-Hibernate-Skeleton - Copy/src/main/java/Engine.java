import tasks.ContainsEmployee;
import tasks.RemoveObjects;
import tasks.Task;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class Engine implements Runnable {
    private EntityManager manager;


    public Engine(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void run() {
        Task currentTask = new ContainsEmployee(this.manager);

        currentTask.run();
    }
}
