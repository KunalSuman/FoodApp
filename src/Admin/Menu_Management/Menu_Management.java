package src.Admin.Menu_Management ;

import Admin.Menu_Management.Menu_schema ;
import src.Admin.Management_interface ;

import java.util.ArrayList;
import java.util.Scanner;
import src.Admin.Menu_Management.Menu_landing;
import Admin.Order_Management.Order_schema ;
public class Menu_Management extends Menu_schema implements Management_interface {
    public Scanner S1 = new Scanner (System.in);
    public Menu_landing M1 = new Menu_landing("",0,0);
    public ArrayList<String> AL1 = new ArrayList<>();
    public Menu_Management(String item, int price, int availability , ArrayList<String> AL1) {
        super(item, price, availability ,AL1);
    }

    @Override
    public void Add_items() {
        System.out.println("Enter the name of the item");
        String Input_item = S1.nextLine();
        System.out.println("Enter the price of the item");
        int Input_price = S1.nextInt();
        int availability = 1 ;
        while(true){
            System.out.println("Enter the foord category");
            String User_input = S1.nextLine();
            if(User_input.equals("1")){
                break;
            }
            AL1.add(Input_item);
        }

        Menu_Management menu = new Menu_Management(Input_item, Input_price, availability , AL1);
        Menu.put(Input_item,menu);
        MenuSet.add(menu);
        M1.menu_landing();
    }

    @Override
    public void remove_items() {
        System.out.println("Enter the name of the item");
        String Input_item = S1.nextLine();
        for(Menu_schema item: Menu.values()){
            System.out.println(item.get_item());
            if(item.get_item().equals(Input_item)){
                item.set_availability(0);
                for(Order_schema orders : Order_schema.Orders){
                    if(orders.item.equals(Input_item)){
                        orders.Status = "denied" ;
                    }
                }
                //MenuSet.remove(item);
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
        System.out.println("1. Update Category \n2. Update Items \n3. Update Item Feild");
        String Input = S1.nextLine();
        if(Input.equals("1")){
            System.out.println("1. Remove Category \n2. Add Category");
            String INput2 = S1.nextLine();
            if(INput2.equals("1")){
                System.out.println("Enter the name of item");
                String Input_item = S1.nextLine();
                for(Menu_schema item: Menu.values()){
                    if(item.get_item().equals(Input_item)){
                        System.out.println(item.get_category());
                        System.out.println("Enter item to remove");
                        String Input_category = S1.nextLine();
                        item.get_category().remove(Input_category);
                        System.out.println(item.get_category());
                    }
                }
            }
            if(INput2.equals("2")){
                System.out.println("Enter the name of item");
                String Input_item = S1.nextLine();
                for(Menu_schema item: Menu.values()){
                    if(item.get_item().equals(Input_item)){
                        System.out.println(item.get_category());
                        System.out.println("Enter item to add");
                        String Input_category = S1.nextLine();
                        item.get_category().add(Input_category);
                        System.out.println(item.get_category());
                    }
                }
            }
        }
        if(Input.equals("2")){
            System.out.println("Enter the name of item");
            String Input_item = S1.nextLine();
            for(Menu_schema item: Menu.values()){
                if(item.get_item().equals(Input_item)){
                    System.out.println("Enter updated item");
                    String input_item = S1.nextLine();
                    item.set_item(input_item);
                }
            }
        }
        if(Input.equals("3")){
            System.out.println("Enter the name of item");
            String Input_item = S1.nextLine();
            for(Menu_schema item: Menu.values()){
                if(item.get_item().equals(Input_item)){
                    System.out.println("1.Update Availability \n2.Update Price");
                    String input_item = S1.nextLine();
                    if(input_item.equals("1")){
                        System.out.println("Enter the availability");
                        int Input_availability = S1.nextInt();
                        item.set_availability(Input_availability);
                    }
                    if(input_item.equals("2")){
                        System.out.println("Enter the price");
                        int Input_price = S1.nextInt();
                        item.set_price(Input_price);
                    }
                }
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
