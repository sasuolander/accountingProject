package accounting.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import accounting.object.Item;
import accounting.object.User;

//This RowMapper is used when printing information to view. 
//SELECT Item_name,UT.Username,Price, T_timetamp FROM shared_burden AS SB
//JOIN userTable AS UT  ON  SB.User_ID = UT.User_ID;
public class ItemRowMapperView  implements RowMapper<User>{
	public User mapRow(ResultSet rs,int rowNum) throws SQLException{
		Item i = new Item();
		i.setName(rs.getString("Item_name"));
		String username =rs.getString("Username");
		i.setPrice(rs.getDouble("Price"));
		i.setTimestamp(rs.getString("T_timetamp"));
		List<Item>items=new ArrayList<>();
		items.add(i);
		User u = new User(username, items);
		return u;
	}	
}