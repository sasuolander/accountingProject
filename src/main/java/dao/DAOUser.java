package dao;

import java.sql.Types;
import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;

import object.User;

public class DAOUser {
	
	private static JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public static void addUser(User user){
		final String sql ="INSERT INTO userTable (User_id, Username, Email, Password) VALUES (?,?,?,?);";
	}
	
	public static void removeUser(int index){
		Object[] parameter ={index};
		final String sql = "DELETE FROM userTable WHERE User_id ='?';";
		int[] types ={Types.INTEGER};
		jdbcTemplate.update(sql,parameter,types);
	}
	
	public static ArrayList<User> ListUser(){
		return null;
	}
}
