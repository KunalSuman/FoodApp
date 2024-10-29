package src.Admin.Menu_Management;

import Admin.Menu_Management.Menu_schema ;
public class Menu_sample {
        public static void menu_sample() {
            Menu_schema  M1 = new Menu_schema("McD" , 100 ,1);
            Menu_schema  M2 = new Menu_schema("KFC" , 200 ,1);
            Menu_schema  M3 = new Menu_schema("BK" , 300 ,1);
            Menu_schema  M4 = new Menu_schema("Popyes" , 400 ,1);

            Menu_schema.Menu.put("McD", M1);
            Menu_schema.Menu.put("KFC", M2);
            Menu_schema.Menu.put("BK", M3);
            Menu_schema.Menu.put("Popyes", M4);

            Menu_schema.MenuSet.add(M1);
            Menu_schema.MenuSet.add(M2);
            Menu_schema.MenuSet.add(M3);
            Menu_schema.MenuSet.add(M4);
        }
}
