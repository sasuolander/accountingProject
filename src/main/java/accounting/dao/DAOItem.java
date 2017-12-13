package accounting.dao;
import java.util.List;
import accounting.object.Item;

public interface DAOItem {
	public abstract  void addItem(Item item);
	// This method delete Item based on inputed index value.
	public abstract  void removeItem(int index);
	// This method create table of item which is for debugging.
	public abstract List<Item> ListItem();
	// This method create table of item which is user friendly
	public abstract  List<Item> ListItemView();
}