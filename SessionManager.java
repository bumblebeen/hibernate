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
public class SessionManager {
    private SessionFactory sessionFactory = null;
    // Creating SessionFactory using 4.2 version of Hibernate

    public void initSessionFactory(){
        Configuration config = new Configuration().configure()
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(CoursePK.class)
                .addAnnotatedClass(Course2.class)
                .addAnnotatedClass(CoursePK2.class);
        // Build a Registry with our configuration properties
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
                config.getProperties()).buildServiceRegistry();
        // create the session factory
        sessionFactory = config.buildSessionFactory(serviceRegistry);
    }

    public void persistAMovie() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Movie m = new Movie();
        m.setId(11);
        m.setTitle("Jungle Book");
        m.setDirector("Boots the Explorer");
        m.setSynopsis("Hey Kid");

        session.saveOrUpdate(m);
        session.getTransaction().commit();
    }

    public void deleteAMovie() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Movie m = (Movie)session.load(Movie.class, new Integer(11));

        session.delete(m);
        session.getTransaction().commit();
    }

    public void persistTrade() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Trade t = new Trade();
        t.setQuantity(1);
        t.setSecure("secured");

        session.save(t);
        session.getTransaction().commit();
    }

    public void persistEmployee() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Employee e = new Employee();
        e.setName("Marvin Arcilla");

        session.save(e);
        session.getTransaction().commit();
    }

    public void persistCourse() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Course c = new Course();
        CoursePK cpk = new CoursePK();
        cpk.setTitle("Hibernate 101");
        cpk.setTutor("Marvin Arcilla");

        c.setId(cpk);
        c.setTotalStudents(8);
        c.setRegisteredStudents(10);

        session.save(c);
        session.getTransaction().commit();
    }

    public void deleteCourse() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        CoursePK cpk = new CoursePK();
        cpk.setTitle("Hibernate 101");
        cpk.setTutor("Marvin Arcilla");
        Course c = (Course)session.load(Course.class, cpk);

        session.delete(c);
        session.getTransaction().commit();
    }

    public void persistCourse2() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Course2 c = new Course2("Computer Science", "Marvin Arcilla");
        CoursePK2 cpk = new CoursePK2();
        cpk.setTitle("Hibernate 102");
        cpk.setTutor("Marvin Arcilla");

        c.setTotalStudents(20);
        c.setRegisteredStudents(30);

        session.save(c);
        session.getTransaction().commit();
    }

    public void findAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Course2> trades = session.createQuery("from Course2").list();
        session.getTransaction().commit();
        System.out.println("All Trades:" + trades.size());

        for (int i = 0; i< trades.size(); ++i) {
            System.out.println("Movie: " + trades.get(i).getRegisteredStudents());
        }
    }

}
