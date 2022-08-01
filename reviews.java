
public class reviews {
	int review_id;
	String review;
	int movie_id;
	int user_id;
	public int getId() {
		return review_id;
	}
	public void setId(int id) {
		review_id = id;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String rev) {
		review = rev;
	}
	public int getMovieId() {
		return movie_id;
	}
	public void setMovieId(int mid) {
		movie_id = mid;
	}
	public int getUserId() {
		return user_id;
	}
	public void setUserId(int uid) {
	   user_id = uid;
	}
	
	public reviews(int id, String rev,int movieid,int userid) {
		super();
		review_id=id;
		review = rev;
		movie_id=movieid;
		user_id=userid;
		
	
	}
	public reviews(){}
	
	
	

}
