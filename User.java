
public class User {
	int user_id;
	String user_name;
	String email;
	public int getId() {
		return user_id;
	}
	public void setId(int id) {
		user_id=id;
	}
	public String getName()
	{
		return user_name;
	}
	public void setName(String name)
	{
		user_name=name;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public User(int id,String name,String email)
	{
		user_id=id;
		user_name=name;
		this.email=email;
	}
	public User(){};

}
