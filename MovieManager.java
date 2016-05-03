package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.List;

/**
 * Created by arcilla on 4/29/16.
 */
public class MovieManager {
    private SessionFactory sessionFactory = null;
    // Creating SessionFactory using 4.2 version of Hibernate

    public void initSessionFactory(){
        Configuration config = new Configuration().configure();
        // Build a Registry with our configuration properties
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
                config.getProperties()).buildServiceRegistry();
        // create the session factory
        sessionFactory = config.buildSessionFactory(serviceRegistry);
    }

    public void persistAMovie(Movie m) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        session.save(m);
        session.getTransaction().commit();
    }

    public void findAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Movie> trades = session.createQuery("from Movie").list();
        session.getTransaction().commit();
        System.out.println("All Trades:" + trades.size());

        for (int i = 0; i< trades.size(); ++i) {
            System.out.println("Trade: " + trades.get(i).getTitle());
        }
    }

}
