package page.server.Customer.Review;

import static page.server.Customer.Review.Review_functionality.final_review;
import static page.server.Customer.Review.Review_schema.reviews;

public class Review_sample {
    public void review_sample() {
        Review_schema r1 = new Review_schema("kunal@iiitd.ac.in" ,"d");
        reviews.add(r1);
        final_review.put("KFC",reviews);
        System.out.println(final_review);
    }
}
