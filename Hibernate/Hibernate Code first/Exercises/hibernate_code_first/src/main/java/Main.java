import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("manager");

        EntityManager entityManager = factory.createEntityManager();

        Engine engine = new Engine(entityManager);

        engine.run();
    }
}
