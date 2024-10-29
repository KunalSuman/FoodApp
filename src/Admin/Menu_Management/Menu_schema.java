package Admin.Menu_Management;

import java.util.* ;

public class Menu_schema{
    private String item ;
    private int price ;
    private int availability ;
    private int count = 0 ;
    //public static ArrayList<Menu_schema> Menu = new ArrayList<>() ;
    public static TreeMap<String,Menu_schema> Menu = new TreeMap<>() ;
    public static TreeSet<Menu_schema> MenuSet = new TreeSet<>(Comparator.comparing(Menu_schema::get_price)) ;

    public Menu_schema(String item ,int price ,int availability){
        this.item = item ;
        this.price = price ;
        this.availability = availability ;
    }
    public void set_item(String item){
        this.item = item ;
    }
    public void set_price(int price){
        this.price = price ;
    }
    public void set_availability(int availability){
        this.availability = availability ;
    }
    public String get_item(){
        return item ;
    }
    public int get_price(){
        return price ;
    }
    public int get_availability(){
        return availability ;
    }
}
