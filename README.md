components : Admin 
             Customer
             User

Data_Structures used are ArrayList for carts LinkedList and queue for management of orders and payments , use of TreeMap and TreeSets for Menu and Menu_schema and Hashmap for reviews management
Date changed is controlled by Sennsion time so each termination will count for date change:wq

Admin consists of functions of Menu_management , Order_Management ,Report_orientation , Admin_landing class and Management_interface these classes encapulation and other oops concept
            Menu_management class extends menu_sample and implements management_interface and this same for Menu_landing extends Menu_schema
            Order_manageamnt class works on order_schema and order_management 

Customer consists of Browse_Menu , Cart_options ,Order_tracking , Review ,Customer_landing class and Vip_status
            Browse_menu consists of landing class ,functionalities and  Items_interface 
            Cart_functionalities consists of landing class functionalities class and user_cart twhich stores information of a individual customer
            Order_tracking consists of functionality and landing 
            Reviews contains functionality class landing class sample class and schema class 
            Customer landing and vip status 

Finally User page coso=ists fo userfunctions such as sign signup and samples 


.
├── Admin
│   ├── Admin_landing.java
│   ├── Management_interface.java
│   ├── Menu_Management
│   │   ├── Menu_Management.java
│   │   ├── Menu_landing.java
│   │   ├── Menu_sample.java
│   │   └── Menu_schema.java
│   ├── Order_Management
│   │   ├── Order_Management.java
│   │   ├── Order_landing.java
│   │   └── Order_schema.java
│   └── Report_Genration
│       └── Report_genration.java
├── Application_page.java
├── Customer
│   ├── Browse_Menu
│   │   ├── Browse_Menu_landing.java
│   │   ├── Browse_menu_functionalities.java
│   │   └── Items_Interface.java
│   ├── Cart_Operations
│   │   ├── Cart_functionalities.java
│   │   ├── Cart_landing.java
│   │   └── User_cart.java
│   ├── Customer_landing.java
│   ├── Order_Tracking
│   │   ├── Order_Tracking_functionality.java
│   │   └── Order_Tracking_landing.java
│   ├── Review
│   │   ├── Review_Landing.java
│   │   ├── Review_functionality.java
│   │   ├── Review_sample.java
│   │   └── Review_schema.java
│   └── Vip_status.java
├── Exception
│   └── BadInputException.java
├── Main.java
└── User
├── SignIn.java
├── SignUp.java
├── User_samples.java
└── User_schema.java
