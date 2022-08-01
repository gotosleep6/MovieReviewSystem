import java.util.List;
public class Client {

	public static void main(String[] args) {
		movie m;
		
		m=new movie(1, "Shamshera","Movie about fight for independence against the British rule","Action/Adventure","Ranbir kapoor,Vanii Kapoor");
		MovieDAO mdao=new MovieDAO();
		System.out.println(mdao.insert(m) + " Record Inserted");
	//	m.setName("3 Idiots back");
	//	System.out.println(mdao.update(m) + " Record Updated");
	//	System.out.println(mdao.delete(m) + " Record deleted");
		List<movie> movies=mdao.read();
		for(movie m1:movies)
			System.out.println(m1.getName());

	}

}


