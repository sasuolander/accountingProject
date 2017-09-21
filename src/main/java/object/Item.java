package object;

import java.util.Date;

public class Item extends User{

	//	Item_id INT AUTO_INCREMENT NOT NULL,
	//	Item_name varchar(255),
	//	T_timetamp TIMESTAMP,
	//	Price varchar(255),
	
	private int Id;
	private String name;
	private Date timestamp;
	
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
	@Override
	public String toString() {
		return "Item Id=" + Id +"userID"+super.toString()+ ", name=" + name + ", timestamp=" + timestamp;
	}
	public Item(int id,int userid, String name, Date timestamp) {
		super();
		Id = id;
		this.name = name;
		this.timestamp = timestamp;
	}
	public Item() {
		super();
		Id = 0;
		this.name = null;
		this.timestamp = null;
	}
}
