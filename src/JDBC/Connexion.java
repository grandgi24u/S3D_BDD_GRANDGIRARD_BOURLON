package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe de connexion
 */
public class Connexion {
	
	/** La connexion */
	private Connection c;
	
	/**
	 * Instantiates a new connexion.
	 *
	 * @param u the user
	 * @param m the password
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public Connexion(String u, String m) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@charlemagne.iutnc.univ-lorraine.fr:1521:infodb";
        this.c = DriverManager.getConnection(url, u, m);
	}
	
	/**
	 * Preparer une requete
	 *
	 * @param n la requete
	 * @return le resultat de la requete
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public ResultSet prepareStat(String n) throws ClassNotFoundException, SQLException {	
        PreparedStatement stt2 = this.c.prepareStatement(n);
        return stt2.executeQuery();
	}
	
	/**
	 * preparer une requete avec un parametre
	 *
	 * @param n la requete
	 * @param b le parametre 
	 * @return le resultat de la requete
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public ResultSet prepareStatWith1(String n, String b) throws ClassNotFoundException, SQLException {
        PreparedStatement stt2 = this.c.prepareStatement(n);
        stt2.setString(1, b);
        return stt2.executeQuery();
	}
	
	/**
	 * preparer une requete avec deux parametre
	 *
	 * @param n la requete
	 * @param a le parametre 1
	 * @param b le parametre 2
	 * @return le resultat de la requete
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public ResultSet prepareStatWith2(String n, String a, String b) throws ClassNotFoundException, SQLException {
        PreparedStatement stt2 = this.c.prepareStatement(n);
        stt2.setString(1, a);
        stt2.setString(2, b);
        return stt2.executeQuery();
	}
	
	/**
	 * Get la connexion
	 *
	 * @return la connection
	 */
	public Connection getC() {
		return this.c;
	}

}
