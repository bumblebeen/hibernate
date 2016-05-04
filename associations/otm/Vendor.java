package hibernate.associations.otm;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by arcilla on 5/4/16.
 */
@Entity
@Table(name = "VENDORS")
public class Vendor {

    @Id
    @Column(name = "VENDOR_ID")
    private int vendorId;

    @Column(name = "VENDOR_NAME")
    private String vendorName;

    @OneToMany(fetch=FetchType.LAZY, targetEntity=Customers.class, cascade= CascadeType.ALL)
    @JoinColumn(name = "VENDOR_ID", referencedColumnName="VENDOR_ID")
    private Set customers;

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public Set getCustomers() {
        return customers;
    }

    public void setCustomers(Set customers) {
        this.customers = customers;
    }
}
