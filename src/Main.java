
import User.User_samples;
import page.Customer.Review.Review_sample;
import src.Admin.Menu_Management.Menu_sample ;

class Main{
	public static void main(String[] args){
        Menu_sample.menu_sample();
        User_samples.user_samples();
        page.Application_page.application_page() ;
        Review_sample review_sample = new Review_sample();
        review_sample.review_sample();
	}
}
