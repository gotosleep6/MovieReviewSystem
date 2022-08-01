import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO {
	Connection con = null;
	Statement stmt = null;
	public ReviewDAO() {
	}

	public void con() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_review",
				"root", "qwhy5qvb");
		
		stmt = con.createStatement();

	}
	public int insert(reviews rev) {
		int r = 0;
		try {
			con();
			r = stmt.executeUpdate("insert into reviews values(" + rev.getId()
					+ ", '" + rev.getReview() + "', " + rev.getMovieId() + ", " + rev.getUserId()+" );");
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return r;
	}
	public int delete(reviews rev) {
		int r = 0;
		try {
			con();
			r = stmt.executeUpdate("delete from reviews where review_id = " + rev.getId());
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return r;
	}
	public int update(reviews rev) {
		int r = 0;
		try {
			con();
			r = stmt.executeUpdate("update reviews set review='" + rev.getReview() +
					"', movie_id=" + rev.getMovieId() +", user_id=" + rev.getUserId() + " where review_id=" + rev.getId());
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return r;
	}
	public List<reviews> read(){
		List<reviews> reviewList=new ArrayList<>();
		try {
			con();
			ResultSet rs = stmt.executeQuery("select * from reviews");
			while (rs.next())
				reviewList.add(new reviews(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
		
		}
		catch (Exception ex) {
			System.out.println(ex);
		}
		return reviewList;
	}
}
