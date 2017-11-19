package accounting.object;

import javax.validation.constraints.Size;

public class Item {
	//@JsonProperty("Item_id")
	private int Item_id;
	@Size(min = 1, max=255)
	//@JsonProperty("Item_name")
	private String Item_name;
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
	public Item(int id, String name, String timestamp, double price) {
		
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