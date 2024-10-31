package User;


import User.User_schema ;
public class User_samples {
    public static void user_samples(){
        User_schema S1 = new User_schema("Kunal","123","kunal@iiitd.ac.in",null,null, 0);
        User_schema S2 = new User_schema("jagan","123","jagan@iiitd.ac.in",null,null,0);
        User_schema S3 = new User_schema("aman","123","aman@iiitd.ac.in",null,null,1);

        User_schema.User_schema_List.add(S1);
        User_schema.User_schema_List.add(S2);
        User_schema.User_schema_List.add(S3);
    }
}
