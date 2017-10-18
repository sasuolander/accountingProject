import java.util.List;

import dao.DAOItem;
import dao.DAOUser;
import object.Item;
import object.User;


public class TesttingDAON {

	public static void main(String[] args) {
		DAOItem itemD = new DAOItem();
		DAOUser userD = new DAOUser();
		
		List<Item> items= itemD.ListItem();
		List<Item> itemsView= itemD.ListItemView();
	
		List<User> users= userD.ListUser();
		System.out.println("Listing");
		for (int i = 0; i < items.size(); i++) {
			System.out.println(items.get(i)+"\n");
		}
		System.out.println("Listed");
		System.out.println("Listing");
		for (int i = 0; i < itemsView.size(); i++) {
			System.out.println(itemsView.get(i)+"\n");
		}
		System.out.println("Listed");
		System.out.println("Listing");
		for (int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i)+"\n");
		}
		System.out.println("Listed");

	}

}
