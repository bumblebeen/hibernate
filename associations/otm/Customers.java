package hibernate.associations.otm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
}
