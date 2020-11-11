package Requette;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Quest_3 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
    	Class.forName("oracle.jdbc.driver.OracleDriver");

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        Connection cnt = DriverManager.getConnection(url,"SYSTEM", "clement");
 
        PreparedStatement stt = cnt.prepareStatement("SELECT email from Chercheur");
        PreparedStatement stt2 = cnt.prepareStatement("SELECT * from Travailler where email=?");
       
        ResultSet res = stt.executeQuery();
        
        
        String titre = "";
        String labo = "";
        while(res.next()) {
        	 titre = res.getString("email");
        	 System.out.println(titre);
        	 stt2.setString(1, titre);
        	 ResultSet res2 = stt2.executeQuery();
        	 while(res2.next()) {
        		 
        		 labo = res2.getString("nomlabo");
        		 System.out.println(labo);
        	 }
        	 System.out.println("\n");
        }
     
        res.close();
    }
	
}
