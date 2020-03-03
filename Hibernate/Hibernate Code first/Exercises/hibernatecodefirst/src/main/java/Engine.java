import javax.persistence.EntityManager;

public class Engine implements Runnable {
    private final EntityManager manager;

    public Engine(EntityManager manager) {
        this.manager = manager;
    }


    @Override
    public void run() {
        /*
            NOTHING TO RUN,
            JUST CANCEL EXCLUSION ON A FOLDER TO RUN ALL ENTITIES IN IT!

            @SEE README.TXT
        */
    }
}
