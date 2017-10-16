package dao;

import object.User;
import java.sql.Types;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class DAOUser {

	private static JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// This method add user.
	public void addUser(User user) {
		final String sql = "INSERT INTO userTable (Username, Email, Password) VALUES (?,?,?);";
		Object[] parametric = new Object[] { user.getUsername(), user.getEmail(), user.getPassword() };
		jdbcTemplate.update(sql, parametric);
	}

	// This method remove user.
	public  void removeUser(int index) {
		final String sql = "DELETE FROM userTable WHERE User_id ='?';";
		Object[] parameter = { index };
		int[] types = { Types.INTEGER };
		jdbcTemplate.update(sql, parameter, types);
	}

	// This method list user for debugging.
	public  List<User> ListUser() {
		final String sql = "SELECT User_id,Username, Email, Password FROM userTable";
		RowMapper<User> mapper = new UserRowMapping();
		List<User> Users = jdbcTemplate.query(sql, mapper);

		return Users;
	}
}