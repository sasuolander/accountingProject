package accounting.dao;

import java.sql.Types;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import accounting.object.Item;

public class DAOItemImpl  implements DAOItem{
	// Injection
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void setDataSource2(DataSource dataSource) {
	    this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// Injection
	private static NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	//This method is used to add item
	public void addItem(Item i) {
		final String sql = "INSERT INTO shared_burden (User_id, Item_name, Price ) VALUES(?,?,?);";
		Object[] paramet = new Object[] { i.getUser_id(),i.getName(), i.getPrice() };
		jdbcTemplate.update(sql,paramet);
	}

	// This method delete Item based on inputed index value.
	public  void removeItem(int index) {
		Object[] parameter = { index };
		final String sql = "DELETE FROM shared_burden WHERE Item_id =?;";
		int[] types = { Types.INTEGER };
		//jdbcTemplate.update(sql, parameter);
		jdbcTemplate.update(sql, parameter, types);
	}
	// This method create table of item which is for debugging.
	public List<Item> ListItem() {
		final String sql = "SELECT User_id, Item_id, Item_name, T_timetamp, Price FROM shared_burden;";
		RowMapper<Item> mapper = new ItemRowMapper();
		List<Item> Items = jdbcTemplate.query(sql, mapper);
		return Items;
	}
	// This method create table of item which is user friendly
	public List<Item> ListItemView() {
		final String sql = "SELECT Item_name,UT.Username,Price, T_timetamp FROM shared_burden AS SB JOIN userTable AS UT  ON  SB.User_ID = UT.User_ID;";
		RowMapper<Item> mapper = new ItemRowMapperView();
		List<Item> Items = jdbcTemplate.query(sql, mapper);
		return Items;
	}
}