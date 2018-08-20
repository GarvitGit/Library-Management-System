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

public class RemoveBook extends JFrame{
	static JFrame frame;
	private JLabel isbnLabel;
	private JTextField isbn;
	private JButton done;
	private int a;
	
	public static void main(){
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				try{
					frame=new RemoveBook();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
		});
	}
	private RemoveBook(){
		super("Remove Book");
		setLayout(new FlowLayout());
		isbnLabel=new JLabel("ISBN:");
		add(isbnLabel);
		isbn=new JTextField(20);
		add(isbn);
		done=new JButton("Done");
		done.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection conn =db.getConnection();
					Statement mystmnt= conn.createStatement();
					ResultSet myres =mystmnt.executeQuery("SELECT * FROM book WHERE isbn='"+isbn.getText()+"';");
					myres.next();
					a=Integer.parseInt(myres.getString("issued"));
					if(a==1){
						JOptionPane.showMessageDialog(null, "Sorry the book is issued!");
					}else{
						int ij= mystmnt.executeUpdate("DELETE FROM book WHERE isbn='"+isbn.getText()+"';");
						JOptionPane.showMessageDialog(null, "Successdully Removed!");
					conn.close();
					mystmnt.close();
					frame.dispose();}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Book doesn't exist.");	
				}
			}
			
		});
		add(done);
		setVisible(true);
		setSize(320,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
