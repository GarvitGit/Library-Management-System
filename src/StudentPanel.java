import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class StudentPanel extends JFrame{
	static JFrame frame;
	private JButton login;
	private JLabel user,pass;
	private JTextField username;
	private JPasswordField password;

	public static void main(){
		try{
			frame=new StudentPanel();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public StudentPanel(){
		super("Student Login");
		setLayout(new FlowLayout());
		user=new JLabel("Enter Username:");
		add(user);
		username=new JTextField(20);
		username.setToolTipText("Enter your username here.");
		add(username);
		pass=new JLabel("Enter Password");
		add(pass);
		password=new JPasswordField(20);
		password.setToolTipText("Enter your password here.");
		add(password);
		login=new JButton("Login");
		login.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection conn=db.getConnection();
					Statement smnt=conn.createStatement();
					ResultSet rs=smnt.executeQuery("select * from student where user='"+username.getText()+"';");
					if(rs.next()){
						if(String.valueOf(password.getPassword()).equals(rs.getString("pass"))){
							StudentPage.main(Integer.parseInt(rs.getString("id")));
							frame.dispose();
						}else
							JOptionPane.showMessageDialog(null, "Password is Incorrect!");
					}else{
						JOptionPane.showMessageDialog(null, "Incorrect Username!");
					}
						
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		add(login);
		setVisible(true);
		setSize(400,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
