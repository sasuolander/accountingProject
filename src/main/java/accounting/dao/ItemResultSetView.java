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

public class ItemResultSetView implements ResultSetExtractor{
	@Override
	public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<String,User> map = new HashMap<String,User>();
		User userOb = null;
		List<Item>items= new ArrayList<Item>();
		while(rs.next()){
			String id = rs.getString("Username");			
			 userOb= map.get(id);
			if (userOb==null){
				userOb = new User();
				userOb.setUsername(rs.getString("Username"));
				map.put(id, userOb);
			}
			userOb.setItems(items);
			Item i = new Item();		
			i.setName(rs.getString("Item_Name")); 
			i.setTimestamp(rs.getString("T_timetamp"));
			i.setPrice(rs.getDouble("Price"));
					
			userOb.add(i);
		}
		return new ArrayList<User>(map.values());
	}
}