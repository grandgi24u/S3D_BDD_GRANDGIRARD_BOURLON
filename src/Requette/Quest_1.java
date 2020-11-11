package Requette;
import java.sql.*;
import java.util.Scanner;

public class Quest_1 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
    	Class.forName("oracle.jdbc.driver.OracleDriver");

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        Connection cnt = DriverManager.getConnection(url,"SYSTEM", "clement");
        
        Scanner s = new Scanner(System.in);
        
        String n = s.nextLine();
 
        PreparedStatement stt2 = cnt.prepareStatement("SELECT titre, email FROM Ecrire where email=?");
        stt2.setString(1, n);
        ResultSet res2 = stt2.executeQuery();
        
        while(res2.next()) {
        	 String titre = res2.getString("titre");
             System.out.println(titre);
        }
     
        res2.close();
    }
}