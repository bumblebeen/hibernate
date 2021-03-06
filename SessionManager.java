package hibernate;

import hibernate.associations.Address;
import hibernate.associations.Student;
import hibernate.associations.mtm.Categories;
import hibernate.associations.mtm.Items;
import hibernate.associations.otm.Customers;
import hibernate.associations.otm.Vendor;
import hibernate.collections.listAnnotation.Car;
import hibernate.collections.listAnnotation.Showroom;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
                .addAnnotatedClass(CoursePK2.class)
                .addAnnotatedClass(Showroom.class)
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(Vendor.class)
                .addAnnotatedClass(Customers.class)
                .addAnnotatedClass(Categories.class)
                .addAnnotatedClass(Items.class);
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

    public void persistShowroom() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Showroom showroom = new Showroom();
        showroom.setLocation("East Croydon, Greater London");
        showroom.setManager("Barry Larry");
        // Create list of cars
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Toyota", "Racing Green"));
        cars.add(new Car("Toyota", "Racing Green"));
        cars.add(new Car("Nissan", "White"));
        cars.add(new Car("BMW", "Black"));
        cars.add(new Car("Mercedes", "Silver"));
        // Associate cars to the showroom
        showroom.setCars(cars);
        // Save the showroom
        session.save(showroom);
        session.getTransaction().commit();
    }

    public void persistStudent() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Student s = new Student();
        s.setStudentId(101);
        s.setStudentName("James");
        s.setGrp("mpc");

        Address  ad = new Address();
        ad.setAddressId(1);
        ad.setPlace("Carolina");

        ad.setStudent(s);
        // Save the showroom
        session.save(ad);
        session.getTransaction().commit();
    }

    public void persistVendor() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Vendor v=new Vendor();
        v.setVendorId(100);
        v.setVendorName("java4s");

        Customers c1=new Customers();
        c1.setCustomerId(500);
        c1.setCustomerName("customer1");
        c1.setVendors(v);

        Customers c2=new Customers();
        c2.setCustomerId(501);
        c2.setCustomerName("The Marb");
        c2.setVendors(v);

        // Save the showroom
        session.save(c1);
        session.save(c2);
        session.getTransaction().commit();
    }

    public void persistItemsAndCategories() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Categories c1 = new Categories();
        c1.setCategoryId(1);
        c1.setCategoryName("cat 1");

        Categories c2=new Categories();
        c2.setCategoryId(2);
        c2.setCategoryName("cat 2");

        Items i1=new Items();
        Items i2 = new Items();

        i1.setItemId(101);
        i1.setItemName("item1");

        i2.setItemId(102);
        i2.setItemName("item2");

        Set s =new HashSet();
        s.add(i1);
        s.add(i2);

        c1.setItems(s);
        c2.setItems(s);


        // Save the showroom
        session.save(c1);
        session.save(c2);
        session.getTransaction().commit();
    }

    public void findAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Car> trades = session.createQuery("from Car").list();
        session.getTransaction().commit();
        System.out.println("All Trades:" + trades.size());

        for (int i = 0; i< trades.size(); ++i) {
            System.out.println("Movie: " + trades.get(i).getName());
        }
    }

}
