import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class db {
	public static Connection getConnection() throws Exception{
		Connection conn=null;
		try{
			   Class.forName("com.mysql.jdbc.Driver");
			   conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=false","Garvit","fuckyou@12345");
			   return conn;
			  } catch(Exception e){System.out.println(e);}
			  return conn;	
	}

}
