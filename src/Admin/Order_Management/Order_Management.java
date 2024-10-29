package Admin.Order_Management;

import Admin.Order_Management.Order_schema ;
import Admin.Order_Management.Order_landing ;
import java.util.Scanner;

public class Order_Management {
    private Order_schema O1;
    private Order_landing OM1 =new Order_landing();
    private Scanner S1 = new Scanner(System.in);
    public void View_pending_orders(){
        System.out.println("Enter Order ID");
        for(Order_schema order : Order_schema.Orders){
            System.out.println("hello");
            if((order.Status.equals("Pending")||order.Status.equals("pending"))&&order.Payment!="Pending"){
                System.out.println(order.Order_id + " " + order.item +" "+order.student_id + " " +order.Payment + " " + order);
            }
        }
        OM1.order_landing();
    }
    public void Update_status(){
        System.out.println("Enter Order id");
        int User_input = S1.nextInt();
        for(Order_schema order : Order_schema.Orders){
            if(order.Order_id == User_input){
                System.out.println("Enter the updated status");
                String status = S1.nextLine();
                order.Status = status;
            }
        }
        OM1.order_landing();
    }
    public void Update_payment(){
        System.out.println("Enter Order id");
        int User_input = S1.nextInt();
        for(Order_schema order : Order_schema.Orders){
            if(order.Order_id == User_input){
                order.Payment = "Refunded" ;
                order.Status = "Cancelled" ;
            }
        }
        OM1.order_landing();
    }
    public void Handle_requests(){

    }
}
