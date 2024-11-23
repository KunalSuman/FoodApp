package page.client;

import javax.swing.*;
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
                        ARR1.add(A);
                        ARR1.add(B);
                        ARR1.add(C);
                        ARR1.add(D);
                        ARR1.add(E);
                        Temp = " " ;
                        break;
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void adminOrders() {

        setVisible(true);
        setSize(1920, 1080);
    }
}
