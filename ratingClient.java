import java.util.List;

public class ratingClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		rating rat;
		
		rat=new rating(1,4,1,1);
		RatingDAO ratdao=new RatingDAO();
		System.out.println(ratdao.insert(rat) + " Record Inserted");
		//System.out.println(rdao.update(r) + " Record Updated");
	    //System.out.println(mdao.delete(m) + " Record deleted");
		List<rating> ratingList=ratdao.read();
		for(rating r1:ratingList)
			System.out.println(r1.getRating());

	}

}
