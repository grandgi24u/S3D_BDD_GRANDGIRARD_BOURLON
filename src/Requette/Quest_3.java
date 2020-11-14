package Requette;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Quest_3 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connexion c = new Connexion();
       
        ResultSet r = c.prepareStat("SELECT email from Chercheur");
        
        String titre = "";
        String labo = "";
        
        while(r.next()) {
        	 titre = r.getString("email");
        	 System.out.println(titre);
        	 ResultSet r2 = c.prepareStatWith1("SELECT * from Travailler where email=?",titre);
        	 while(r2.next()) {
        		 
        		 labo = r2.getString("nomlabo");
        		 System.out.println(labo);
        	 }
        	 System.out.println("\n");
        }
     
        r.close();
    }
	
}
