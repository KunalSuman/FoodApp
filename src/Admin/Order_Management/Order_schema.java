package Admin.Order_Management;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Order_schema {
    public String item ;
    public String student_id;
    public String Status ;
    public String Payment ;
    public int quantity ;
    public int Order_id ;
    public static Queue<Order_schema> Orders = new LinkedList<Order_schema>() ;

    public Order_schema(String item ,String student_id ,String Status ,String Payment , int quantity ,int Order_id ) {
        this.item = item;
        this.student_id = student_id;
        this.Payment = Payment;
        this.Status = Status;
        this.quantity = quantity;
        this.Order_id = Order_id;
    }
}