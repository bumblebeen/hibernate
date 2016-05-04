package hibernate;

/**
 * Created by arcilla on 4/29/16.
 */
public class main {

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        sm.initSessionFactory();
        System.out.println("Initialized!");

        sm.persistStudent();

        System.out.println("Saved!");
    }
}
