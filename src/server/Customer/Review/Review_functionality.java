package page.server.Customer.Review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import page.server.Admin.Order_Management.Order_schema ;
public class Review_functionality {
    Scanner S1 = new Scanner(System.in);
    HashMap<String,String> user_review = new HashMap<>();
    public static HashMap<String, ArrayList<Review_schema>> final_review = new HashMap<>();
    public void check_review(String email){
        System.out.println("Enter Item Name");
        String ItemName = S1.nextLine();
        System.out.println(final_review);
        if(final_review.containsKey(ItemName)){
                System.out.println(Review_schema.reviews);

        }
        Review_Landing RL1 = new Review_Landing();
        RL1.review_landing(email);
    }
    public void add_review(String email){
        System.out.println("Enter Item Name");
        String user_input = S1.nextLine();
        for(Order_schema order : Order_schema.Orders){
            if(order.student_id.equals(email) && order.Status.equals("Completed") && order.item.equals(user_input)){
                System.out.println("Enter Review");
                String review = S1.nextLine();
                Review_schema reiew = new Review_schema(email,review);
                Review_schema.reviews.add(reiew);
                final_review.put(user_input,Review_schema.reviews);
                System.out.println(final_review);
                Review_schema.reviews.remove(reiew);
            }
        }
    }
}
