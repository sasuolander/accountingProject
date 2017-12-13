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
	public List<Item> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Item>items= new ArrayList<Item>();
		while(rs.next()){
			
			Item i = new Item(rs.getInt("Item_id"), rs.getString("Item_Name"),
					rs.getString("T_timetamp"), rs.getDouble("Price"));
			items.add(i);
		}
		return items;
	}
}