package hibernate;

/**
 * Created by arcilla on 4/29/16.
 */
public class main {

    public static void main(String[] args) {
        MovieManager mm = new MovieManager();
        mm.initSessionFactory();
        System.out.println("Initialized!");

        Movie m = new Movie();
        m.setId(4);
        m.setTitle("Civil WarTut");
        m.setDirector("Bogart the Explorer");
        m.setSynopsis("One of the major war in the Marvel universe");
        mm.persistAMovie(m);

        System.out.println("Saved!");

        System.out.println("Displaying all trades");
        mm.findAll();
    }
}
