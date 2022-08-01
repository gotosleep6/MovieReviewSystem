import java.util.List;

public class userClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		User u;
		
		u=new User(1, "harsh","harshcr7m12@gmail.com");
		UserDAO udao=new UserDAO();
		System.out.println(udao.insert(u) + " Record Inserted");
	//	m.setName("3 Idiots back");
	//	System.out.println(mdao.update(m) + " Record Updated");
	//	System.out.println(mdao.delete(m) + " Record deleted");
		List<User> users=udao.read();
		for(User u1:users)
			System.out.println(u1.getName());

	}

}
