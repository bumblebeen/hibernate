package hibernate.collections.listAnnotation;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.List;

/**
 * Created by arcilla on 5/2/16.
 */
@Entity(name = "SHOWROOM_LIST_ANN")
@Table(name = "SHOWROOM_LIST_ANN")
public class Showroom {
    @Id
    @Column(name = "SHOWROOM_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id = 0;

    @OneToMany
    @JoinColumn(name="SHOWROOM_ID")
    @Cascade(CascadeType.ALL)
    private List<Car> cars = null;

    private String manager = null;
    private String location = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
