package page;
import java.util.* ;

import User.SignIn;
import com.sun.tools.javac.Main;
import src.Exception.BadInputException;
import src.Admin.Admin_landing ;
import Customer.Customer_landing ;
public class Application_page{
	public static void application_page(){
		while(true){
			System.out.println("1. Admin \n2. Customer");
			Scanner S1 = new Scanner(System.in);
			int User_input = S1.nextInt();
			try{
				if(User_input == 1){
					Admin_landing admin = new Admin_landing();
					admin.admin_landing();
				}
				if(User_input == 2){
					SignIn.signIn();
				}
				else{
					throw new BadInputException("Enter a valid input");
				}
			}
			catch(BadInputException e){
				System.out.println(e.getMessage());
			}
		}
	}
}
