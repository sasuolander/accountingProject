package accounting.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import accounting.object.Item;
import accounting.object.User;

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

	
	
	DAOUserImpl daoUser = new DAOUserImpl();
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// Injection
	private static NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	//This method is used to add item
	public void addItem(int Userid, Item i) {
		final String sql = "INSERT INTO shared_burden (User_id, Item_name, Price ) VALUES(?,?,?);";
		List<Item>items = new ArrayList();
		items.add(i);
		User a = new User(Userid, items);
		Item oneItem = a.getItems().get(0);
		Object[] paramet = new Object[] {a.getUser_id(),oneItem.getName(),oneItem.getPrice() };
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
	// This method create table of item .
	public List<Item> listItem() {
		final String sql = "SELECT User_id, Item_id, Item_name, T_timetamp, Price FROM shared_burden;";
		ItemResultSet mapper= new ItemResultSet();
		List<Item> Items = (List<Item>) jdbcTemplate.query(sql, mapper);
		return Items;
	}
	// This method create table of item by using User_id
	public List<User> listItemPerUser(int i) {
		Object[] parameter = { i };
		int[] types = { Types.INTEGER };
		final String sql = "SELECT Item_name,Item_id,UT.Username,UT.User_id,Price, T_timetamp FROM shared_burden AS SB JOIN userTable AS UT  ON  SB.User_ID = UT.User_ID WHERE UT.User_id =?;";
		ItemResultSetView mapper = new ItemResultSetView();
		List<User> Items = (List<User>) jdbcTemplate.query(sql, mapper,parameter);
		return Items;
	}
	
	public List<User> listItemByAll(){
		//List<User> users = null;
		List<User> BigList = new ArrayList<User>();
		
			final String sql2 = "SELECT User_id,Username, Email FROM userTable;";
			RowMapper<User> mapper2 = new UserRowMapping();
			List<User> users = jdbcTemplate.query(sql2, mapper2);
			
		for(int i =0;i<users.size();i++){
			final String sql = "SELECT Item_name,Item_id,UT.Username,UT.User_id,Price, T_timetamp FROM shared_burden AS SB JOIN userTable AS UT  ON  SB.User_ID = UT.User_ID WHERE UT.User_id =?;";
			Object[] parameter = { users.get(i).getUser_id()};
			int[] types = { Types.INTEGER };
			ItemResultSetView mapper = new ItemResultSetView();
			List<User> Items = (List<User>) jdbcTemplate.query(sql, mapper,parameter);
			User v = new User();
			v.setUser_id(Items.get(0).getUser_id());
			v.setUsername(Items.get(0).getUsername());
			v.setItems(Items.get(0).getItems());
			BigList.add(v);
		}
		return BigList;
	}
}