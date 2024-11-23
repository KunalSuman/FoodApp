package page.client;
import page.server.User.SignUp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUP extends JFrame{
	public SignUP(){
		setLayout(null);
		JLabel L1 = new JLabel("Username");
		JLabel L2 = new JLabel("Password");
		JLabel L3 = new JLabel("Email");
		JTextField TF1 = new JTextField();
		JTextField TF2 = new JTextField();
		JTextField TF3 = new JTextField();
		JButton B1 = new JButton("SignUP");
		B1.setBounds(980,700,100,50);
		TF1.setBounds(1000,400,100,20);
		TF2.setBounds(1000,500,100,20);
		TF3.setBounds(1000,600,100,20);
		L1.setBounds(900,400,100,20);
		L2.setBounds(900,500,100,20);
		L3.setBounds(900,600,100,20);
		add(L1);
		add(L2);
		add(L3);
		add(TF1);
		add(TF2);
		add(TF3);
		add(B1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		B1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String Username = TF1.getText();
				String Password = TF2.getText();
				String Email = TF3.getText();
				SignUp.signup(Username,Password,Email);
				dispose();
			}
		});
		setVisible(true);
		setSize(1920,1080);

	}
}
