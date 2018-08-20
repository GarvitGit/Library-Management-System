import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class availableBooks extends JFrame{
	private JButton done;
	private DefaultTableModel model;
	private JTable table;
	static JFrame frame;
	
	public static void main() {
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try{
					frame=new availableBooks();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		}
	private availableBooks(){
		super("Available Books");
		model=new DefaultTableModel();
		table=new JTable(model);
		model.addColumn("ISBN");
		model.addColumn("Title");
		model.addColumn("Author");
		model.addColumn("Price");
		model.addColumn("Added Date");
		 try {
			Connection conn=db.getConnection();
			Statement stmnt=conn.createStatement();
			ResultSet rs=stmnt.executeQuery("SELECT * FROM book where issued='0';");
			int i=0;
			while(rs.next()){
				model.insertRow(i,new Object[] {rs.getString("isbn"),rs.getString("title"),rs.getString("author"),
						rs.getString("price"),rs.getString("added_date")});
				i++;
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
	}
}
