package accounting.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import accounting.dao.DAOItem;
import accounting.object.Item;

import java.util.List;

import org.springframework.boot.*;


//(/item)
@RequestMapping("/item")
public class ItemController {
	DAOItem dao = new DAOItem();
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Item> defaultResult(){
		return dao.ListItem();
	}
	 

	//(/item/add_item)
	@RequestMapping(value="/add_item",method = RequestMethod.POST)
	public @ResponseBody String addItem(@RequestBody Item item) {
		
		dao.addItem(item);
		return "Item named as"+item.getName()+"has been added";
		
	}
	
	//(/item/remove_item)
	@RequestMapping(value="/remove_item/{id}", method = RequestMethod.PUT)
	public String removeItem(@PathVariable int id) {
		
		dao.removeItem(id);
		return "Removed item is "+id;
		
	}
	
	//(/item/List_item)
	@RequestMapping("/List_item")
	public @ResponseBody List<Item> listItem() {
		return dao.ListItem();
		
	}
	
}
