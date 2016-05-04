package hibernate.associations;

import javax.persistence.*;

/**
 * Created by arcilla on 5/4/16.
 */
@Entity
@Table(name = "Address")
public class Address {
    @Id
    @Column(name = "ADDRESS_ID")
    private int addressId;

    @Column(name = "PLACE", length = 10)
    private String place;

    @OneToOne(targetEntity = Student.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "STUD_ID", referencedColumnName = "STUDENT_ID")
    private Student student;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
