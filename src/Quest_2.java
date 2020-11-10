import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Quest_2 {

	 public static void main(String[] args) throws SQLException, ClassNotFoundException {
	    	Class.forName("oracle.jdbc.driver.OracleDriver");

	        String url = "jdbc:oracle:thin:@localhost:1521:xe";
	        Connection cnt = DriverManager.getConnection(url,"SYSTEM", "clement");
	        
	        Scanner s = new Scanner(System.in);
	        
	        String n = s.nextLine();
	 
	        PreparedStatement stt = cnt.prepareStatement("SELECT Titre FROM Ecrire where Email=?");
	        PreparedStatement stt2 = cnt.prepareStatement("SELECT Email FROM Ecrire where Titre=? and Email!=?");
	       
	        stt.setString(1,n);
	        
	        ResultSet res = stt.executeQuery();
	       
	        String co = "";
	        stt2.setString(2,n);
	        
	        while(res.next()) {
	        	 stt2.setString(1,res.getString("Titre"));
	        	
	        	 ResultSet res2 = stt2.executeQuery();
	        	 while(res2.next()) {
	        		 co = res2.getString("Email");
	        		 System.out.println(co);
	        	 }
	        }
	     
	        res.close();
	    }
	
}
