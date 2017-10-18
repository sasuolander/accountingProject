package accounting.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import accounting.object.User;

public class UserRowMapping implements RowMapper<User> {
	public User mapRow(ResultSet rs,int rowNum) throws SQLException{		
		User u = new User();
		u.setUser_id(rs.getInt("User_id"));
		u.setUsername(rs.getString("Username"));
		u.setEmail(rs.getString("Email"));
		u.setPassword(rs.getString("Password"));
		
		return u;
	}
}