
import tasks.*;

import javax.persistence.EntityManager;


public class Engine implements Runnable {
    private EntityManager manager;


    Engine(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void run() {
        /*
           @Warrning: TO TEST SEE PROPER RESULTS,
                USE A CLEAR DATABASE BEFORE STARTING A TASK!

                Happy testing! :)
         */

        Task currentTask = new RemoveObjects(this.manager);

        currentTask.run();
    }
}
