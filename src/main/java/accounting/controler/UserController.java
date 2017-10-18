package accounting.controler;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import accounting.dao.DAOUser;
import accounting.object.User;

//(/user)


public class UserController {
	DAOUser dao = new DAOUser();
//(/user/login)
	@RequestMapping(value="/login/{user}" ,method=RequestMethod.GET)
	public String login (){
		return null;
		
	}

//(/user/update)
	@RequestMapping(value="/update" ,method=RequestMethod.PUT)
	public String update(){
		return null;
		
	}


//(/user/update/password)
	@RequestMapping(value="/update/password" ,method=RequestMethod.PUT)
	public String password(){
		return null;
		
	}

//(/user/register)
	@RequestMapping(value="/register/{user}",method=RequestMethod.PUT)
	public String register(@PathVariable User user){
		dao.addUser(user);
		
		
		return "Added user is named as "+user.getUsername();
		
	}

//(/user/count)
	@RequestMapping(value="/count" ,method=RequestMethod.GET)
	public int count() {
		List<User> Users=dao.ListUser();
		int count=Users.size();
		return count;
		
	}

}