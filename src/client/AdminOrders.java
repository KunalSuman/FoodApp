package page.client;

import org.junit.jupiter.api.Order;
import page.server.Admin.Order_Management.Order_landing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class AdminOrders extends JFrame {
    String Temp ="" ;
    ArrayList<String> ARR1 = new ArrayList<>();
    ArrayList<ArrayList<String>> ARR2 = new ArrayList<>();
    public void send_data(){
        try{
            BufferedInputStream BF1 = new BufferedInputStream(new FileInputStream("Pending_Orders.txt"));
            while(true){
                if(BF1.read() == -1){
                    break;
                }
                while (true){
                    char c = (char)BF1.read();
                    if(c == '\n'){
                        String[] val = Temp.split(",");
                        String A  = val[0];
                        String B  = val[1];
                        String C  = val[2];
                        String D  = val[3];
                        String E  = val[4];
                        String F  = val[5];
                        String G  = val[6];
                        ARR1.add(A);
                        ARR1.add(B);
                        ARR1.add(C);
                        ARR1.add(D);
                        ARR1.add(E);
                        ARR1.add(F);
                        ARR1.add(G);
                        Temp = "" ;
                        break;
                    }
                    else{
                        Temp = Temp + c;
                    }
                }
                ARR2.add(new ArrayList<>(ARR1));
                ARR1.clear();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        adminOrders();
    }
    public void adminOrders() {
        JButton B1 = new JButton("Return");
        setLayout(null);
        B1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Order_landing o = new Order_landing();
                o.order_landing();
            }
        });
        setSize(1920,1080);
        String column[] = {"id","Order","Email","Payment","Price","Quantity","Status"};
        DefaultTableModel model = new DefaultTableModel(column,0);
        for(ArrayList<String> arr : ARR2){
            Object[] abc = {arr.get(0),arr.get(1),arr.get(2),arr.get(3),arr.get(4),arr.get(5),arr.get(6)} ;
            model.addRow(abc);
        }
        JTable table = new JTable(model);
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(300,300,600,600);
        B1.setBounds(300,10,100,40);
        add(jsp);
        add(B1);
        setVisible(true);
    }
}
