package accounting.object;

import java.util.List;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

public class User {
	
	//@JsonProperty("User_id")
	protected int User_id;
	//@JsonProperty("Username")
	@Size(min = 1, max=255)
	private String Username;
	//@JsonProperty("Email")
	@Size(min = 1, max=255)
	@Email
	private String Email;
	//@JsonProperty("Password")
	@Size(min = 1, max=255)
	private String Password; //hashing algorythmis is going to be Bcrypt, 
	//datatype for database is binary(60)

	private List<Item> items;

	
	public void add(Item item){
		this.items.add(item);
	}
	
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public int getUser_id() {
		return User_id;
	}

	public void setUser_id(int user_id) {
		User_id = user_id;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public User(int user_id, String username, String email, String password) {
		super();
		User_id = user_id;
		Username = username;
		Email = email;
		Password = password;
	}
	
	public User(int user_id,List<Item>items) {
		super();
		this.User_id = user_id;
		this.items = items;
	}
	
	public User(String username,List<Item>items) {
		super();
		this.Username = username;
		this.items = items;
	}
	
	public User() {
		super();
		User_id = 0;
		Username = null;
		Email = null;
		Password = null;
		items = null;
	}
	//Hashing
	@Override
	public String toString() {
		return "UserObject User_id=" + User_id + ", Username=" +
	Username + ", Email=" + Email + ", Password=" + Password;
	}
}