package page.server.User;

import page.server.Customer.Customer_landing;

import java.util.Scanner;
import javax.swing.*;
public class SignIn {
    public static int signIn(String email, String password) {
//        Scanner S1 = new Scanner(System.in);
//        System.out.println("Enter your email: ");
//        String email = S1.nextLine();
//        System.out.println("Enter your password: ");
//        String password = S1.nextLine();
        for(User_schema user : User_schema.User_schema_List){
            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                Customer_landing C1 = new Customer_landing();
                C1.customer_landing(email);
            }
        }
        System.out.println("Wrong Password!");
        return 0;
    }	
}

