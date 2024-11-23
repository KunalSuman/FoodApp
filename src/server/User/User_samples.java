package page.server.User;


import page.server.User.User_schema ;

import java.io.*;

public class User_samples {
    public static void user_samples(){
        String Temp = "0";
        User_schema S1 = new User_schema("Kunal","123","kunal@iiitd.ac.in",null,null, 0);
        User_schema S2 = new User_schema("jagan","123","jagan@iiitd.ac.in",null,null,0);
        User_schema S3 = new User_schema("aman","123","aman@iiitd.ac.in",null,null,1);

        User_schema.User_schema_List.add(S1);
        User_schema.User_schema_List.add(S2);
        User_schema.User_schema_List.add(S3);

        try{
            BufferedInputStream BF1 = new BufferedInputStream(new FileInputStream("Users_data.txt"));
            while(true){
                char value = (char)BF1.read();
                if(BF1.read() == -1) {
                    break;
                }
                Temp = "1";
            }
            BF1.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        try {
            BufferedOutputStream F1 = new BufferedOutputStream(new FileOutputStream("Users_data.txt",true));
            if(Temp.equals("0")) {
                for (User_schema item : User_schema.User_schema_List) {
                    F1.write((item.getUser_name() + "," + item.getPassword() + "," + item.getEmail() + "," + item.getVIP() + "\n").getBytes());
                }
                F1.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
