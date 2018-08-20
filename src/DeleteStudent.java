import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DeleteStudent extends JFrame{
	static JFrame frame;
	private JLabel userLabel;
	private JTextField user;
	private JButton done;
	
	public static void main(){
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				try{
					frame=new DeleteStudent();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
		});
	}
public DeleteStudent(){
	super("Delete Student");
	setLayout(new FlowLayout());
	userLabel=new JLabel("Username:");
	add(userLabel);
	user =new JTextField(20);
	add(user);
	done=new JButton("Done");
	done.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent arg0) {
			try {
				Connection conn =db.getConnection();
				Statement mystmnt= conn.createStatement();
				int i= mystmnt.executeUpdate("DELETE FROM student WHERE user='"+user.getText()+"';");
				JOptionPane.showMessageDialog(null, "Successdully Deleted!");
				conn.close();
				mystmnt.close();
				frame.dispose();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Sorry the student doesn't exist!");
			}
			
		}
		
	});
	add(done);
	setVisible(true);
	setSize(320,250);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
