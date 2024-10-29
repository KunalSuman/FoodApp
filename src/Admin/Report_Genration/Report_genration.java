package src.Admin.Report_Genration;

import Admin.Order_Management.Order_schema ;

import static java.lang.Integer.parseInt;

public class Report_genration {
    public void report(){
        int money = 0 ;
        for(Order_schema order : Order_schema.Orders){
            if(order.Payment != "Refunded"){
                money = money + parseInt(order.Payment);
            }

        }
        System.out.println("money genrated " + money + "Total Orders " + Order_schema.Orders.size());
    }
}
