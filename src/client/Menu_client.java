package page.client;

import page.server.Admin.Menu_Management.Menu_schema;
import page.server.Customer.Browse_Menu.Browse_Menu_landing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Menu_client extends JFrame {
    ArrayList<String> ARR1 = new ArrayList<>();
    ArrayList<ArrayList<String>> ARR2 = new ArrayList<>();
    String Temp ="" ;
    public void send_data(String email){
        try{
            BufferedInputStream BF1 = new BufferedInputStream(new FileInputStream("Menu.txt"));
            while(true){
                if(BF1.read() == -1){
                    break;
                }
                while(true){
                    char value = (char)BF1.read();
                    if(value == '\n' ){
                        String[] val = Temp.split(",");
                        String A = val[0] ;
                        String B = val[1] ;
                        String C = val[2] ;
                        ARR1.add(A);
                        ARR1.add(B);
                        ARR1.add(C);
                        //ARR1.add(Temp);
                        Temp = "";
                        break;
                    }
                    else{
                        Temp = Temp + value;
                    }
                }
                ARR2.add(new ArrayList<>(ARR1));
                ARR1.clear();
            }
            BF1.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        menu_client(email);
    }
    public void menu_client(String email) {
        setLayout(null);
        JButton B1 = new JButton("Back");
        B1.setBounds(300,100,100,40);
        add(B1);
        B1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Browse_Menu_landing B1 = new Browse_Menu_landing();
                B1.browse_menu(email);
                dispose();
            }
        });
        setSize(1980,1080);
        String column[] ={"item","price","availability"};
        DefaultTableModel model = new DefaultTableModel(column,0);
        for(ArrayList<String> item : ARR2){
            Object[] abc = {item.get(0),item.get(1),item.get(2)};
            model.addRow(abc);
            System.out.println(item.get(0) + "," + item.get(1) + "," + item.get(2));
        }
        JTable table = new JTable(model);
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(300,300,500,500);
        this.add(pane);
        setVisible(true);


    }
}
