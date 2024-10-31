package src.Admin.Menu_Management;

import Admin.Menu_Management.Menu_schema ;

import java.util.ArrayList;

public class Menu_sample {
        public static void menu_sample() {
            ArrayList<String> M1_category = new ArrayList<>();
            M1_category.add("bevrages");
            M1_category.add("meals") ;
            ArrayList<String> M2_category = new ArrayList<>();
            M2_category.add("bevrages ");
            M2_category.add("veg");
            ArrayList<String> M3_category = new ArrayList<>();
            M3_category.add("meals");
            M3_category.add("snacks");
            ArrayList<String> M4_category = new ArrayList<>();
            M4_category.add("snacks");
            Menu_schema  M1 = new Menu_schema("McD" , 100 ,1 , M1_category);
            Menu_schema  M2 = new Menu_schema("KFC" , 200 ,1 , M2_category );
            Menu_schema  M3 = new Menu_schema("BK" , 300 ,1 , M3_category);
            Menu_schema  M4 = new Menu_schema("Popyes" , 400 ,1 , M4_category);

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
