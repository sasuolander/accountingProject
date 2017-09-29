package object;

import java.util.Date;
import javax.validation.constraints.Size;

public class Item extends User{

	//	Item_id INT AUTO_INCREMENT NOT NULL,
	//	Item_name varchar(255),
	//	T_timetamp TIMESTAMP,
	//	Price varchar(255),
	
	private int Id;
	@Size(min = 1, max=255)
	private String name;
	private Date timestamp;
	@Size(min = 1, max=255)
	private double price;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Item Id=" + Id +"userID"+super.toString()+ ", name=" + name + ", timestamp=" + timestamp;
	}
	public Item(int id,int userid, String name, Date timestamp, double price) {
		super.User_id=userid;
		this.Id = id;
		this.name = name;
		this.timestamp = timestamp;
		this.price=price;
	}
	public Item() {
		super();
		this.Id = 0;
		this.name = null;
		this.timestamp = null;
		this.price =0;
	}
}
