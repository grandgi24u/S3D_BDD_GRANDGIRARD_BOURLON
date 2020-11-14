package Requette;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connexion {
	
	private Connection c;
	private String nom = "SYSTEM";
	private String mdp = "clement";
	
	public Connexion() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        
        this.c = DriverManager.getConnection(url, this.nom, this.mdp);
	}
	
	public ResultSet prepareStat(String n) throws ClassNotFoundException, SQLException {	
        PreparedStatement stt2 = this.c.prepareStatement(n);
        return stt2.executeQuery();
	}
	
	public ResultSet prepareStatWith1(String n, String b) throws ClassNotFoundException, SQLException {
        PreparedStatement stt2 = this.c.prepareStatement(n);
        stt2.setString(1, b);
        return stt2.executeQuery();
	}
	
	public Connection getC() {
		return this.c;
	}

}
