package page.server.Customer.Cart_Operations;

import page.server.Customer.Customer_landing;
import page.server.User.User_schema;
import java.util.Scanner;

public class Cart_landing {

    public void cart_landing(String email) {
        Scanner S1 = new Scanner(System.in);
        Cart_functionalities CF1 = new Cart_functionalities();
        System.out.println("1. Add Items \n2. Modify quantities \n3. Remove Items \n4. Display \n5. Payment \n6. Return");
        int User_input = S1.nextInt();

        if(User_input == 1) {
            int isVIP = 0 ;
            for(User_schema user : User_schema.User_schema_List){
                if(user.getEmail().equals(email) && user.getVIP()==1) {
                    isVIP =1;
                    System.out.println("User is VIP");
                }
            }
            CF1.Add_items(email,isVIP);
        }

        else if(User_input == 2) {
            CF1.Change_quantity(email);
        }

        else if(User_input == 3) {
            CF1.Delete_item(email);
        }

        else if(User_input == 4) {
            CF1.View_total(email);
        }

        else if(User_input == 5) {
            CF1.Payments(email);
        }

        else if(User_input == 6) {
            Customer_landing C1 = new Customer_landing();
            C1.customer_landing(email);
        }
    }
}
