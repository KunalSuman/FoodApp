package page.Customer.Review;

import java.util.ArrayList;

public class Review_schema {
    private String email ;
    private String review ;
    public static ArrayList<Review_schema> reviews = new ArrayList<Review_schema>();
    public Review_schema(String email, String review) {
        this.email = email;
        this.review = review;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getReview() {
        return review;
    }
    public void setReview(String review) {
        this.review = review;
    }
}
