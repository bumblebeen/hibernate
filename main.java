package hibernate;

/**
 * Created by arcilla on 4/29/16.
 */
public class main {

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        sm.initSessionFactory();
        System.out.println("Initialized!");

        sm.persistAMovie();

        System.out.println("Saved!");

        sm.findAll();

        System.out.println("Deleting!");

        sm.deleteAMovie();

        System.out.println("Deleted!");

        sm.findAll();
    }
}
