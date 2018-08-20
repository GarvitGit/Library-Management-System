import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AdminPanel extends JFrame{

private JTextField username;
private JPasswordField password;
private JButton signin;
static JFrame frame;
private String a,b;
private JLabel user,pass;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AdminPanel();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private AdminPanel(){
		super("Admin Login");
		setLayout(new FlowLayout());
		user=new JLabel("Enter Username:");
		add(user);
		username=new JTextField(20);
		username.setToolTipText("Enter your username here.");
		add(username);
		pass=new JLabel("Enter Password:");
		add(pass);
		password=new JPasswordField(20);
		password.setToolTipText("Enter your password here.");
		add(password);
		signin=new JButton("Sign In");
		signin.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					b=String.valueOf(password.getPassword());
					a=username.getText();
					if(a.equals("garvit")&&b.equals("minocha")){
						try {
							AdminPage.main();
						} catch (Exception e1){
							e1.printStackTrace();
						}
						frame.dispose();
					}
					else{
						JOptionPane.showMessageDialog(null,"Wrong Password");
					}
					
				}
		});
		add(signin);
		setVisible(true);
		setSize(400,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
