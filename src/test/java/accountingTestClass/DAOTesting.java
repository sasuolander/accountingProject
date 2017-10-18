package accountingTestClass;

import dao.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import  static org.mockito.Mockito.mock;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import accounting.dao.DAOItem;
import accounting.dao.DAOUser;
import accounting.object.Item;
import accounting.object.User;

public class DAOTesting {
	
	@Before
	public void setup() {
		//Mockito.doReturn(value);
	       
	       
		
		DAOItem dao =new DAOItem();
		
		DAOItem mockitoItem = mock(DAOItem.class);
		DAOUser mockitoUser = mock(DAOUser.class);

		Item item = new Item(4, 1, "cash", "201220121260600", 30.2);
		User user = new User(1, "tommi", "tiina@koti.fi", "tommi");
		
		ArrayList<Item> Items = new ArrayList<Item>();
		ArrayList<User> Users = new ArrayList<User>();

		Items.add(new Item(1, 1, "cash", "201220121260600", 30.2));
		Items.add(new Item(2, 3, "tee", "20122012126060", 20.2));
		Items.add(new Item(3, 4, "compuuter", "20122012126060", 40.0));

		Users.add(new User(1, "tommi", "tiina@koti.fi", "tommi"));
		Users.add(new User(2, "heikki", "tiina@koti.fi", "heikki"));
		Users.add(new User(3, "tiina", "tiina@koti.fi", "tiina"));
	
		//Mockito.doCallRealMethod().when(dao.addItem(item)).thenReturn(true);

	}
}