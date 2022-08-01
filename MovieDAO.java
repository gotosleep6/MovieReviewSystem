import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class MovieDAO {
	Connection con = null;
	Statement stmt = null;
	public MovieDAO() {
	}

	public void con() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_review",
				"root", "qwhy5qvb");
		
		stmt = con.createStatement();

	}
	
	public int insert(movie m) {
		int r = 0;
		try {
			con();
			r = stmt.executeUpdate("insert into movie values(" + m.getId()
					+ ", '" + m.getName() + "', '" + m.getSummary() + "', '" +m.getGenre() +"', '" + m.getCast()+"' );");
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return r;
	}
	
	public int delete(movie m) {
		int r = 0;
		try {
			con();
			r = stmt.executeUpdate("delete from movie where movie_id = " + m.getId());
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return r;
	}
	
	public int update(movie m) {
		int r = 0;
		try {
			con();
			r = stmt.executeUpdate("update movie set movie_name='" + m.getName() +
					"', summary='" + m.getSummary() +"', cast='" + m.getCast() +"', genre='" + m.getGenre() + "' where movie_id=" + m.getId());
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return r;
	}
	
	public List<movie> read(){
		List<movie> movies=new ArrayList<>();
		try {
			con();
			ResultSet rs = stmt.executeQuery("select * from movie");
			while (rs.next())
				movies.add(new movie(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5 )));
		
		}
		catch (Exception ex) {
			System.out.println(ex);
		}
		return movies;
	}
	

}
