package dao;

import object.Item;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

//SELECT Item_name,UT.Username,Price, T_timetamp FROM shared_burden AS SB
//JOIN userTable AS UT  ON  SB.User_ID = UT.User_ID;

public class ItemRowMapper  implements RowMapper<Item>{
	
	public Item mapRow(ResultSet rs,int rowNum) throws SQLException{
		Item i = new Item();
		i.setId(rs.getInt("Item_is"));
		i.setUsername(rs.getString("Username"));
		i.setName(rs.getString("Item_Name"));
		i.setTimestamp(rs.getDate("T_timestamp"));
		return i;
	}	
}
