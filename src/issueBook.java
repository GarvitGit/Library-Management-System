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
import javax.swing.JTextField;

public class issueBook extends JFrame{
	static JFrame frame;
	private JLabel isbnlabel,idlabel;
	private JTextField isbn,id;
	private JButton issue;
	private int i,k;
	
	public static void main(){
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				try{
					frame=new issueBook();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
		});
	}
private issueBook(){
	super("Issue Book");
	setLayout(new FlowLayout());
	isbnlabel=new JLabel("ISBN:");
	add(isbnlabel);
	isbn=new JTextField(20);
	add(isbn);
	idlabel=new JLabel("Student ID:");
	id=new JTextField(20);
	add(idlabel);
	add(id);
	issue=new JButton("Issue");
	issue.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent arg0) {
			try {
				Connection conn=db.getConnection();
				Statement stmnt=conn.createStatement();
				Statement stmnt2=conn.createStatement();
				ResultSet rs2;
				ResultSet rs=stmnt.executeQuery("SELECT * FROM student WHERE id='"+id.getText()+"';");
				if(!rs.next()){
					JOptionPane.showMessageDialog(null, "Student doesn't exist!");
				}else{
					k=Integer.parseInt(rs.getString("totalbooks"));
					k++;
					rs2=stmnt2.executeQuery("SELECT * FROM book WHERE isbn='"+isbn.getText()+"';");
					if(!rs2.next())
						JOptionPane.showMessageDialog(null, "Book doesn't exist!");
					else{
						if(Integer.parseInt(rs2.getString("issued"))==1){
							JOptionPane.showMessageDialog(null, "Book already issued!");
						}
						else{
							i=stmnt.executeUpdate("UPDATE student SET totalbooks='"+k+"' WHERE id='"+
									id.getText()+"';");
							i=stmnt2.executeUpdate("UPDATE book SET issued='1',ids='"+id.getText()+"' WHERE isbn='"+
						isbn.getText()+"';");
							JOptionPane.showMessageDialog(null, "Book issued!");
							frame.dispose();
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	});
	add(issue);
	setVisible(true);
	setSize(340,250);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}