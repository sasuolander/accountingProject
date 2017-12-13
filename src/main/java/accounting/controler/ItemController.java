package accounting.controler;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import accounting.dao.DAOItem;
import accounting.object.Item;
import accounting.object.User;

//(/item)
@RestController
@RequestMapping("/item")
public class ItemController {
	
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
	DAOItem dao =(DAOItem)context.getBean("itemDao");
	
	//(/item/add_item)
	@RequestMapping(value="/add_item",method = RequestMethod.POST)
	public @ResponseBody String addItem(@RequestBody User user) {
		int id=user.getUser_id();
		Item item =user.getItems().get(0);
		dao.addItem(id, item);
		return "Added item "+item.getName();
	}
	//(/item/remove_item)
	@RequestMapping(value="/remove_item/{id}", method = RequestMethod.PUT)
	public String removeItem(@PathVariable int id) {
		dao.removeItem(id);
		return "Removed item is "+id;
	}
	//(/item/list_item)
	@RequestMapping(value="/list_item/{i}",method = RequestMethod.GET)
	public @ResponseBody List<User> listItem(@PathVariable int i) {
		List<User> ItemsList=dao.listItemPerUser(i);
		return ItemsList;
	}
	//(/item/list_itemdebug)
	@RequestMapping(value="/list_item",method = RequestMethod.GET)
	public @ResponseBody List<Item> listItemdebug() {
		List<Item> ItemsList=dao.listItem();
		return ItemsList;
	}
	
	@RequestMapping(value="/list_itemAll",method = RequestMethod.GET)
	public @ResponseBody List<User> listItemAll() {
		List<User> ItemsList=dao.listItemByAll();
		return ItemsList;
	}
}