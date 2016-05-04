package hibernate.associations.mtm;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by arcilla on 5/4/16.
 */
@Entity
@Table(name="items")
public class Items
{
    @Id
    @Column(name="itemid")
    private int itemId;
    @Column(name="itemname",length=10)
    private String itemName;

    @ManyToMany(targetEntity=Categories.class,mappedBy="items")
    private Set categories;

    public Set getCategories() {
        return categories;
    }
    public void setCategories(Set  categories) {
        this.categories = categories;
    }
    public int getItemId() {
        return itemId;
    }
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}