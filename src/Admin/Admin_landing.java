package src.Admin ;

import java.util.* ;

import Admin.Order_Management.Order_Management;
import Admin.Order_Management.Order_landing;
import Admin.Report_Genration.Report_genration;
import page.Application_page;
import src.Admin.Menu_Management.Menu_landing;
import src.Exception.BadInputException ;
public class Admin_landing{
    public void admin_landing(){
        System.out.println("1.Menu Management \n2.Order Management \n3.Report Genration \n4. Return");
        Scanner S1 = new Scanner(System.in);
        String User_input = S1.nextLine();
        try{
            if(User_input.equals("1")){
                Menu_landing menu = new Menu_landing("",0,0);
                menu.menu_landing();
            }
            else if(User_input.equals("2")){
                Order_landing OL1 = new Order_landing();
                OL1.order_landing();
            }
            else if(User_input.equals("3")){
                Report_genration RP1 = new Report_genration();
                RP1.report();
            }
            else if(User_input.equals("4")){
                Application_page AP1 = new Application_page();
                AP1.application_page();
            }
            else{
                throw new BadInputException("Enter valid input");
            }
        }
        catch(BadInputException e){
            System.out.println(e.getMessage());
        }
    }
}
