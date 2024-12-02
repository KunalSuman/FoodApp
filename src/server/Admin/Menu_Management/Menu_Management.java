package page.server.Admin.Menu_Management ;

import page.server.Admin.Menu_Management.Menu_schema ;
import page.server.Admin.Management_interface ;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import page.server.Admin.Menu_Management.Menu_landing;
import page.server.Admin.Order_Management.Order_schema ;
public class Menu_Management extends Menu_schema implements Management_interface {
    public Scanner S1 = new Scanner (System.in);
    public Menu_landing M1 = new Menu_landing("",0,0);
    public ArrayList<String> AL1 = new ArrayList<>();
    public ArrayList<String> temp = new ArrayList<>();
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
            System.out.println("Enter the ford category");
            String User_input = S1.nextLine();
            if(User_input.equals("1")){
                break;
            }
            AL1.add(Input_item);
        }
	try{
	   BufferedOutputStream F1 = new BufferedOutputStream( new FileOutputStream("Menu.txt",true));
	   F1.write((" "+Input_item + "," + Input_price + "," + availability + "\n").getBytes());
	   F1.close();
	}catch(IOException e){
	   e.printStackTrace();
	}
        Menu_Management menu = new Menu_Management(Input_item, Input_price, availability , AL1);
        Menu.put(Input_item,menu);
        MenuSet.add(menu);
        M1.menu_landing();
    }

    @Override
    public void remove_items() {
        ArrayList<String> ARR1 = new ArrayList<>();
        ArrayList<ArrayList<String>> ARR2 = new ArrayList<>();
        String Temp ="" ;
        System.out.println("Enter the name of the item");
        String Input_item = S1.nextLine();
        for(Menu_schema item: Menu.values()){
            System.out.println(item.get_item());
            if(item.get_item().equals(Input_item)){
                item.set_availability(0);
                for(Order_schema orders : Order_schema.Orders){
                    if(orders.item.equals(Input_item)){
                        orders.Status = "denied" ;
                        if(orders.Payment.equals("Done")){
                            orders.Payment ="canceled";
                        }
                    }
                }
            }
        }
        try{
            BufferedInputStream BF1 = new BufferedInputStream(new FileInputStream("Menu.txt"));
            while(true){
                if(BF1.read() == -1){
                    break;
                }
                while(true){
                    char value = (char)BF1.read();
                    if(value == '\n' ){
                        String[] val = Temp.split(",");
                        String A = val[0] ;
                        String B = val[1] ;
                        String C = val[2] ;
                        ARR1.add(A);
                        ARR1.add(B);
                        ARR1.add(C);
                        //ARR1.add(Temp);
                        Temp = "";
                        break;
                    }
                    else{
                        Temp = Temp + value;
                    }
                }
                ARR2.add(new ArrayList<>(ARR1));
                ARR1.clear();
            }
            BF1.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        try{
            BufferedOutputStream BF1 = new BufferedOutputStream(new FileOutputStream("Menu.txt"));
            BF1.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            BufferedOutputStream F1 = new BufferedOutputStream(new FileOutputStream("Menu.txt",true));
            for(ArrayList<String> item : ARR2){
                if(item.get(0).equals(Input_item)){
                    System.out.println(item.get(1));
                }else{
                    F1.write((" "+item.get(0) + "," + item.get(1) + "," + item.get(2)+'\n').getBytes());
                }
            }
            F1.close();
        }catch(IOException e){
            e.printStackTrace();
	 }
	 M1.menu_landing();
    }

    @Override
    public void modify_prices() {
        ArrayList<String> ARR1 = new ArrayList<>();
        ArrayList<ArrayList<String>> ARR2 = new ArrayList<>();
        String Temp ="" ;
        System.out.println("Enter the name of item");
        String Input_item = S1.nextLine();
        System.out.println("Enter new price");
        int Input_price = S1.nextInt();
        for(Menu_schema item: Menu.values()){
            if(item.get_item().equals(Input_item)){
                item.set_price(Input_price);
            }
        }
        try{
            BufferedInputStream BF1 = new BufferedInputStream(new FileInputStream("Menu.txt"));
            while(true){
                if(BF1.read() == -1){
                    break;
                }
                while(true){
                    char value = (char)BF1.read();
                    if(value == '\n' ){
                        String[] val = Temp.split(",");
                        String A = val[0] ;
                        String B = val[1] ;
                        String C = val[2] ;
                        ARR1.add(A);
                        ARR1.add(B);
                        ARR1.add(C);
                        //ARR1.add(Temp);
                        Temp = "";
                        break;
                    }
                    else{
                        Temp = Temp + value;
                    }
                }
                ARR2.add(new ArrayList<>(ARR1));
                ARR1.clear();
            }
            BF1.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        try{
            BufferedOutputStream BF1 = new BufferedOutputStream(new FileOutputStream("Menu.txt"));
            BF1.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            BufferedOutputStream F1 = new BufferedOutputStream(new FileOutputStream("Menu.txt",true));
            for(ArrayList<String> item : ARR2){
                if(item.get(0).equals(Input_item)){
                    item.set(2, String.valueOf(Input_price));
                }
                F1.write((" "+item.get(0) + "," + item.get(1) + "," + item.get(2)+'\n').getBytes());
            }
            F1.close();
        }catch(IOException e){
            e.printStackTrace();
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
            System.out.println("1.Update Availability \n2.Update Price");
            String input_item = S1.nextLine();
            if(input_item.equals("1")){
                for(Menu_schema item: Menu.values()){
                    if(item.get_item().equals(Input_item)){
                            System.out.println("Enter the availability");
                            int Input_availability = S1.nextInt();
                            item.set_availability(Input_availability);
                    }

                }
            }
            if(input_item.equals("2")){
                for(Menu_schema item: Menu.values()){
                    if(item.get_item().equals(Input_item)){
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
        ArrayList<String> ARR1 = new ArrayList<>();
        ArrayList<ArrayList<String>> ARR2 = new ArrayList<>();
        String Temp ="" ;
        System.out.println("Enter the name of item");
        String Input_item = S1.nextLine();
        System.out.println("Enter new status");
        int Input_availabilty = S1.nextInt();
        for(Menu_schema item: Menu.values()){
            if(item.get_item().equals(Input_item)){
                item.set_price(Input_availabilty);
            }
        }
        for(Menu_schema item: MenuSet){
            if(item.get_item().equals(Input_item)){
                item.set_availability(Input_availabilty);
            }
        }
        try{
            BufferedInputStream BF1 = new BufferedInputStream(new FileInputStream("Menu.txt"));
            while(true){
                if(BF1.read() == -1){
                    break;
                }
                while(true){
                    char value = (char)BF1.read();
                    if(value == '\n' ){
                        String[] val = Temp.split(",");
                        String A = val[0] ;
                        String B = val[1] ;
                        String C = val[2] ;
                        ARR1.add(A);
                        ARR1.add(B);
                        ARR1.add(C);
                        //ARR1.add(Temp);
                        Temp = "";
                        break;
                    }
                    else{
                        Temp = Temp + value;
                    }
                }
                ARR2.add(new ArrayList<>(ARR1));
                ARR1.clear();
            }
            BF1.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        try{
            BufferedOutputStream BF1 = new BufferedOutputStream(new FileOutputStream("Menu.txt"));
            BF1.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            BufferedOutputStream F1 = new BufferedOutputStream(new FileOutputStream("Menu.txt",true));
            for(ArrayList<String> item : ARR2){
                if(item.get(0).equals(Input_item)){
                    item.set(2, String.valueOf(Input_availabilty));
                }
                F1.write((" "+item.get(0) + "," + item.get(1) + "," + item.get(2)+'\n').getBytes());
            }
            F1.close();
        }catch(IOException e){
            e.printStackTrace();
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
