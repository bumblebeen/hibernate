package hibernate;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by arcilla on 5/3/16.
 */
@Embeddable
public class CoursePK implements Serializable{
    private String tutor = null;
    private String title = null;

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

    public CoursePK() {

    }
}
