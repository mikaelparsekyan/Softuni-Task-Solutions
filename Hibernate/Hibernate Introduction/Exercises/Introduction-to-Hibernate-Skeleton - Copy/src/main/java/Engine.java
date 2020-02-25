import tasks.*;

import javax.persistence.EntityManager;
import java.util.Scanner;


public class Engine implements Runnable {
    private EntityManager manager;


    public Engine(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void run() {
        clearDatabase();

        Task currentTask = new FindLatestProjects(this.manager);

        currentTask.run();
    }

    private void clearDatabase() {

    }
}
