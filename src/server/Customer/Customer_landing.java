package page.server.Customer;


import page.server.Customer.Browse_Menu.Browse_Menu_landing;
import page.server.Customer.Cart_Operations.Cart_landing;
import page.server.Customer.Order_Tracking.Order_Tracking_landing ;
import page.server.Customer.Review.Review_Landing;
import page.server.Customer.Vip_status;

import java.util.Scanner;

public class Customer_landing{
    private Scanner S1 = new Scanner(System.in);
    public void customer_landing(String email){
        System.out.println("1.Browse Menu \n2.Cart Options \n3.Order Tracking \n4.VIP status \n5.Review \n6.Return");
        int User_Input = S1.nextInt();
        if(User_Input == 1){
            Browse_Menu_landing B1 = new Browse_Menu_landing();
            B1.browse_menu(email);
        }
        if(User_Input == 2){
            Cart_landing C1 = new Cart_landing();
            C1.cart_landing(email);
        }
        if(User_Input == 3){
            Order_Tracking_landing OTF1 = new Order_Tracking_landing();
            OTF1.order_tracking_landing(email);
        }
        if(User_Input == 4){
            Vip_status VIP1 = new Vip_status();
            VIP1.vip(email);
        }
        if(User_Input == 5){
            Review_Landing RL1 = new Review_Landing();
            RL1.review_landing(email);
        }
        if(User_Input == 6){
            page.Application_page.application_page();
        }
    }
}
