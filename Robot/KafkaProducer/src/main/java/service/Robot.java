package service;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import jakarta.persistence.Entity;

@Entity
@jakarta.persistence.Table(name="dbo_imported_robot")
public class Robot {
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer RobotID;
	String InventorySpaceKey;
	String Qrcode;
	String OrderDate;
	String AlreadyMoved;
	//พร้อม getter และ setter
	
	public Robot() {
	}
	
	
	public Robot(Integer RobotID, String InventorySpaceKey,String LicensePlate , String DeliveryDate, String AlreadyShipped) {
		super();
		this.RobotID = RobotID;
		this.InventorySpaceKey = InventorySpaceKey;
		this.Qrcode = Qrcode;
		this.OrderDate = OrderDate;
		this.AlreadyMoved = AlreadyMoved;
	}
	public Integer getRobotId() {
		return RobotID;
	}
	public void setRobotId(Integer TransportID) {
		this.RobotID = RobotID;
	}


	public String getInventorySpaceKey() {
		return InventorySpaceKey;
	}
	public void setInventorySpaceKey(String LastName) {
		this.InventorySpaceKey = InventorySpaceKey;
	}
	

	public String getQrcode() {
        return Qrcode;
    }

    public void setQrcode(String Qrcode) {
        this.Qrcode = Qrcode;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String OrderDate) {
        this.OrderDate = OrderDate;
    }

    public String getAlreadyMoved() {
        return AlreadyMoved;
    }

    public void setAlreadyMoved(String alreadyMoved) {
        this.AlreadyMoved = alreadyMoved;
    }
}
