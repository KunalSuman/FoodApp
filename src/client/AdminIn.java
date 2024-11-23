package page.client;

import page.server.Admin.Admin_landing;
import page.server.Admin.Menu_Management.Menu_landing;
import page.server.Admin.Order_Management.Order_landing;
import page.server.Admin.Report_Genration.Report_genration;
import javax.swing.* ;
import java.awt.*;
import java.awt.event.ActionListener ;
import java.awt.event.ActionEvent ;

public class AdminIn extends JFrame {
	public AdminIn(){
		JLabel L1 = new JLabel("Menu Management");
		JLabel L2 = new JLabel("Order Management");
		JLabel L3 = new JLabel("Report Genration");
		JLabel L4 = new JLabel("Return");
		JButton B1 = new JButton("Menu Management");
		JButton B2 = new JButton("Order management");
		JButton B3 = new JButton("Report Genration");
		setLayout(null);
		B1.setBounds(980,500,100,50);
		B2.setBounds(980,600,100,50);
		B3.setBounds(980,700,100,50);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		B1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Menu_landing menu = new Menu_landing("",0,0);
				menu.menu_landing();
			}
		});
		B2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Order_landing OL1 = new Order_landing();
				OL1.order_landing();
			}
		});
		B3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Report_genration RP1 = new Report_genration();
				RP1.report();
			}
		});
		add(B1);
		add(B2);
		add(B3);
		setVisible(true);

		setSize(1980,1080);
	}
}
