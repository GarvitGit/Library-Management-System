import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.mysql.jdbc.Statement;

public class viewIssuedBooks extends JFrame{
	static JFrame frame;
	private JButton done;
	private JLabel idlabel;
	private JTextField id;
	
	public static void main(){
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				try{
					frame=new viewIssuedBooks();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
		});
	}
	
	private viewIssuedBooks(){
		super("Issued Books");
		setLayout(new FlowLayout());
		idlabel=new JLabel("ID:");
		add(idlabel);
		id=new JTextField(20);
		add(id);
		done=new JButton("Done");
		done.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				issuedBookTable.main(Integer.parseInt(id.getText()));
				frame.dispose();
			}
			
		});
		add(done);
		setVisible(true);
		setSize(300,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
