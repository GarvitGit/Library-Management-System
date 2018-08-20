import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;

public class viewStudent extends JFrame{
	static JFrame frame;
	private JButton done;
	private DefaultTableModel model;
	private JTable table;
	
	
	public static void main(){
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				try{
					frame=new viewStudent();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
		});
	}
private viewStudent(){
	super("Student");
	model=new DefaultTableModel();
	table=new JTable(model);
	model.addColumn("ID");
	model.addColumn("Name");
	model.addColumn("Class");
	model.addColumn("Total Books");
	model.addColumn("Username");
	model.addColumn("Password");
	 try {
		Connection conn=db.getConnection();
		Statement stmnt=conn.createStatement();
		ResultSet rs=stmnt.executeQuery("SELECT * FROM student;");
		int i=0;
		while(rs.next()){
			model.insertRow(i,new Object[] {rs.getString("id"),rs.getString("name"),rs.getString("class"),
					rs.getString("totalbooks"),rs.getString("user"),rs.getString("pass")});
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	 	add(new JScrollPane(table),BorderLayout.CENTER);
	 	done=new JButton("Done");
	 	done.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
	 		
	 	});
	 	add(done,BorderLayout.SOUTH);
		setVisible(true);
		setSize(700,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}}