import java.util.List;

public class reviewClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reviews r;
		
		r=new reviews(1, "Shamshera is good movie",1,1);
		ReviewDAO rdao=new ReviewDAO();
		//System.out.println(rdao.insert(r) + " Record Inserted");
		r.setReview("Shamshera movie is lobb!!");
		System.out.println(rdao.update(r) + " Record Updated");
	//	System.out.println(mdao.delete(m) + " Record deleted");
		List<reviews> reviewList=rdao.read();
		for(reviews r1:reviewList)
			System.out.println(r1.getReview());


	}

}
