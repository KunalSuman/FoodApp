package page.server.Admin.Order_Management;

import page.server.Admin.Menu_Management.Menu_schema ;
import page.server.Customer.Cart_Operations.User_cart;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.Scanner;


public class Order_Management {
    private Order_schema O1;
    private Order_landing OM1 =new Order_landing();
    private Scanner S1 = new Scanner(System.in);
    public void View_pending_orders(){
        try{
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("Pending_Orders.txt" ,true));
            for(Order_schema order : Order_schema.Orders){
                for(Menu_schema item : Menu_schema.Menu.values()){
                    if((order.Status.equals("Pending")||order.Status.equals("pending"))&&order.Payment!="Pending"&& item.get_availability()==1 &&order.VIP==1 ){
                        System.out.println("Order No. -> "+ order.Order_id + " Item -> " + order.item +" Student_id -> "+order.student_id + " Payment Status -> " +order.Payment + " Order value -> " + order.price + " Order Instruction ->" + order.Instructions);
                        out.write((" "+ order.Order_id + "," +order.item +","+order.student_id+"," + order.Payment + ","+order.price + '\n').getBytes());
                        break;
                    }
                }
            }
            for(Order_schema order : Order_schema.Orders){
                for(Menu_schema item : Menu_schema.Menu.values()){
                    if((order.Status.equals("Pending")||order.Status.equals("pending"))&&order.Payment!="Pending"&& item.get_availability()==1 &&order.VIP==0){
                        System.out.println("Order No. -> "+ order.Order_id + " Item -> " + order.item +" Student_id -> "+order.student_id + " Payment Status -> " +order.Payment + " Order value -> " + order.price + " Order Instruction ->" + order.Instructions);
                        out.write((" "+ order.Order_id + "," +order.item +","+order.student_id+"," + order.Payment + ","+order.price + '\n').getBytes());
                        break;
                    }
                }
            }
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        OM1.order_landing();
    }
    public void Update_status(){
        System.out.println("Enter Order id");
        int User_input = S1.nextInt();
        S1.nextLine();
        String value;
        String email ="" ;
        for(Order_schema order : Order_schema.Orders){
            if(order.Order_id == User_input){
                System.out.println("Enter the updated status");
                value = S1.nextLine();
                order.Status = value;
                email =order.student_id ;
            }
        }
        for(User_cart Us1 : User_cart.user_cart){
            if(Us1.user_id.equals(email)){
                Us1.status="Completed";
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
