import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPage extends JFrame{
	static JFrame frame;
	private JButton addstudent,removestudent,issuebook,unissuebook,addbook,removebook,viewstudent,viewbooks,viewissuedbooks,logout;
	
	public static void main(){
	EventQueue.invokeLater(new Runnable(){
		public void run(){
			try{
				frame= new AdminPage();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	});
}
	private AdminPage(){
		super("Admin Page");
		setLayout(new FlowLayout());
		addstudent=new JButton("Add Student");
		addstudent.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				addStudent.main();
			}
			
		}
				
		);
		add(addstudent);
		removestudent=new JButton("Remove Student");
		removestudent.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				DeleteStudent.main();
			}
			
		});
		add(removestudent);
		issuebook=new JButton("Issue Book");
		issuebook.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				issueBook.main();
			}
			
		});
		add(issuebook);
		unissuebook=new JButton("Unissue Book");
		unissuebook.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				unissueBook.main();
			}
			
		});
		add(unissuebook);
		addbook=new JButton("Add Book");
		addbook.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				AddBook.main();
			}
			
		});
		add(addbook);
		removebook=new JButton("Remove Book");
		removebook.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				RemoveBook.main();
			}
			
		});

		add(removebook);
		viewstudent=new JButton("View Student");
		viewstudent.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				viewStudent.main();
			}
			
		});
		add(viewstudent);
		viewbooks=new JButton("View Book");
		viewbooks.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent arg0) {
				viewBook.main();
				
			}});
		add(viewbooks);
		viewissuedbooks=new JButton("View Issued Books");
		viewissuedbooks.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				viewIssuedBooks.main();
				
			}});
		add(viewissuedbooks);
		logout=new JButton("Logout");
		logout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String[] a = null;
				mainwindow.main(a);
				frame.dispose();
			}
			
		});
		add(logout);
		setVisible(true);
		setSize(320,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
