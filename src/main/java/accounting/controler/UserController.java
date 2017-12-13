package accounting.controler;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import accounting.dao.DAOUser;
import accounting.object.User;

//(/user)

@RestController
@RequestMapping("/user")
public class UserController {

	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
	DAOUser dao =(DAOUser)context.getBean("userDao");
	
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
	@RequestMapping(value="/register",method=RequestMethod.PUT)
	public @ResponseBody String register(@RequestBody User user){
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