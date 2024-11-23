package page.server.User;

import java.io.*;
import java.util.Scanner;
import page.server.Customer.Customer_landing;

import javax.swing.* ;
public class SignUp {
    public static void signup(String username , String password , String email){
//	  Scanner S1 = new Scanner(System.in);
//        System.out.println("Enter Username:");
//        String username = S1.nextLine();
//        System.out.println("Enter Password:");
//        String password = S1.nextLine();
//        System.out.println("Enter Email");
//        String email = S1.nextLine();
        User_schema US1 = new User_schema(username , password ,email,null,null,0);
        User_schema.User_schema_List.add(US1);
        System.out.println("Sign Up Successful");
	try{
		BufferedOutputStream F1 = new BufferedOutputStream(new FileOutputStream("Users_data.txt",true));
		F1.write((" "+username+","+password+","+email+","+0 + "\n").getBytes());
		F1.close();	
	}catch(IOException e){
		e.printStackTrace();
	}
        Customer_landing C1 = new Customer_landing();
        C1.customer_landing(email);


    }
}
