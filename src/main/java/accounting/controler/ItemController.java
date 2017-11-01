package accounting.controler;



import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import accounting.dao.DAOItem;

import accounting.object.Item;

import java.util.List;



//(/item)
@RestController
@RequestMapping("/item")
public class ItemController {
	
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
	DAOItem dao =(DAOItem)context.getBean("itemDao");
	
	
	
	//(/item/add_item)
	@RequestMapping(value="/add_item",method = RequestMethod.POST)
	public @ResponseBody String addItem(@RequestBody Item item) {
		
		dao.addItem(item);
		return "Added item "+item.getName();
		
	}
	
	//(/item/remove_item)
	@RequestMapping(value="/remove_item/{id}", method = RequestMethod.PUT)
	public String removeItem(@PathVariable int id) {
		
		dao.removeItem(id);
		return "Removed item is "+id;
		
	}
	
	//(/item/list_item)
	
	@RequestMapping(value="/list_item",method = RequestMethod.GET)
	public @ResponseBody List<Item> listItem() {
		/*List<Item>testi =dao.ListItem();
		for (int i=0; i<testi.size() ;i++){
			
		System.out.println(testi.indexOf(i));	
		}
		*/
		
		List<Item> ItemsList=dao.ListItemView();
		
		return ItemsList;
		//return dao.ListItem();
		
	}
	//(/item/list_itemdebug)
	@RequestMapping(value="/list_itemdebug",method = RequestMethod.GET)
	public @ResponseBody List<Item> listItemdebug() {
		/*List<Item>testi =dao.ListItem();
		for (int i=0; i<testi.size() ;i++){
			
		System.out.println(testi.indexOf(i));	
		}
		*/
		
		List<Item> ItemsList=dao.ListItem();
		
		return ItemsList;
		//return dao.ListItem();
		
	}
	
}
