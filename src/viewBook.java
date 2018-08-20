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

public class viewBook extends JFrame{
	static JFrame frame;
	private JButton done;
	private DefaultTableModel model;
	private JTable table;
	
	
	public static void main(){
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				try{
					frame=new viewBook();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
		});
	}
private viewBook(){
	super("Book");
	model=new DefaultTableModel();
	table=new JTable(model);
	model.addColumn("ISBN");
	model.addColumn("Title");
	model.addColumn("Author");
	model.addColumn("Price");
	model.addColumn("Added Date");
	model.addColumn("Issued");
	model.addColumn("Student ID");
	String a;
	 try {
		Connection conn=db.getConnection();
		Statement stmnt=conn.createStatement();
		ResultSet rs=stmnt.executeQuery("SELECT * FROM book;");
		int i=0;
		while(rs.next()){
			a="Yes";
			if(Integer.parseInt(rs.getString("issued"))==0){
				a="No";
			}
			model.insertRow(i,new Object[] {rs.getString("isbn"),rs.getString("title"),rs.getString("author"),
					rs.getString("price"),rs.getString("added_date"),a,rs.getString("ids")});
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