package accounting.dao;

import java.util.List;
import accounting.object.User;

public interface DAOUser {
	public abstract void addUser(User user);
	// This method remove user.
	public abstract  void removeUser(int index);

	// This method list user for debugging.
	public abstract  List<User> ListUser();
		
	
	
}
