package page;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.* ;

import page.server.User.SignIn;
import page.server.User.SignUp;
import page.server.Exception.BadInputException;
import page.server.Admin.Admin_landing ;
import page.client.AdminIn;
import java.awt.event.ActionListener;

import javax.swing.*;
import page.client.SignIN ;
import page.client.SignUP ;


public class Application_page {
	public static void application_page() {
		Application_page_if abc = new Application_page_if();
//		while(true){
//			System.out.println("1. Admin \n2. Customer");
		//Scanner S1 = new Scanner(System.in);
//			int User_input = S1.nextInt();
//
//			try{
//				if(User_input == 1){
//					Admin_landing admin = new Admin_landing();
//					admin.admin_landing();
//				}
//				if(User_input == 2){
//					Customer_page_if CPF = new Customer_page_if();
//					Customer_page_if abcd = new Customer_page_if();
//					System.out.println("1. SignIn \n2. SignUp");
//					Scanner S2 = new Scanner(System.in);
//					String input = S2.nextLine();
//					if(input.equals("1")){
//						SignIn.signIn();
//					}
//					else if(input.equals("2")){
//						SignUp.signup();
//					}
//				}
//				else{
//					throw new BadInputException("Enter a valid input");
//				}
//			}
//			catch(BadInputException e){
//				System.out.println(e.getMessage());
//			}
//		}
//	}
	}
}
class Application_page_if extends JFrame{
	public Application_page_if(){
		setLayout(new FlowLayout());
		JButton Admin_Button = new JButton("Admin");
		JButton Customer_Button = new JButton("Customer");
		Admin_Button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("Admin Button clicked");
				AdminIn ADMN1 = new AdminIn();
				dispose();
			}	
		});
		Customer_Button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				Customer_page_if CP1 = new Customer_page_if();
				dispose();
			}
		});
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.RED);
		setBackground(Color.DARK_GRAY);
		panel1.add(Admin_Button);
		panel1.add(Customer_Button);
		add(panel1);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel1.setSize(700,500);
		setSize(1920,1080);
	}
}
class Customer_page_if extends JFrame{
	public Customer_page_if(){
		setLayout(null);
		JButton B1= new JButton("Login");
		JButton B2 = new JButton("SignUP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		B1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				SignIN SN1 = new SignIN();
				dispose();
			}
		});

		B2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				SignUP SU1 = new SignUP();
				dispose();
			}
		});	
		B1.setBounds(900,700,100,50);
		B2.setBounds(900,800,100,50);
		add(B1);
		add(B2);
		setSize(1920,1080);
		setVisible(true);
		}
	}
