package Customer.Cart_Operations;

import java.util.ArrayList;

public class User_cart {
    public String item ;
    public int price ;
    public int quantity ;
    public String user_id ;

    //public static ArrayList<User_cart> order_history = new ArrayList<User_cart>();
    public static ArrayList<User_cart> user_cart = new ArrayList<>();

    public User_cart(String item, String user_id ,int price, int quantity) {
        this.item = item;
        this.price = price;
        this.quantity = quantity;
        this.user_id = user_id;
    }
}
