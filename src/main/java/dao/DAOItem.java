package dao;

import java.sql.Types;
import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;

import object.Item;
import object.User;

public class DAOItem {
	
	private static JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public static void addItem(Item item){
		//INSERT INTO shared-burden VALEUS(User_id,Item_id,Item_name,T_timetamp,Price)"
		final String sql = "INSERT INTO shared-burden (User_id, Item_id, Item_name, T_timetamp, Price ) VALEUS(?,?,?,?,?)";
		
				
		
	}
	
	public static void removeItem(int index){
		Object[] parameter ={index};
		final String sql = "DELETE FROM shared-burden WHERE ITEM_id ='?';";
		int[] types ={Types.INTEGER};
		jdbcTemplate.update(sql,parameter,types);
	
	}
	
	public static ArrayList<Item> ListItem(){
		final String sql = "SELECT User_id, Item_id, Item_name, T_timetamp, Price FROM shared-burden";
		
		return null;
	}
	
	public static ArrayList<Item> ListItemView(){
		final String sql = "SELECT Item_name,UT.Username,Price, T_timetamp FROM shared_burden AS SB"
							+"JOIN userTable AS UT  ON  SB.User_ID = UT.User_ID;";
		
		return null;
	}
	
	

}
