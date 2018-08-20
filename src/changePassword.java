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

public class changePassword extends JFrame{
	static JFrame frame;
	private JLabel passwordlabel;
	private JPasswordField password;
	private JButton done;
	
	public static void main(int id) {
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try{
					frame=new changePassword(id);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		}
	private changePassword(int id){
		super("Change Password");
		setLayout(new FlowLayout());
		passwordlabel=new JLabel("Enter new Password:");
		add(passwordlabel);
		password=new JPasswordField(20);
		add(password);
		done=new JButton("Done");
		done.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn=db.getConnection();
					Statement stmnt= conn.createStatement();
					Statement stmnt2=conn.createStatement();
					ResultSet rs=stmnt.executeQuery("select * from student where id='"+id+"';");
					rs.next();
					int i=stmnt2.executeUpdate("update student set pass='"+String.valueOf(password.getPassword())+"' where id"
							+"='"+id+"';");
					JOptionPane.showMessageDialog(null, "Password Updated!");
					frame.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
			
		});
		add(done);
		setVisible(true);
		setSize(340,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
