package page;
import page.server.User.User_samples;
import page.server.Customer.Review.Review_sample;
import page.server.Admin.Menu_Management.Menu_sample ;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

class Main{
	public static void main(String[] args){
        try{
            BufferedOutputStream B1 = new BufferedOutputStream(new FileOutputStream("Pending_Orders.txt"));
            B1.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        Menu_sample.menu_sample();
        User_samples.user_samples();
        page.Application_page.application_page() ;
        Review_sample review_sample = new Review_sample();
        review_sample.review_sample();
	}
}
