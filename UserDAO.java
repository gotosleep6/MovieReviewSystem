import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class UserDAO {
	Connection con = null;
	Statement stmt = null;
	public UserDAO() {
	}

	public void con() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_review",
				"root", "qwhy5qvb");
		
		stmt = con.createStatement();

	}
	public int insert(User u) {
		int r = 0;
		try {
			con();
			r = stmt.executeUpdate("insert into User values(" + u.getId()
					+ ", '" + u.getName() + "', '" + u.getEmail() + "' );");
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return r;
	}
	
	public int delete(User u) {
		int r = 0;
		try {
			con();
			r = stmt.executeUpdate("delete from User where user_id = " + u.getId());
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return r;
	}
	
	public int update(User u) {
		int r = 0;
		try {
			con();
			r = stmt.executeUpdate("update User set user_name='" + u.getName() +
					"', email_id='" + u.getEmail() + "' where user_id=" + u.getId());
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return r;
	}
	
	public List<User> read(){
		List<User> users=new ArrayList<>();
		try {
			con();
			ResultSet rs = stmt.executeQuery("select * from User");
			while (rs.next())
				users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3)));
		
		}
		catch (Exception ex) {
			System.out.println(ex);
		}
		return users;
	}
	
	
}
