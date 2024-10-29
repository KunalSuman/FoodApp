package src.Admin.Menu_Management ;

import Admin.Menu_Management.Menu_schema ;
import src.Admin.Management_interface ;

import java.util.ArrayList;
import java.util.Scanner;
import src.Admin.Menu_Management.Menu_landing;
public class Menu_Management extends Menu_schema implements Management_interface {
    public Scanner S1 = new Scanner (System.in);
    public Menu_landing M1 = new Menu_landing("",0,0);
    public Menu_Management(String item, int price, int availability) {
        super(item, price, availability);
    }

    @Override
    public void Add_items() {
        System.out.println("Enter the name of the item");
        String Input_item = S1.nextLine();
        System.out.println("Enter the price of the item");
        int Input_price = S1.nextInt();
        int availability = 1 ;
        Menu_Management menu = new Menu_Management(Input_item, Input_price, availability);
        Menu.put(Input_item,menu);
        MenuSet.add(menu);
        M1.menu_landing();
    }

    @Override
    public void remove_items() {
        System.out.println("Enter the name of the item");
        String Input_item = S1.nextLine();
        for(Menu_schema item: Menu.values()){
            if(item.get_item().equals(Input_item)){
                Menu.remove(item);
                MenuSet.remove(item);
            }
        }
        M1.menu_landing();
    }

    @Override
    public void modify_prices() {
        System.out.println("Enter the name of item");
        String Input_item = S1.nextLine();
        for(Menu_schema item: Menu.values()){
            if(item.get_item().equals(Input_item)){
                System.out.println("Enter new price");
                int Input_price = S1.nextInt();
                item.set_price(Input_price);
            }
        }
        M1.menu_landing();
    }

    @Override
    public void update_items() {
        System.out.println("Enter the name of item");
        String Input_item = S1.nextLine();
        for(Menu_schema item: Menu.values()){
            if(item.get_item().equals(Input_item)){
                System.out.println("Enter updated item");
                String input_item = S1.nextLine();
                item.set_item(input_item);
            }
        }
        M1.menu_landing();
    }

    @Override
    public void update_availability() {
        System.out.println("Enter the name of item");
        String Input_item = S1.nextLine();
        for(Menu_schema item: Menu.values()){
            if(item.get_item().equals(Input_item)){
                System.out.println("Enter new status");
                int Input_availabilty = S1.nextInt();
                item.set_price(Input_availabilty);
            }
        }
        M1.menu_landing();
    }

    @Override
    public void view_orders() {

    }

    @Override
    public void update_order_status() {

    }

    @Override
    public void process_refunds() {

    }

    @Override
    public void handle_special_requests() {

    }
}
