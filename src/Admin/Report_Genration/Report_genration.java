package Admin.Report_Genration;

import Admin.Order_Management.Order_schema ;
import src.Admin.Admin_landing ;

import java.util.ArrayList;
import java.util.Collection;

import static java.lang.Integer.parseInt;

public class Report_genration {
    public void report(){
        int money = 0 ;
        for(Order_schema order : Order_schema.Orders){
            int value = 0 ;
            if(order.Payment.equals("Done")){
                money = money + order.price;
                if(Order_schema.order_frequency.containsKey(order.item)){
                    value = Order_schema.order_frequency.get(order.item) ;
                    value = value + order.quantity;
                    Order_schema.order_frequency.put(order.item,value);
                }
                else{
                    Order_schema.order_frequency.put(order.item,order.quantity);
                }
            }
        }
        int max = 0 ;
        ArrayList<String> freqs_o = new ArrayList<>();
        for(String fre_q : Order_schema.order_frequency.keySet()){
            if(Order_schema.order_frequency.get(fre_q)>max){
                max = Order_schema.order_frequency.get(fre_q) ;
                freqs_o.add(fre_q);
            }
        }
        System.out.println("money genrated " + money + "Total Orders " + Order_schema.Orders.size() + " Frequency " + "Highest is" +freqs_o.get(freqs_o.size()-1) + Order_schema.order_frequency);
        Admin_landing AL1 = new Admin_landing();
        AL1.admin_landing();
    }
}
