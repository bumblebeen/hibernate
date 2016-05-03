package hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by arcilla on 5/2/16.
 */
@Entity
@Table(name = "COURSES")
public class Course {
    @Id
    private CoursePK id = null;
    private int totalStudents = 0;
    private int registeredStudents = 0;

    public int getRegisteredStudents() {
        return registeredStudents;
    }

    public void setRegisteredStudents(int registeredStudents) {
        this.registeredStudents = registeredStudents;
    }

    public int getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(int totalStudents) {
        this.totalStudents = totalStudents;
    }

    public CoursePK getId() {
        return id;
    }

    public void setId(CoursePK id) {
        this.id = id;
    }
}
