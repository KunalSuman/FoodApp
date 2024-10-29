package Customer.Order_Tracking;

import page.Customer.Order_Tracking.Order_Tracking_functionality;
import Customer.Customer_landing;
import java.util.Scanner;

public class Order_Tracking_landing{
    public void order_tracking_landing(String email){
        Order_Tracking_functionality OTF1 = new Order_Tracking_functionality();
        System.out.println("1. View Order Status \n2. Cancel Order \n3. Order history");
        Scanner S1 = new Scanner(System.in);
        int User_input = S1.nextInt();
        if(User_input == 1){
            OTF1.view_order_status(email);
        }
        else if(User_input == 2){
            OTF1.cancel_order(email);
        }
        else if(User_input == 3){
            OTF1.orders_history(email);
        }
        else if(User_input == 4){
            Customer_landing CL1 = new Customer_landing();
            CL1.customer_landing(email);
        }
    }
}
