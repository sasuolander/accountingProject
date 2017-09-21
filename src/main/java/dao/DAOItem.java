package dao;

import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;

import object.Item;
import object.User;

public class DAOItem {
	
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public static void addItem(){
		
	}
	
	public static void removeItem(int index){
		
	}
	
	public static ArrayList<Item> ListItem(){
		return null;
	}
	
	

}
