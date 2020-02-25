import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        /*
            @Warning: TO RUN A TASK, PLEASE SEE THE ENGINE CLASS
         */
        EntityManagerFactory managerFactory = Persistence
                .createEntityManagerFactory("manager");

        EntityManager manager = managerFactory.createEntityManager();

        Engine engine = new Engine(manager);

        engine.run();
    }
}
