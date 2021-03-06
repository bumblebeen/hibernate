package hibernate.collections.listAnnotation;

import javax.persistence.*;

/**
 * Created by arcilla on 5/2/16.
 */
@Entity(name = "CAR_LIST_ANN")
@Table(name ="CAR_LIST_ANN")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CAR_ID")
    private int id;
    private String name = null;
    private String color = null;

    public Car(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
