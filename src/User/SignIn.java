package page.User;

import Customer.Customer_landing;
import page.User.User_schema ;
import java.util.Scanner;

public class SignIn {
    public static void signIn(){
        Scanner S1 = new Scanner(System.in);
        System.out.println("Enter your email: ");
        String email = S1.nextLine();
        System.out.println("Enter your password: ");
        String password = S1.nextLine();
        for(User_schema user : User_schema.User_schema_List){
            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                Customer_landing C1 = new Customer_landing();
                C1.customer_landing(email);
            }
        }
        System.out.println("Wrong Password!");
    }
}
