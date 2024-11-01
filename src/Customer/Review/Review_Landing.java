package page.Customer.Review;

import java.util.Scanner;

public class Review_Landing {
    Scanner S1 = new Scanner(System.in);
    Review_functionality RF1 = new Review_functionality();
    public void review_landing(String email){
        System.out.println("1.Check Review \n2.Add Review");
        String user_input = S1.nextLine();
        if(user_input.equals("1")){
            RF1.check_review(email);
        }
        if(user_input.equals("2")){
            RF1.add_review(email);
        }
    }
}
