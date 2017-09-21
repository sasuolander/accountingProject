package dao;

import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;

import object.User;

public class DAOUser {
	
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public static void addUser(){
		
	}
	
	public static void removeUser(){
		
	}
	
	public static ArrayList<User> ListUser(){
		return null;
	}
}
