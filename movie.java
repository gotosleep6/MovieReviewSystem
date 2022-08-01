
public class movie {

	int movie_id;
	String movie_name;
	String summary;
	String cast;
	String genre;
	
	float Average_rating;
	public int getId() {
		return movie_id;
	}
	public void setId(int id) {
		movie_id = id;
	}
	public String getName() {
		return movie_name;
	}
	public void setName(String name) {
		movie_name = name;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summ) {
		summary = summ;
	}

	public String getCast() {
		return cast;
	}
	public void setCast(String ca) {
		cast = ca;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String gen) {
		genre = gen;
	}
	
	public movie(int id, String name,String summ,String ca,String gen) {
		super();
		movie_id = id;
		movie_name = name;
		summary = summ;
		cast = ca;
		genre = gen;
	
	}
	public movie(){}
}
