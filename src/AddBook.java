import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddBook extends JFrame{
		static JFrame frame;
		private JLabel isbnLabel,titleLabel,authorLabel,priceLabel;
		private JTextField isbn,title,author,price;
		private JButton done;
		
		public static void main(){
			EventQueue.invokeLater(new Runnable(){
				public void run() {
					try{
						frame=new AddBook();
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				
			});
		}
private AddBook(){
	super("Add Book");
	setLayout(new FlowLayout());
	isbnLabel=new JLabel("ISBN:");
	titleLabel=new JLabel("Title:");
	authorLabel=new JLabel("Author:");
	priceLabel=new JLabel("Price:");
	isbn=new JTextField(20);
	add(isbnLabel);
	add(isbn);
	title=new JTextField(20);
	add(titleLabel);
	add(title);
	author=new JTextField(20);
	add(authorLabel);
	add(author);
	price=new JTextField(20);
	add(priceLabel);
	add(price);
	done=new JButton("Done");
	done.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			try {
				Connection conn =db.getConnection();
				Statement stmnt=conn.createStatement();
				Statement mystmnt= conn.createStatement();
				ResultSet rs=stmnt.executeQuery("select * from book where isbn='"+isbn.getText()+"';");
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				if(rs.next()){
					JOptionPane.showMessageDialog(null,"Book Already Exist!");
				}else{
				int i= mystmnt.executeUpdate("INSERT INTO book(isbn,title,author,price,issued,added_date) VALUES('"+ Integer.parseInt(isbn.getText())
					+"','"+title.getText()+"','"+author.getText()+"','"+Float.parseFloat(price.getText())+"','0','"+dtf.format(now)+"');");
				JOptionPane.showMessageDialog(null, "Successfully added!");
				conn.close();
				mystmnt.close();
				frame.dispose();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	});
add(done);
setVisible(true);
setSize(300,250);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}