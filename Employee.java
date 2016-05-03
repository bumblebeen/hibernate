package hibernate;

import javax.persistence.*;

/**
 * Created by arcilla on 5/2/16.
 */
@Entity
@Table(name = "TBL_EMPLOYEE")
public class Employee {

    @Id
    @Column(name = "EMPLOYEE_ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "empSeqGen", sequenceName = "EMP_SEQ_GEN")
    private int id =0;

    @Column(name = "EMPLOYEE_NAME")
    private String name = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
