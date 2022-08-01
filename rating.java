
public class rating {
	int ratingId;
	int rating;
	int movieId;
	int userId;
	public int getId()
	{
		return ratingId;
	}
	public void setId(int id)
	{
		ratingId = id;
	}
	
	public int getRating()
	{
		return rating;
	}
	public void setRating(int rating)
	{
		this.rating = rating;
	}
	
	public int getMovieId()
	{
		return movieId;
	}
	public void setMovieId(int mid)
	{
		movieId = mid;
	}
	
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int uid)
	{
		userId = uid;
	}
	public rating(int id,int rating,int mid,int uid)
	{
		ratingId = id;
		this.rating=rating;
		movieId= mid;
		userId = uid;
	}
	public rating() {}
	

}
