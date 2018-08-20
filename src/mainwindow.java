import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;
public class mainwindow extends JFrame{
	static mainwindow frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new mainwindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	private mainwindow(){
		super("Library System");
		setLayout(new FlowLayout());
		JButton adminlogin=new JButton("Admin Login");
		JButton studentlogin=new JButton("Student Login");
		adminlogin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				AdminPanel.main(new String[]{});
				frame.dispose();
			}
		});
		add(adminlogin);
		studentlogin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				StudentPanel.main();
				frame.dispose();
			}
		});
		add(studentlogin);
		setVisible(true);
		setSize(400,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
