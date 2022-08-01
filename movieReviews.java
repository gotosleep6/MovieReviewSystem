import java.util.*;
import java.io. * ;
public class movieReviews {

	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub
		 InputStreamReader ir = new InputStreamReader(System. in );
		    BufferedReader br = new BufferedReader(ir);

		String name;
		String email;
		UserDAO udao1=new UserDAO();
		MovieDAO mdao1=new MovieDAO();
		ReviewDAO rdao1=new ReviewDAO();
		RatingDAO ratdao1=new RatingDAO();
		
		int movieId;
		int reviewId;
		int ratingId;
		List<movie> movies=mdao1.read();
		List<reviews> reviewList=rdao1.read();
		List<rating> ratingList1=ratdao1.read();
		List<User> users1=udao1.read();
	    Random rand = new Random();
	    
	    while(true)
	    {
		System.out.println("Press 1 for SignIn And Press 2 for SignUp");
		Scanner sc = new Scanner(System.in);
		int res = sc.nextInt();
		if(res==1||res==2)
		{
		if(res==1)
		{
			System.out.println("Enter your Email:");
			email = sc.next();
			List<User> users=udao1.read();
			int countuser=0;
			for(User u1:users)
			{
				
				
				
				if(u1.getEmail().equals(email))
				{
					System.out.println("Enter your UserName:");
					name = sc.next();
					if(u1.getName().equals(name))
					{
						while(true)
						{
						System.out.println("Press 1 To add new movie:\nPress 2 To Edit any Movie Entry\nPress 3 To Add Review to movie\nPress 4 To Give Rating to any movie\nPress 5 to see List of all movies\nPress 6 to Search any Movie\nPress 7 to Sign Out");
						int res2 = sc.nextInt();
						if(res2==1)
						{
							String newMovie ="ghg";
							String Summary;
							String Cast;
							String Genre;
							
							System.out.println("Enter New Movie Name:");
						
							newMovie = br.readLine();
							
						

							
							for(movie m1:movies)
							{ 
								if(m1.getName().equals(newMovie))
								{
									System.out.println("Entered Movie Already Exists!!");
									break;
								}
							}
							System.out.println("Enter Movie Summary:");
							Summary = br.readLine();
							
							
							System.out.println("Enter Movie Cast:");
							Cast = br.readLine();
							
							System.out.println("Enter Movie Genre:");
							Genre = br.readLine();
							
							
					
							
							
							
							
							movieId = rand.nextInt(1000);
							movie m1=new movie(movieId,newMovie,Summary,Genre,Cast);
							 movies=mdao1.read();
							System.out.println(mdao1.insert(m1) + " Record Inserted");
							
							
							
							
							
						}
						else if(res2==2)
						{
							int count=0;
							System.out.println("Enter Movie Name You want to edit:");
							String mov = br.readLine();
							for(movie m1:movies)
							{ 
								
								if(m1.getName().equals(mov))
								{
									System.out.println("Enter Updated Movie Name:");
									String movName = br.readLine();
									m1.setName(movName);
									
									
									System.out.println("Enter Updated Movie Summary:");
									String movSummary = br.readLine();
									m1.setSummary(movSummary);
									
									System.out.println("Enter Updated Movie Cast:");
									String movCast = br.readLine();
									m1.setCast(movCast);
									
									System.out.println("Enter Updated Movie Genre:");
									String movGenre = br.readLine();
									m1.setGenre(movGenre);
									
									System.out.println(mdao1.update(m1) + " Record Updated");
									break;
									
									
								}
								count++;
								
							}
							if(count==movies.size())
							{
								System.out.println("Movie is not there in the list!!");
							}
							
						}
						else if(res2==3)
						{
							int count=0;
							System.out.println("Enter the movie name you want to give review:");
							String movreview = br.readLine();
							
							for(movie m2:movies) {
								
								if(m2.getName().equals(movreview)) {
									reviewId = rand.nextInt(1000);
									System.out.println("Enter Your Review:");
									String rev = br.readLine();
									int mid = m2.getId();
									int uid = u1.getId();
									reviews r = new reviews(reviewId,rev,mid,uid);
									System.out.println(rdao1.insert(r) + " Record Inserted");
									 reviewList=rdao1.read();
									 break;
								}
								count++;
							}
							if(count==movies.size())
								System.out.println("Movie is not there in the list!!");
							
						}
						else if(res2==4)
						{
							int count=0;
							System.out.println("Enter the movie name you want to give Rating:");
							String movrating = br.readLine();
							
							for(movie m3:movies)
							{
								
								if(m3.getName().equals(movrating))
								{
									System.out.println("Enter the Rating you want to give to this movie:");
									int rat = sc.nextInt();
									ratingId = rand.nextInt(1000);
									rating ratmov = new rating(ratingId,rat,m3.getId(),u1.getId());
									System.out.println(ratdao1.insert(ratmov) + " Record Inserted");
									 ratingList1=ratdao1.read();
									 break;
									
									
								}
								count++;
							}
							if(count==movies.size())
								System.out.println("Movie is not there in the list!!");
							
						}
						else if(res2==5)
						{
							System.out.println("List of all movies:");
							for(movie m4:movies) {
								System.out.println(m4.getName());
							}
							
							
						}
				
						else if(res2==6)
						{
							int count=0;
							System.out.println("Enter the movie you want to search");
							String movSearch = br.readLine();
							for(movie m5:movies) {
								if(m5.getName().equals(movSearch))
								{
									System.out.println("Movie Name:"+m5.getName());
									System.out.println("Movie Summary:"+m5.getSummary());
									System.out.println("Movie Cast:"+m5.getCast());
									System.out.println("Movie Genre:"+m5.getGenre());
									
									System.out.println("Movie Reviews:");
									reviewList=rdao1.read();
									for(reviews r2: reviewList)
									{
										
										if(r2.getMovieId()==m5.getId())
										{
										          System.out.print(r2.getReview()+"- By:");
										           users1=udao1.read();
										          for(User u2:users1 )
										          {
										        	  if(r2.getUserId()==u2.getId())
										        		  System.out.println(u2.getName());
										          }
										}
									}
								 
									
									
									
								}
							}
							
						}
						else if(res2==7)
						{
							break;
							
						}
						//break;
						}
						break;
					}
					else {
						System.out.println("You have entered wrong UserName");
						break;
					}
				}
			}
			
			
		}
		else{
		
			int userId = rand.nextInt(1000);
			System.out.println("Enter User Name:");
			String uName = br.readLine();
			System.out.println("Enter User Email Id:");
			String uEmail = br.readLine();
			
			User u2 = new User(userId,uName,uEmail);
			System.out.println(udao1.insert(u2) + " Account Created!!");
		}
		
		}
	    }
		

	}

}
