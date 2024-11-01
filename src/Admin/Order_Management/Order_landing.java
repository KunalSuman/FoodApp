package Admin.Order_Management;

import java.util.Scanner;
import Admin.Order_Management.Order_Management;
import src.Admin.Admin_landing;
public class Order_landing {
    public void order_landing(){
        System.out.println("1. View Pending Orders \n2. Update Order Status \n3. Process Refunds \n4. Handle Special Request \n5. Return");
        Order_Management OMM1 = new Order_Management();
        Scanner S1 = new Scanner(System.in);
        int User_input = S1.nextInt();
        if(User_input == 1){
            OMM1.View_pending_orders();
        }
        else if(User_input == 2){
            OMM1.Update_status();
        }
        else if(User_input == 3){
            OMM1.Update_payment();
        }
        else if(User_input == 4){
            OMM1.Handle_requests();
        }
        else if(User_input == 5){
            Admin_landing AL1 = new Admin_landing();
            AL1.admin_landing();
        }
    }
}
