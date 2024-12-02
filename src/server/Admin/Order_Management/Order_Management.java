package page.server.Admin.Order_Management;

import page.client.AdminOrders;
import page.server.Admin.Menu_Management.Menu_schema ;
import page.server.Customer.Cart_Operations.User_cart;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;


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
                        out.write((" "+ order.Order_id + "," +order.item +","+order.student_id+"," + order.Payment + ","+order.price + "," + order.quantity +","+order.Status +'\n').getBytes());
                        break;
                    }
                }
            }
            for(Order_schema order : Order_schema.Orders){
                for(Menu_schema item : Menu_schema.Menu.values()){
                    if((order.Status.equals("Pending")||order.Status.equals("pending"))&&order.Payment!="Pending"&& item.get_availability()==1 &&order.VIP==0){
                        System.out.println("Order No. -> "+ order.Order_id + " Item -> " + order.item +" Student_id -> "+order.student_id + " Payment Status -> " +order.Payment + " Order value -> " + order.price + " Order Instruction ->" + order.Instructions);
                        out.write((" "+ order.Order_id + "," +order.item +","+order.student_id+"," + order.Payment + ","+order.price + ","+order.quantity + ","+order.Status + '\n').getBytes());
                        break;
                    }
                }
            }
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        AdminOrders AO1 = new AdminOrders();
        AO1.send_data();
        //OM1.order_landing();
    }
    public void Update_status(){
        String Temp ="" ;
        ArrayList<String> ARR1 = new ArrayList<>();
        ArrayList<ArrayList<String>> ARR2 = new ArrayList<>();
        System.out.println("Enter Order id");
        int User_input = S1.nextInt();
        S1.nextLine();
        String value;
        String email ="" ;
        System.out.println("Enter the updated status");
        value = S1.nextLine();
        for(Order_schema order : Order_schema.Orders){
            if(order.Order_id == User_input){
                order.Status = value;
                email =order.student_id ;
            }
        }
        for(User_cart Us1 : User_cart.user_cart){
            if(Us1.user_id.equals(email)){
                Us1.status=value;
            }
        }
        try{
            BufferedInputStream BF1 = new BufferedInputStream(new FileInputStream("Pending_Orders.txt"));
            while(true){
                if(BF1.read()==-1){
                    break;
                }
                while(true){
                    char c = (char)BF1.read();
                    if(c=='\n'){
                        String[] val = Temp.split(",");
                        String A  = val[0];
                        String B  = val[1];
                        String C  = val[2];
                        String D  = val[3];
                        String E  = val[4];
                        String F  = val[5];
                        String G  = val[6];
                        ARR1.add(A);
                        ARR1.add(B);
                        ARR1.add(C);
                        ARR1.add(D);
                        ARR1.add(E);
                        ARR1.add(F);
                        ARR1.add(G);
                        Temp = "" ;
                        break;
                    }else {
                        Temp = Temp +c ;
                    }
                }
                ARR2.add(new ArrayList<>(ARR1));
                ARR1.clear();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        for(ArrayList<String> arr : ARR2){
           if(User_input == parseInt(arr.get(0))){
               arr.set(6,value);
           }
        }
        try{
            BufferedOutputStream BF2 = new BufferedOutputStream(new FileOutputStream("Pending_Orders.txt"));
            BF2.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            BufferedOutputStream BF2 = new BufferedOutputStream(new FileOutputStream("Pending_Orders.txt"));
            for(ArrayList<String> arr : ARR2){
                BF2.write((" "+arr.get(0)+","+arr.get(1)+","+arr.get(2)+","+arr.get(3)+","+arr.get(4)+","+arr.get(5)+","+arr.get(6)+" "+"\n").getBytes());
            }
            BF2.close();
        }catch (Exception e){
            e.printStackTrace();
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
        OM1.order_landing();
    }
}
