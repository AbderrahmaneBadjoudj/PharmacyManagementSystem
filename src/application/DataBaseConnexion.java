package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseConnexion {
   private static final String USERNAME="root"; 
   private static final String PASSWORD="";
   private static final String HOST="127.0.0.1";
   private static final int PORT=3306;
   private static final String DB_NAME="login_db";
   public static Connection con;
   
   static {
	   try {
		con=DriverManager.getConnection("jdbc:mysql://"+HOST+":"+PORT+"/"+DB_NAME, USERNAME, PASSWORD);
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
   }
}
   
   /*public static int chekLogin (String username,String password) {
	   Connection con =DataBaseConnexion.con;
	   if(con==null) 
		   return -1;
	   String sql="SELECT * FROM users WHERE username=? AND password=?";
	   try {
		  PreparedStatement prest=con.prepareStatement(sql); 
		  prest.setString(1, username);
		  prest.setString(2, password);
		  
		  ResultSet rs=prest.executeQuery();
		  
		  
		  while(rs.next()) {
			  return 0;
		  }
		  
		  
		  return 1;
	   }
	   catch(SQLException se) {
		   se.printStackTrace();
	   }
	   
	
   } 
}
*/