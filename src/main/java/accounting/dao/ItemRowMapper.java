package accounting.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import accounting.object.Item;
import accounting.object.User;

// this RowMapper is used for Item object.
public class ItemRowMapper  implements RowMapper<User>{
	public User mapRow(ResultSet rs,int rowNum) throws SQLException{
		Item i = new Item();
		
		
		int user_id=rs.getInt("User_id");
		i.setId(rs.getInt("Item_id"));
		i.setName(rs.getString("Item_Name"));
		i.setTimestamp(rs.getString("T_timetamp"));
		i.setPrice(rs.getDouble("Price"));
		List<Item>items=new ArrayList<>();
		items.add(i);
		User u = new User(user_id, items);
		return u;
	}	
}