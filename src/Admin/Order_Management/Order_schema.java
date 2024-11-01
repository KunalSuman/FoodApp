package Admin.Order_Management;

import java.util.*;

public class Order_schema {
    public String item ;
    public String student_id;
    public String Status ;
    public String Payment ;
    public int quantity ;
    public int Order_id ;
    public int price ;
    public String address ;
    public int VIP ;
    public String Instructions ;
    public static Queue<Order_schema> Orders = new LinkedList<Order_schema>() ;
    public static HashMap<String , Integer> order_frequency = new HashMap<>() ;

    public Order_schema(String item ,String student_id ,String Status ,String Payment , int quantity ,int Order_id ,int price , String address ,int VIP ,String Instructions ) {
        this.item = item;
        this.student_id = student_id;
        this.Payment = Payment;
        this.Status = Status;
        this.quantity = quantity;
        this.Order_id = Order_id;
        this.price = price;
        this.address = address;
        this.VIP = VIP;
        this.Instructions = Instructions;
    }
}