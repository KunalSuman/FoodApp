package Customer.Browse_Menu;

import java.util.Scanner;

import Admin.Menu_Management.Menu_schema ;
import Customer.Cart_Operations.Cart_landing;
import Customer.Browse_Menu.Browse_menu_functionalities ;
public class Browse_Menu_landing{
    public void browse_menu(String email){
        System.out.println("1. View all items \n2. Search \n3. Filter by Category \n4. Sort by Price \n5. Return");
        Browse_menu_functionalities B1 = new Browse_menu_functionalities();
        Scanner S1 = new Scanner(System.in);
        int User_input = S1.nextInt();
        if(User_input == 1){
            B1.View_items(email);
        }
        if(User_input == 2){
            B1.Search_items(email);
        }
        if(User_input == 3){
            B1.Filter_category(email);
        }
        if(User_input == 4){
            B1.Sort_items(email);
        }
        if(User_input == 5){
            Cart_landing C1 = new Cart_landing();
            C1.cart_landing(email);
        }
    }
}
