package Requette;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connexion {
	
	private ResultSet res;
	
	public Connexion(String n, String b) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        
        Connection cnt = DriverManager.getConnection(url,"SYSTEM", "clement");
        PreparedStatement stt2 = cnt.prepareStatement(n);
        
        stt2.setString(1, b);
        this.res = stt2.executeQuery();
	}

	public ResultSet getRes() {
		return this.res;
	}

}
