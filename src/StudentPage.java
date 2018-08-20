import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
	public class StudentPage extends JFrame{
		static JFrame frame;
		private JButton viewissuedbooks,viewavailablebooks,changepassword,logout;
			
		public static void main(int id) {
			EventQueue.invokeLater(new Runnable(){
				public void run(){
					try{
						frame=new StudentPage(id);
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			});
			}
			private StudentPage(int id){
				super("Student Page");
				setLayout(new FlowLayout());
				viewissuedbooks=new JButton("View Issued Books");
				viewissuedbooks.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e) {
						issuedBookTable.main(id);	
					}
					
				});
				add(viewissuedbooks);
				viewavailablebooks=new JButton("View Available Books");
				viewavailablebooks.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e) {
						availableBooks.main();
					}
					
				});
				add(viewavailablebooks);
				changepassword=new JButton("Change Password");
				changepassword.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent arg0) {
						changePassword.main(id);
						
					}
					
				});
				add(changepassword);
				logout=new JButton("Logout");
				logout.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e) {
						String[] a=null;
						mainwindow.main(a);
						frame.dispose();
					}
					
				});
				add(logout);
				setVisible(true);
				setSize(300,150);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
}
