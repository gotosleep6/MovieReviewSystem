import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RatingDAO {
	Connection con = null;
	Statement stmt = null;
	public RatingDAO() {
	}

	public void con() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_review",
				"root", "qwhy5qvb");
		
		stmt = con.createStatement();

	}
	public int insert(rating rat) {
		int r = 0;
		try {
			con();
			r = stmt.executeUpdate("insert into rating values(" + rat.getId()
					+ ", " + rat.getRating() + ", " + rat.getMovieId() + ", " + rat.getUserId()+" );");
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return r;
	}
	
	public int delete(rating rat) {
		int r = 0;
		try {
			con();
			r = stmt.executeUpdate("delete from rating where rating_id = " + rat.getId());
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return r;
	}
	
	public int update(rating rat) {
		int r = 0;
		try {
			con();
			r = stmt.executeUpdate("update rating set rating=" + rat.getRating() +
					", movie_id=" + rat.getMovieId() +", user_id=" + rat.getUserId() + " where rating_id=" + rat.getId());
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return r;
	}
	
	public List<rating> read(){
		List<rating> ratingList=new ArrayList<>();
		try {
			con();
			ResultSet rs = stmt.executeQuery("select * from rating");
			while (rs.next())
				ratingList.add(new rating(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4)));
		
		}
		catch (Exception ex) {
			System.out.println(ex);
		}
		return ratingList;
	}

}
