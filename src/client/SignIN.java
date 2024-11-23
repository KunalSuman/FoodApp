package page.client;
import page.server.User.SignIn;
import java.awt.* ;
import javax.swing.* ;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SignIN extends JFrame {
	public SignIN(){
		setLayout(null);
		JButton B1 = new JButton("SignIN");
		JLabel L1 = new JLabel("Username") ;
		JLabel L2 = new JLabel("Password");
		JTextField TF1 = new JTextField();
		JTextField TF2 = new JTextField();
		JPanel P1 = new JPanel(null);
		P1.setBounds(600,500,500,500);
		B1.setBounds(980,400,100,50);
		TF1.setBounds(1000,300,100,20);
		TF2.setBounds(1000,500,100,20);
		L1.setBounds(900,300,100,20);
		L2.setBounds(900,500,100,20);
		add(TF1);
		add(TF2);
		add(L1);
		add(L2);
		add(B1);
		add(P1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		B1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String Username = TF1.getText();
				String Password = TF2.getText();

				SignIn.signIn(Username , Password);
				dispose();

			}	
		});

		setVisible(true);
		setSize(1920, 1080);

	}
}
