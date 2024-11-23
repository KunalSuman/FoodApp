package page.server.Customer.Order_Tracking;

import page.server.Admin.Order_Management.Order_schema;
import page.server.Customer.Order_Tracking.Order_Tracking_landing ;
import java.util.Scanner;
import page.server.Customer.Cart_Operations.Cart_functionalities;

public class Order_Tracking_functionality {
    private Order_Tracking_landing OTL1 = new Order_Tracking_landing();

    public void view_order_status(String email) {
        for (Order_schema order : Order_schema.Orders) {
            if (order.student_id.equals(email) && order.Status != "Completed" && order.Payment.equals("Done")) {
                System.out.println("Item -> " + order.item + " Status -> " + order.Status);
            }
        }
        OTL1.order_tracking_landing(email);
    }

    public void cancel_order(String email) {
        System.out.println("Enter the Item");
        Scanner S1 = new Scanner(System.in);
        String input = S1.nextLine();
        for (Order_schema order : Order_schema.Orders) {
            if (order.student_id.equals(email) && order.Status == "Pending" && order.Payment.equals("Done") && order.item.equals(input)) {
                order.Status = "Cancelled";
                order.Payment = "Refunded";
                System.out.println("Order cancelled");
            }
        }
        OTL1.order_tracking_landing(email);
    }

    public void orders_history(String email) {
        for (Order_schema order : Order_schema.Orders) {
            if (order.student_id.equals(email) && order.Status.equals("Completed")) {
                System.out.println("Order Id" + order.Order_id + "Item -> " + order.item + "Quantity -> " + order.quantity + " Status -> " + order.Status);
            }
        }
        System.out.println("1.Reorder \n2.Back");
        Scanner S1 = new Scanner(System.in);
        int choice = S1.nextInt();
        if (choice == 1) {
            System.out.println("Enter the order Id");
            int orderId = S1.nextInt();
            for (Order_schema order : Order_schema.Orders) {
                if (order.student_id.equals(email) && order.Order_id == orderId) {
                    Cart_functionalities CF1 = new Cart_functionalities();
                    CF1.Add_items(email, order.VIP);
                }
            }
        }
        else if (choice == 2) {
            OTL1.order_tracking_landing(email);
        }
        OTL1.order_tracking_landing(email);
    }
}