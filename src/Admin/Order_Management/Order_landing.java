package Admin.Order_Management;

import java.util.Scanner;

public class Order_landing {
    public void order_landing(){
        System.out.println("1. View Pending Orders \n2. Update Order Status \n3.Process Refunds \n4.handle Special Request");
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

        }
    }
}
