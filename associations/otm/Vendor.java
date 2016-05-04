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
}
