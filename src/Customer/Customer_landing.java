package Customer;


import Customer.Browse_Menu.Browse_Menu_landing;
import Customer.Cart_Operations.Cart_landing;
import Admin.Menu_Management.Menu_schema;
import Customer.Order_Tracking.Order_Tracking_landing ;

import java.util.Scanner;

public class Customer_landing{
    private Scanner S1 = new Scanner(System.in);
    public void customer_landing(String email){
        System.out.println("1.Browse Menu \n2.Cart Options \n3.Order Tracking");
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
            page.Application_page.application_page();
        }
    }
}
