package page.User;

import java.util.Scanner;
import Customer.Customer_landing;
import page.User.User_schema ;
public class SignUp {
    public static void signup(){
        Scanner S1 = new Scanner(System.in);
        System.out.println("Enter Username:");
        String username = S1.nextLine();
        System.out.println("Enter Password:");
        String password = S1.nextLine();
        System.out.println("Enter Email");
        String email = S1.nextLine();
        User_schema US1 = new User_schema(username , password ,email,null,null,0);
        User_schema.User_schema_List.add(US1);
        System.out.println("Sign Up Successful");
        Customer_landing C1 = new Customer_landing();
        C1.customer_landing(email);
    }
}
