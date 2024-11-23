package page.server.Customer;

import page.server.User.User_schema ;
import page.server.Customer.Order_Tracking.Order_Tracking_landing;
import java.util.Scanner;

public class Vip_status {
    private Scanner S1 = new Scanner(System.in);
    private Order_Tracking_landing OTL1 = new Order_Tracking_landing();
    public void vip(String email){
        int VIP = 0 ;
        for(User_schema users : User_schema.User_schema_List){
            if(users.getEmail().equals(email)&&users.getVIP()==1){
                System.out.println("Vip Status Active");
                System.out.println("1. Cancel Vip Status  \n2. Return");
                String inpur = S1.nextLine();
                if(inpur.equals("1")){
                    users.setVIP(0);
                    System.out.println("Vip Subscription cancled");
                }
                if(inpur.equals("2")){
                    OTL1.order_tracking_landing(email);
                }
                OTL1.order_tracking_landing(email);
            }
        }
        for(User_schema users : User_schema.User_schema_List){
            if(users.getEmail().equals(email)&&users.getVIP()==0){
                System.out.println("1. Become Vip \n2. Return");
                String input = S1.nextLine();
                if(input.equals("1")){
                    System.out.println("Cost 150");
                    System.out.println("1. Confirm \n2. Return");
                    String inpurt = S1.nextLine();
                    if(inpurt.equals("1")){
                        System.out.println("Payment Successful");
                        users.setVIP(1);
                    }
                    if(inpurt.equals("2")){
                        OTL1.order_tracking_landing(email);
                    }
                }
                if(input.equals("2")){
                    OTL1.order_tracking_landing(email);
                }
                OTL1.order_tracking_landing(email);
            }
        }
    }
}
