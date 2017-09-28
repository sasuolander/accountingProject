package dao;

import object.Item;
import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class DAOItem {

	// Injection
	private static JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// Injection
	private static NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public static void addItem(Item item) {
		// INSERT INTO shared-burden
		// VALEUS(User_id,Item_id,Item_name,T_timetamp,Price)"
		final String sql = "INSERT INTO shared-burden (User_id, Item_id, Item_name, T_timetamp, Price ) VALEUS(:User_id,:Id,:name,:timestamp,:price)";
		// NamedParameterJdbcTemplate
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(item);

		namedParameterJdbcTemplate.update(sql, namedParameters);
	}

	// This method delete Item based on inputed index value.
	public static void removeItem(int index) {
		Object[] parameter = { index };
		final String sql = "DELETE FROM shared-burden WHERE ITEM_id ='?';";
		int[] types = { Types.INTEGER };
		jdbcTemplate.update(sql, parameter, types);
	}

	// This method create table of item which is for debugging.
	public static List<Item> ListItem() {
		final String sql = "SELECT User_id, Item_id, Item_name, T_timetamp, Price FROM shared-burden";
		RowMapper<Item> mapper = new ItemRowMapper();
		List<Item> Items = jdbcTemplate.query(sql, mapper);

		return Items;
	}

	// This method create table of item which is user friendly
	public static List<Item> ListItemView() {
		final String sql = "SELECT Item_name,UT.Username,Price, T_timetamp FROM shared_burden AS SB"
				+ "JOIN userTable AS UT  ON  SB.User_ID = UT.User_ID;";
		RowMapper<Item> mapper = new ItemRowMapperView();
		List<Item> Items = jdbcTemplate.query(sql, mapper);

		return Items;
	}
}