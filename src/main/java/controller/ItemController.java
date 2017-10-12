package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.boot.*;


//(/item)
@RequestMapping("/item")
public class ItemController {
	
	@RequestMapping
	public String defaultResult(){
		return null;
	}
	 

	//(/item/add_item)
	@RequestMapping("/add_item")
	public String addItem() {
		
		
		return null;
		
	}
	
	//(/item/remove_item)
	@RequestMapping("/remove_item")
	public String removeItem() {
		return null;
		
	}
	
	//(/item/List_item)
	@RequestMapping("/List_item")
	public String listItem() {
		return null;
		
	}
	
}
