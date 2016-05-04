package hibernate.associations.mtm;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by arcilla on 5/4/16.
 */
@Entity
@Table(name="categories")
public class Categories
{
    @Id
    @Column(name="catid")
    private int categoryId;
    @Column(name="catname",length=10)
    private String categoryName;
    @ManyToMany(targetEntity=Items.class,cascade=CascadeType.ALL)
    @JoinTable(name="categories_items",
            joinColumns=@JoinColumn(name="cat_id_fk",referencedColumnName="catid"),
            inverseJoinColumns=@JoinColumn(name="item_id_fk",referencedColumnName="itemid"))
    private Set items;

    public int getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    public Set getItems() {
        return items;
    }
    public void setItems(Set items) {
        this.items = items;
    }
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryname) {
        this.categoryName = categoryname;
    }
}
