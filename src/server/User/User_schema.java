package page.server.User;

import page.server.Customer.Cart_Operations.User_cart;

import java.util.ArrayList;

public class User_schema {
    private String User_name;
    private String Password;
    private String Email;
    private int VIP ;
    public static ArrayList<User_cart> US = new ArrayList<>();
    public static ArrayList<User_cart> cart_history = new ArrayList<User_cart>();

    public static ArrayList<User_schema> User_schema_List = new ArrayList<User_schema>();
    public User_schema(String User_name, String Password, String Email , ArrayList<User_cart> US , ArrayList<User_cart> cart_history ,int VIP) {
        this.User_name = User_name;
        this.Password = Password;
        this.Email = Email;
        this.US = US;
        this.cart_history = cart_history;
        this.VIP = VIP;
    }

    public String getEmail() {
        return Email;
    }
    public int getVIP() {
        return VIP;
    }
    public void setVIP(int VIP) {
        this.VIP = VIP;
    }
    public String getPassword() {
        return Password;
    }
    public String getUser_name() {
        return User_name;
    }
    public void setUser_name(String User_name) {
        this.User_name = User_name;
    }
    public void setPassword(String Password) {
        this.Password = Password;
    }
    public void setEmail(String Email) {
        this.Email = Email;
    }

}
