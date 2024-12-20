package page.server.Customer.Cart_Operations;

import page.server.Admin.Menu_Management.Menu_schema;
import page.server.Admin.Order_Management.Order_schema;
import page.server.User.User_schema;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Cart_functionalities {
    private Cart_landing CL1 = new Cart_landing();
    private User_schema US1;
    private Order_schema OS1 ;

    public void Add_items(String email , int VIP) {
        while(true){
            int checker = 0 ;
            int repeat = 0 ;
            System.out.println("PRESS Q -> EXIT");
            Cart_landing CL1 = new Cart_landing();
            int price =0;
            Scanner S1 = new Scanner(System.in);

            System.out.println("Select item");
            String select_item = S1.nextLine();
            if(select_item.equals("q")){
                break ;
            }
            for(Order_schema orders : Order_schema.Orders){
                if(orders.student_id.equals(email) && orders.item.equals(select_item)){
                    repeat = 1 ;
                }
            }
            int result = Cart_return_availabilty(select_item);
            if(result == 1){
                for(Menu_schema items_check : Menu_schema.MenuSet){
                    if(items_check.get_item().equals(select_item)){
                        System.out.println("Enter quantity");
                        int quantity = S1.nextInt();

                        for(Menu_schema menu : Menu_schema.MenuSet){
                            if(menu.get_item().equals(select_item)){
                                price = menu.get_price()*quantity;
                            }
                        }
                        System.out.println(price);
                        User_cart.user_cart.add(new User_cart(select_item, email, price, quantity,"Pending"));
                        //       User_schema.US.add(new User_cart(select_item, "NULL", price, quantity));
                        System.out.println("Add Successfully");
                        Order_schema OS1 =new Order_schema(select_item, email, "Pending" , "Pending",quantity,User_cart.user_cart.size() ,price , " " , VIP ," ");
                        Order_schema.Orders.add(OS1);
                        checker = 1 ;
                        try{
                            BufferedOutputStream BF1 = new BufferedOutputStream(new FileOutputStream("Orders.txt",true));
                            BF1.write((select_item + "," + quantity + "\n").getBytes());
                            BF1.close();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
                if(checker == 0){
                    System.out.println("Enter valid item");
                }

            }
            else{
                System.out.println("Enter valid item");
            }
        }
        CL1.cart_landing(email);
    }

    public int Cart_return_availabilty(String select_item){
        for(Menu_schema items_check : Menu_schema.MenuSet){
            if(items_check.get_item().equals(select_item) && items_check.get_availability() == 1){
                System.out.println("Item Availbility");
                return 1;
            }
        }
        System.out.println("Enter valid item");
        return 0 ;
    }

    public void View_total(String email) {
        int total_cost = 0 ;
        for(Order_schema order : Order_schema.Orders){
            if(order.student_id.equals(email) && order.Payment != "Done" && order.Status.equals("Pending")){
                System.out.println("Item -> " + order.item + "Quantity -> " + order.quantity + "Price -> " + order.price);
            }
        }
        for(User_cart user : User_cart.user_cart){
            if(user.user_id.equals(email) && user.status.equals("Pending")){
                total_cost = total_cost + user.price;
            }
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
        for(User_cart user : User_cart.user_cart){
            if(user.user_id.equals(email) && user.item.equals(User_input)){
                User_cart.user_cart.remove(user);
            }
        }
        CL1.cart_landing(email);
    }

    public void Payments(String email){
        int total_cost = 0 ;
        for(User_cart user : User_cart.user_cart){
            if(user.user_id.equals(email) && user.status.equals("Pending")){
                total_cost = total_cost + user.price;
            }
        }
        Scanner S2 = new Scanner(System.in);
        System.out.println("Total cost : "+total_cost);
        System.out.println("1. Add Additional Instructions  \n2. Continue \n3. Exit") ;
        String user_choice = S2.nextLine();
        if(user_choice.equals("1")){
            System.out.println("Instructions");
            String user_instruction = S2.nextLine();
            System.out.println("instruction added !");
            System.out.println("Enter Your Address");
            String address = S2.nextLine();
            System.out.println("Enter 1 to Confirm 2 to return");
            int User_input = S2.nextInt();
            if(User_input == 1) {
                for (Order_schema order : Order_schema.Orders) {
                    if (order.student_id.equals(email) && order.Payment.equals("Pending")) {
                        order.Payment = "Done";
                        order.address = address;
                        order.Instructions = user_instruction;
                    }
                }
                System.out.println("Payment Done");
            }
            if(User_input == 2){
                CL1.cart_landing(email);
            }
            CL1.cart_landing(email);
        }
        if(user_choice.equals("2")){
            System.out.println("Enter Your Address");
            String address = S2.nextLine();
            System.out.println("Enter 1 to Confirm 2 to return");
            int User_input = S2.nextInt();
            if(User_input == 1){
                for(Order_schema order : Order_schema.Orders){
                    if(order.student_id.equals(email) && order.Payment.equals("Pending")){
                        order.Payment = "Done";
                        order.address = address;
                    }
                }
                System.out.println("Payment Done");
                for(User_cart user : User_cart.user_cart){
                    if(user.user_id.equals(email) && user.status.equals("Done")){
                        User_cart.user_cart.remove(user);
                    }
                }

            }
            if(User_input == 2){
                CL1.cart_landing(email);
            }
            try{
                BufferedOutputStream BF1 = new BufferedOutputStream(new FileOutputStream("Orders.txt"));
                BF1.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            CL1.cart_landing(email);
        }
        if(user_choice.equals("3")){
            CL1.cart_landing(email);
        }
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
