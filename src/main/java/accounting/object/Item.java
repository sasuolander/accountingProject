package accounting.object;


import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;




public class Item extends User{

	//	Item_id INT AUTO_INCREMENT NOT NULL,
	//	Item_name varchar(255),
	//	T_timetamp TIMESTAMP,
	//	Price varchar(255),
	
	//@JsonProperty("Item_id")
	private int Item_id;
	@Size(min = 1, max=255)
	//@JsonProperty("Item_name")
	private String Item_name;
	//DDMMyyyyhhmmss
	//20122012126060
	//DD.MM.yyyy hh:mm:ss 
	// patt
	//@JsonProperty("Item_timestamp")
	private String Item_timestamp;
	//@JsonProperty("Item_price")
	@Size(min = 1, max=255)
	private double Item_price;
	
	public int getId() {
		return Item_id;
	}
	public void setId(int id) {
		Item_id = id;
	}
	public String getName() {
		return Item_name;
	}
	public void setName(String name) {
		this.Item_name = name;
	}
	public String getTimestamp() {
		return Item_timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.Item_timestamp = timestamp;
	}
	
	public double getPrice() {
		return Item_price;
	}
	public void setPrice(double price) {
		this.Item_price = price;
	}
	@Override
	public String toString() {
		return "Item Id=" + Item_id +"userID"+super.toString()+ ", name=" + Item_name + ", timestamp=" + Item_timestamp;
	}
	public Item(int id,int userid, String name, String timestamp, double price) {
		super.User_id=userid;
		this.Item_id = id;
		this.Item_name = name;
		this.Item_timestamp = timestamp;
		this.Item_price=price;
	}
	public Item() {
		super();
		this.Item_id = 0;
		this.Item_name = null;
		this.Item_timestamp = null;
		this.Item_price =0;
	}
}
