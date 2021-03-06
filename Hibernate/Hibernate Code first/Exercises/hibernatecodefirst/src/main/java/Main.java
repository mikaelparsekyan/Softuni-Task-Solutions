import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("demo_db_pu");
        EntityManager manager = factory.createEntityManager();

        Engine engine = new Engine(manager);

        engine.run();
    }
}
