package Requette;
import java.sql.*;
import java.util.Scanner;

public class Question145 {

	private String[][] tabT1 = {{"SELECT titre, email FROM Ecrire where email=?", "titre"},
			{"SELECT Email, COUNT(Titre) FROM Annoter HAVING COUNT(Titre) >= ? GROUP BY Email", "Email"},
			{"Select avg(Note) AS notem from Noter where Email = ?", "notem"}};
	private Scanner s;

	public Question145(int nbReq) throws ClassNotFoundException, SQLException {
		Connexion c = new Connexion(this.getTabT1()[nbReq][0], this.createScanner());

		while(c.getRes().next()) {
			System.out.println(c.getRes().getString(this.getTabT1()[nbReq][1]));
		}

		c.getRes().close();
	}

	public String createScanner() {
		this.s = new Scanner(System.in);
		return s.nextLine();
	}

	public String[][] getTabT1() {
		return this.tabT1;
	}
	
}