package Requette;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Quest_2 {

	 public static void main(String[] args) throws SQLException, ClassNotFoundException {
	    	Connexion c = new Connexion();
	        
	        Scanner s = new Scanner(System.in);
	        String n = s.nextLine();
	 
	        PreparedStatement stt2 = c.getC().prepareStatement("SELECT Email FROM Ecrire where Titre=? and Email!=?");
	       
	        ResultSet r = c.prepareStatWith1("SELECT Titre FROM Ecrire where Email=?", n);
	        
	        String co = "";
	        stt2.setString(2,n);
	        
	        while(r.next()) {
	        	 stt2.setString(1,r.getString("Titre"));
	        	
	        	 ResultSet res2 = stt2.executeQuery();
	        	 while(res2.next()) {
	        		 co = res2.getString("Email");
	        		 System.out.println(co);
	        	 }
	        }
	        s.close();
	        r.close();
	    }
	
}
