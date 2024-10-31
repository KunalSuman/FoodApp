package Admin.Menu_Management;

import java.util.* ;

public class Menu_schema{
    private String item ;
    private int price ;
    private int availability ;
    private String description ;
    private int count = 0 ;
    private ArrayList<String> Category;
    public static TreeMap<String,Menu_schema> Menu = new TreeMap<>() ;
    public static TreeSet<Menu_schema> MenuSet = new TreeSet<>(Comparator.comparing(Menu_schema::get_price)) ;
    public static HashMap<String,HashMap<String,String>> Reviews = new HashMap<>() ;

    public Menu_schema(String item ,int price ,int availability, ArrayList<String> Category){
        this.item = item ;
        this.price = price ;
        this.availability = availability ;
        this.Category = Category ;
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
    public ArrayList<String> get_category(){
        return Category ;
    }
    public void set_Category(ArrayList<String> Category){
        this.Category = Category ;
    }
    public int get_availability(){
        return availability ;
    }
}
