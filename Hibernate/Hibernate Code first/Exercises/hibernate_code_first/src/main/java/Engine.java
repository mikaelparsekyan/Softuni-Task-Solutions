import javax.persistence.EntityManager;

public class Engine implements Runnable {
    private EntityManager manager;

    public Engine(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void run() {

    }
}
