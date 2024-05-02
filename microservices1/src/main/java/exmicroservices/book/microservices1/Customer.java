package exmicroservices.book.microservices1;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import jakarta.persistence.Entity;

@Entity
@jakarta.persistence.Table(name="imported_car")
public class Customer {
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer TransportID;
	String FirstName;
	String LastName;
	String ShipperName;
	String LicensePlate;
	String DeliveryDate;
	String AlreadyShipped;
	//พร้อม getter และ setter
	
	public Customer() {
	}
	
	
	public Customer(Integer TransportID, String FirstName,String LastName , String ShipperName, String LicensePlate , String DeliveryDate, String AlreadyShipped) {
		super();
		this.TransportID = TransportID;
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.ShipperName = ShipperName;
		this.LicensePlate = LicensePlate;
		this.DeliveryDate = DeliveryDate;
		this.AlreadyShipped = AlreadyShipped;
	}
	public Integer getId() {
		return TransportID;
	}
	public void setId(Integer TransportID) {
		this.TransportID = TransportID;
	}
	public String firstName() {
		return FirstName;
	}
	public void setfirstName(String FirstName) {
		this.FirstName = FirstName;
	}
	public String lastName() {
		return LastName;
	}
	public void setlastName(String LastName) {
		this.LastName = LastName;
	}
	
	public String getShipperName() {
		return ShipperName;
	}
	public void setShipperName(String ShipperName) {
		this.ShipperName = ShipperName;
	}
	public String getLicensePlate() {
        return LicensePlate;
    }

    public void setLicensePlate(String LicensePlate) {
        this.LicensePlate = LicensePlate;
    }

    public String getDeliveryDate() {
        return DeliveryDate;
    }

    public void setDeliveryDate(String DeliveryDate) {
        this.DeliveryDate = DeliveryDate;
    }

    public String getAlreadyShipped() {
        return AlreadyShipped;
    }

    public void setAlreadyShipped(String alreadyShipped) {
        this.AlreadyShipped = alreadyShipped;
    }
}
