package Customer.Browse_Menu;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import Admin.Menu_Management.Menu_schema ;
public class Browse_menu_functionalities implements Items_Interface {
    Scanner S1 = new Scanner(System.in);
    private Browse_Menu_landing BML1 = new Browse_Menu_landing();
    @Override
    public void View_items(String email) {
        for(Menu_schema items : Menu_schema.Menu.values()){
            System.out.println(items.get_item() + " " + items.get_price() + " " + items.get_availability());
        }
        BML1.browse_menu(email);
    }

    @Override
    public void Search_items(String email) {
        System.out.println("Enter the item name");
        String User_input_dish = S1.nextLine();
        for(Menu_schema items : Menu_schema.Menu.values()){
            if(User_input_dish.equals(items.get_item())){
                System.out.println(items.get_price() + " " + items.get_availability());
            }
        }
        BML1.browse_menu(email);
    }

    @Override
    public void Filter_category(String email) {

    }

    @Override
    public void Sort_items(String email) {
        ArrayList<Menu_schema> temp = new ArrayList<>();
        System.out.println("1.Increasing \n2.Decreasing ");
        int User_input = S1.nextInt();
        if(User_input == 1){
            for(Menu_schema items : Menu_schema.MenuSet){
                System.out.println(items.get_item() + " " + items.get_price() + " " + items.get_availability());
            }
        }
        else if(User_input == 2){
            for(Menu_schema items : Menu_schema.MenuSet){
                temp.add(items);
            }
            for(int i = temp.size()-1;i>=0;i-- ){
                System.out.println(temp.get(i).get_item() + " " + temp.get(i).get_price() + " " + temp.get(i).get_availability());
            }
        }
        BML1.browse_menu(email);
    }
}
