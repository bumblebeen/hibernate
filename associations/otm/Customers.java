package hibernate.associations.otm;

import javax.persistence.*;

/**
 * Created by arcilla on 5/4/16.
 */
@Entity
@Table(name = "CUSTOMERS")
public class Customers {
    @Id
    @Column(name = "CUSTOMER_ID")
    private int customerId;

    @Column(name="CUSTOMER_NAME")
    private String customerName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "VEND_ID", referencedColumnName = "VENDOR_ID")
    private Vendor vendors;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Vendor getVendors() {
        return vendors;
    }

    public void setVendors(Vendor vendors) {
        this.vendors = vendors;
    }
}
