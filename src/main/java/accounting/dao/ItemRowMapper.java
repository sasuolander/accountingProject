package accounting.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import accounting.object.Item;

// this RowMapper is used for Item object.

public class ItemRowMapper  implements RowMapper<Item>{
	
	public Item mapRow(ResultSet rs,int rowNum) throws SQLException{
		Item i = new Item();
		i.setUser_id(rs.getInt("User_id"));
		i.setId(rs.getInt("Item_id"));
		i.setName(rs.getString("Item_Name"));
		i.setTimestamp(rs.getString("T_timetamp"));
		i.setPrice(rs.getDouble("Price"));
		return i;
	}	
}
