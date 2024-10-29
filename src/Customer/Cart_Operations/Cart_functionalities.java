package Customer.Cart_Operations;

import Admin.Menu_Management.Menu_schema;
import Admin.Order_Management.Order_schema;
import User.User_schema;

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
                    System.out.println(price);
                }
            }
            User_cart.user_cart.add(new User_cart(select_item, "NULL", price, quantity));
            //       User_schema.US.add(new User_cart(select_item, "NULL", price, quantity));
            System.out.println("Add Successfully");
            Order_schema.Orders.add(new Order_schema(select_item, email, "Pending" , "Pending",quantity,User_cart.user_cart.size()));
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
            for(User_cart user : User_cart.user_cart){
                //User_schema.cart_history.add(user);
                System.out.println("Payment Done");
                OS1.Payment=String.valueOf(total_cost) ;
            }
        }
        User_schema.US.clear();
        if(User_input == 2){
            CL1.cart_landing(email);
        }
        CL1.cart_landing(email);
    }
}
