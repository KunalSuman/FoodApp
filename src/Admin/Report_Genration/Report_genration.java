package Admin.Report_Genration;

import Admin.Order_Management.Order_schema ;
import src.Admin.Admin_landing ;
import static java.lang.Integer.parseInt;

public class Report_genration {
    public void report(){
        int money = 0 ;
        for(Order_schema order : Order_schema.Orders){
            if(order.Payment.equals("Done")){
                money = money + order.price;
            }
        }
        System.out.println("money genrated " + money + "Total Orders " + Order_schema.Orders.size());
        Admin_landing AL1 = new Admin_landing();
        AL1.admin_landing();
    }
}
