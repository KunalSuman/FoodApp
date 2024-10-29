package Customer.Cart_Operations;

import Admin.Menu_Management.Menu_schema;
import Admin.Order_Management.Order_schema;
import User.User_schema;
import Customer.Cart_Operations.Cart_landing ;
import Customer.Cart_Operations.User_cart;
import java.util.Scanner;

public class Cart_functionalities {
    private Cart_landing CL1 = new Cart_landing();
    private User_schema US1;
    private Order_schema OS1 ;

    public void Add_items(String email) {
        while(true){
            System.out.println("PRESS Q -> EXIT");
            Cart_landing CL1 = new Cart_landing();
            int price =0;
            Scanner S1 = new Scanner(System.in);

            System.out.println("Select item");
            String select_item = S1.nextLine();

            if(select_item.equals("q")){
                break ;
            }

            System.out.println("Enter quantity");
            int quantity = S1.nextInt();

            for(Menu_schema menu : Menu_schema.MenuSet){
                if(menu.get_item().equals(select_item)){
                    price = menu.get_price()*quantity;
                }
            }
            System.out.println(price);
            User_cart.user_cart.add(new User_cart(select_item, "NULL", price, quantity,"Pending"));
            //       User_schema.US.add(new User_cart(select_item, "NULL", price, quantity));
            System.out.println("Add Successfully");
            Order_schema OS1 =new Order_schema(select_item, email, "Pending" , "Pending",quantity,User_cart.user_cart.size() ,price);
            Order_schema.Orders.add(OS1);
        }
        CL1.cart_landing(email);
    }


    public void View_total(String email) {
        int total_cost = 0 ;
        for(Order_schema order : Order_schema.Orders){
            if(order.student_id.equals(email) && order.Payment != "Done"){
                System.out.println("Item -> " + order.item + "Quantity -> " + order.quantity + "Price -> " + order.price);
            }
        }
        for(User_cart user : User_cart.user_cart){
            total_cost = total_cost + user.price;
        }
        System.out.println("Total cost : " + total_cost );
        CL1.cart_landing(email);
    }

    public void Delete_item(String email) {
        System.out.println("Item To Delete");
        Scanner S1 = new Scanner(System.in);
        String User_input = S1.nextLine();
        for(Order_schema order : Order_schema.Orders){
            if(order.student_id.equals(email) && order.item.equals(User_input)){
                Order_schema.Orders.remove(order);
            }
        }
        CL1.cart_landing(email);
    }

    public void Payments(String email){
        int total_cost = 0 ;
        for(User_cart user : User_cart.user_cart){
            total_cost = total_cost + user.price;
        }
        System.out.println("Total cost : "+total_cost);
        System.out.println("Enter 1 to Confirm 2 to return");
        Scanner S2 = new Scanner(System.in);
        int User_input = S2.nextInt();
        if(User_input == 1){
            for(Order_schema order : Order_schema.Orders){
                if(order.student_id.equals(email) && order.Payment.equals("Pending")){
                    order.Payment = "Done";
                }
            }
//            for(User_cart user : User_cart.user_cart){
//
//            }
            System.out.println("Payment Done");
        }
        //User_schema.US.clear();
        if(User_input == 2){
            CL1.cart_landing(email);
        }
        CL1.cart_landing(email);
    }

    public void Change_quantity(String email) {
        System.out.println("Enter Item");
        Scanner S1 = new Scanner(System.in);
        String User_input = S1.nextLine();
        int quantity_new ;
        for(Order_schema order : Order_schema.Orders){
            if(order.student_id.equals(email) && order.Payment != "Done" && order.item.equals(User_input)){
                System.out.println("Change Item To");
                quantity_new = S1.nextInt();
                order.quantity = quantity_new ;
            }
        }
        System.out.println("Quantity Updated");
        CL1.cart_landing(email);
    }
}
