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
		Map<Integer,User> map = new HashMap<Integer,User>();
		User userOb = null;
		List<Item>items=new ArrayList<Item>();
		
		Item i = null;	
		while(rs.next()){
			Integer id = rs.getInt("User_id");			
			userOb= map.get(id);
			if (userOb==null){
				userOb = new User();
				userOb.setUsername(rs.getString("Username"));
				userOb.setUser_id(rs.getInt("User_id"));
				
				map.put(id, userOb);
			}
			//int itemID= rs.getInt("Item_id");
			//if (itemID ==null){
			
			i = new Item(rs.getInt("Item_id"), rs.getString("Item_Name"), rs.getString("T_timetamp"), rs.getDouble("Price"));
			int userIdcheck = rs.getInt("User_id");
			userOb.setItems(items);
			userOb.add(i);
				
			//}
		}
		return new ArrayList<User>(map.values());
	}
}