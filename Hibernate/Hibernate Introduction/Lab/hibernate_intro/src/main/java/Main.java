import entities.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();

        Person p = new Person("John", 18);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();

        SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);

        Session currentSession = factory.openSession();
        currentSession.beginTransaction();
        currentSession.persist(p);
        currentSession.getTransaction().commit();
        currentSession.close();
    }
}
