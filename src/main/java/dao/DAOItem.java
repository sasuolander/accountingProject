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
		
		
	}
	
	public static void removeItem(int index){
		Object[] parameter ={index};
		final String sql = "DELETE FROM shared-burden WHERE ITEM_id ='?';";
		int[] types ={Types.INTEGER};
		jdbcTemplate.update(sql,parameter,types);
	
	}
	
	public static ArrayList<Item> ListItem(){
		return null;
	}
	
	

}
