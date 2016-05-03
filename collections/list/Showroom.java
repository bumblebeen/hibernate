package hibernate.collections.list;

import java.util.List;

/**
 * Created by arcilla on 5/2/16.
 */
public class Showroom {

    private int id = 0;

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
