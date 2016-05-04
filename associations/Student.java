package hibernate.associations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by arcilla on 5/4/16.
 */
@Entity
@Table(name = "STUDENTS")
public class Student {
    @Id
    @Column(name = "STUDENT_ID")
    private int studentId;

    @Column(name = "STUDENT_NAME", length = 50)
    private String studentName;

    @Column(name = "GRP", length = 10)
    private String grp;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getGrp() {
        return grp;
    }

    public void setGrp(String grp) {
        this.grp = grp;
    }
}
