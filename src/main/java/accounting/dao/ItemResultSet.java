package accounting.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import accounting.object.Item;
import accounting.object.User;

public class ItemResultSet implements ResultSetExtractor{

	@Override
	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		Map<String,User> items = new HashMap<String,User>();
		
		while(rs.next()){
			User userOb = items.get(rs.getString("Item_id"));
			
			if (userOb==null){
				userOb = new User();
				userOb.setUser_id(rs.getInt("User_id"));
			}
			
			Item i = new Item();
			i.setId(rs.getInt("Item_id"));
			i.setName(rs.getString("Item_Name"));
			i.setTimestamp(rs.getString("T_timetamp"));
			i.setPrice(rs.getDouble("Price"));
			
			userOb.getItems().add(i);
			
		}
		return items;
	}

	
	
}
