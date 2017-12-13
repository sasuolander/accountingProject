package accounting.dao;
import java.util.List;
import accounting.object.Item;
import accounting.object.User;

public interface DAOItem {
	public abstract  void addItem(int Userid, Item i);
	// This method delete Item based on inputed index value.
	public abstract  void removeItem(int index);
	// This method create table of item which is for debugging.
	public abstract List<Item> listItem();
	// This method create table of item by using User_id
	public abstract  List<User> listItemPerUser(int i);
	// This method create table of item from all User
	public abstract  List<User> listItemByAll();
}