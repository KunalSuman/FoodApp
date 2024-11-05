package src.Admin.Menu_Management;

import src.Admin.Menu_Management.Menu_Management;
import Admin.Menu_Management.Menu_schema ;
import src.Admin.Admin_landing ;
import java.awt.*;
import java.util.Scanner;

public class Menu_landing extends Menu_schema {
    private Scanner S1 = new Scanner(System.in);

    public Menu_landing(String item, int price, int availability) {
        super(item, price, availability,null);
    }

    public void menu_landing() {
        System.out.println("1.Add Item \n2.Remove Item \n3.Update Item \n4.Update Price \n5.Update Availability \n6.Return");
        Menu_Management Options = new Menu_Management("", 0 , 0,null);
        int User_input = S1.nextInt();
        if(User_input == 1) {
            Options.Add_items();
        }
        else if(User_input == 2) {
            Options.remove_items();
        }
        else if(User_input == 3) {
            Options.update_items();
        }
        else if(User_input == 4) {
            Options.modify_prices();
        }
        else if(User_input == 5) {
            Options.update_availability();
        }
        else if(User_input == 6) {
            Admin_landing AL1 = new Admin_landing();
            AL1.admin_landing();
        }
    }
}
