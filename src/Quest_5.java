import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Quest_5 {
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
    	Class.forName("oracle.jdbc.driver.OracleDriver");

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        Connection cnt = DriverManager.getConnection(url,"SYSTEM", "clement");
        
        Scanner s = new Scanner(System.in);
        
        String n = s.nextLine();
 
        PreparedStatement stt2 = cnt.prepareStatement("Select avg(Note) AS notem from Noter where Email = ?");
        stt2.setString(1, n);
        ResultSet res2 = stt2.executeQuery();
        
        while(res2.next()) {
        	 String titre = res2.getString("notem");
             System.out.println(titre);
        }
     
        res2.close();
    }
	
}
