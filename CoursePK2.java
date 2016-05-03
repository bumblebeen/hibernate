package hibernate;

import java.io.Serializable;

/**
 * Created by arcilla on 5/2/16.
 */
public class CoursePK2 implements Serializable {
    private String tutor = null;
    private String title = null;

    public CoursePK2() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
