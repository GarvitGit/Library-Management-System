import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.sql.*;

public class addStudent extends JFrame{
	
	static JFrame frame;
	private JLabel name,clss,u,p,idlabel;
	private JTextField n,c,user,id;
	private JPasswordField pass;
	private JButton done;
	
	public static void main(){
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				try{
					frame=new addStudent();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
		});
	}
	private addStudent(){
		super("Details");
		setLayout(new FlowLayout());
		name=new JLabel("Name:");
		idlabel=new JLabel("ID:");
		id=new JTextField(20);
		clss=new JLabel("Class:");
		n=new JTextField(20);
		c=new JTextField(20);
		u=new JLabel("Username:");
		p=new JLabel("Password:");
		user=new JTextField(20);
		pass=new JPasswordField(20);
		add(idlabel);
		add(id);
		add(name);
		add(n);
		add(clss);
		add(c);
		add(u);
		add(user);
		add(p);
		add(pass);
		done =new JButton("Add Details");
		done.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn =db.getConnection();
					Statement mystmnt= conn.createStatement();
					Statement smnt=conn.createStatement();
					ResultSet rs=mystmnt.executeQuery("select * from student where id='"+id.getText()+"';");
					if(rs.next()){
						JOptionPane.showMessageDialog(null, "Student already exist!");
					}else{
					int i= smnt.executeUpdate("INSERT INTO student(id,name,class,totalbooks,user,pass) VALUES"
							+ "('"+id.getText()+"','"+n.getText()+"','"+c.getText()+"',0,'"+user.getText()+"','"+String.valueOf(pass.getPassword())+"');");
					JOptionPane.showMessageDialog(null, "Successdully added!");
					conn.close();
					mystmnt.close();
					frame.dispose();
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Username Already Exist!");
				}
			}
			
		});
		add(done);
		setVisible(true);
		setSize(300,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
