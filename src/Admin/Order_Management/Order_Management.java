package Admin.Order_Management;

import Admin.Order_Management.Order_schema ;
import Admin.Order_Management.Order_landing ;
import Admin.Menu_Management.Menu_schema ;
import page.User.User_schema;

import java.util.Scanner;


public class Order_Management {
    private Order_schema O1;
    private Order_landing OM1 =new Order_landing();
    private Scanner S1 = new Scanner(System.in);
    public void View_pending_orders(){
        for(Order_schema order : Order_schema.Orders){
            for(Menu_schema item : Menu_schema.Menu.values()){
                if((order.Status.equals("Pending")||order.Status.equals("pending"))&&order.Payment!="Pending"&& item.get_availability()==1 &&order.VIP==1 ){
                    System.out.println("Order No. -> "+ order.Order_id + " Item -> " + order.item +" Student_id -> "+order.student_id + " Payment Status -> " +order.Payment + " Order value -> " + order.price + " Order Instruction ->" + order.Instructions);
                    break;
                }
            }
        }
        for(Order_schema order : Order_schema.Orders){
            for(Menu_schema item : Menu_schema.Menu.values()){
                if((order.Status.equals("Pending")||order.Status.equals("pending"))&&order.Payment!="Pending"&& item.get_availability()==1 &&order.VIP==0){
                    System.out.println("Order No. -> "+ order.Order_id + " Item -> " + order.item +" Student_id -> "+order.student_id + " Payment Status -> " +order.Payment + " Order value -> " + order.price + " Order Instruction ->" + order.Instructions);
                    break;
                }
            }
        }
        OM1.order_landing();
    }
    public void Update_status(){
        System.out.println("Enter Order id");
        int User_input = S1.nextInt();
        S1.nextLine();
        String value;
        for(Order_schema order : Order_schema.Orders){
            if(order.Order_id == User_input){
                System.out.println("Enter the updated status");
                value = S1.nextLine();
                order.Status = value;
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
        System.out.println("Refunded");
        OM1.order_landing();
    }
    public void Handle_requests(){
        for(Order_schema order : Order_schema.Orders){
            if(order.Instructions.length() > 0){
                System.out.println(order.Order_id + order.item + order.Instructions);
            }
        }
    }
}
