package accounting.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import accounting.object.Item;

//This RowMapper is used when printing information to view. 
//SELECT Item_name,UT.Username,Price, T_timetamp FROM shared_burden AS SB
//JOIN userTable AS UT  ON  SB.User_ID = UT.User_ID;
public class ItemRowMapperView  implements RowMapper<Item>{
	public Item mapRow(ResultSet rs,int rowNum) throws SQLException{
		Item i = new Item();
		i.setName(rs.getString("Item_name"));
		i.setUsername(rs.getString("Username"));
		i.setPrice(rs.getDouble("Price"));
		i.setTimestamp(rs.getString("T_timetamp"));
		return i;
	}	
}