package JDBC;
import java.sql.*;
import java.util.ArrayList;

/**
 * The Class Question.
 */
public class Question {

	/** La connection */
	private Connexion c;
	
	/** Le boolean du trigger 1 */
	private Boolean proc1 = false;
	
	/** Le boolean du trigger 2 */
	private Boolean proc2 = false;

	/**
	 * Instantiates a new question.
	 *
	 * @param u the u
	 * @param m the m
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public Question(String u, String m) throws ClassNotFoundException, SQLException  {
		this.c = new Connexion(u, m);
	}

	/**
	 * Effectuer requette.
	 *
	 * @param nbReq the nb req
	 * @param n the n
	 * @return the string[][]
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public String[][] effectuerRequette(int nbReq, String n) throws ClassNotFoundException, SQLException {
		switch (nbReq) {
		case 0 : return question1(n);
		case 1 : return question2(n);
		case 2 : return question3(n);
		case 3 : return question4(n);
		case 4 : return question5(n);
		case 5 : return question6(n);
		case 6 : return question7(n);
		default : return new String[0][0];
		}
	}

	/**
	 * Transformation.
	 *
	 * @param a the a
	 * @param n the n
	 * @return the string[][]
	 */
	public String[][] transformation(ArrayList<String[]> a, int n){
		String[][] res = new String[a.size()][n];

		for(int i = 0; i < a.size(); i++) {
			for(int j = 0; j < n; j++) {
				res[i][j] = a.get(i)[j];
			}
		}

		return res;
	}

	/**
	 * Question 1.
	 *
	 * @param n the n
	 * @return the string[][]
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public String[][] question1(String n) throws ClassNotFoundException, SQLException{
		ArrayList<String[]> s = new ArrayList<String[]>();
		String[] st;

		ResultSet r = this.c.prepareStatWith1("SELECT titre, resume, TypeArticle, email FROM Ecrire natural join article where email=?", n);

		while(r.next()) {
			st = new String[3];
			st[0] = r.getString("titre");
			st[1] = r.getString("resume");
			st[2] = r.getString("TypeArticle");
			s.add(st);
		}

		r.close();
		return transformation(s,3);
	}

	/**
	 * Question 2.
	 *
	 * @param n the n
	 * @return the string[][]
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public String[][] question2(String n) throws ClassNotFoundException, SQLException {
		ArrayList<String[]> s = new ArrayList<String[]>();
		String[] st;

		PreparedStatement s2 = this.c.getC().prepareStatement("SELECT Email, NomChercheur, PrenomChercheur FROM Ecrire natural join chercheur where Titre=? and Email!=?");
		ResultSet r = this.c.prepareStatWith1("SELECT Titre FROM Ecrire where Email=?", n);

		String co = "";
		s2.setString(2,n);

		while(r.next()) {
			s2.setString(1,r.getString("Titre"));

			ResultSet res2 = s2.executeQuery();
			while(res2.next()) {
				st = new String[3];
				st[0] = res2.getString("Email");
				st[1] = res2.getString("NomChercheur");
				st[2] = res2.getString("PrenomChercheur");
				s.add(st);
			}
		}
		r.close();
		return transformation(s,3);
	}

	/**
	 * Question 3.
	 *
	 * @param n the n
	 * @return the string[][]
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public String[][] question3(String n) throws ClassNotFoundException, SQLException {
		ArrayList<String[]> s = new ArrayList<String[]>();

		ArrayList<String> s2 = new ArrayList<String>();
		String[] st;
		int i = 0;

		ResultSet r = this.c.prepareStat("SELECT email from Chercheur");

		String titre = "";

		while(r.next()) {

			titre = r.getString("email");

			ResultSet r2 = this.c.prepareStatWith1("SELECT * from Travailler where email=?",titre);

			s2 = new ArrayList<String>();

			while(r2.next()) {
				s2.add(r2.getString("nomlabo"));
			} 

			for(int z = 0; z < s2.size(); z++) {
				st = new String[2];
				if(i == 0) {
					st[0] = titre;  
				}else {
					st[0] = "|->";
				}
				st[1] = s2.get(z); 
				i++;
				s.add(st);
			}

			i = 0;
		}

		r.close();
		return transformation(s,2);
	}

	/**
	 * Question 4.
	 *
	 * @param n the n
	 * @return the string[][]
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public String[][] question4(String n) throws ClassNotFoundException, SQLException{
		ArrayList<String[]> s = new ArrayList<String[]>();
		String[] st;

		ResultSet r = this.c.prepareStatWith1("SELECT Email, COUNT(Titre) FROM Annoter HAVING COUNT(Titre) >= ? GROUP BY Email", n);

		while(r.next()) {
			st = new String[1];
			st[0] = r.getString("Email");
			s.add(st);
		}

		r.close();
		return transformation(s,1);
	}

	/**
	 * Question 5.
	 *
	 * @param n the n
	 * @return the string[][]
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public String[][] question5(String n) throws ClassNotFoundException, SQLException{
		ArrayList<String[]> s = new ArrayList<String[]>();
		String[] st;

		ResultSet r = this.c.prepareStatWith1("Select avg(Note) AS notem from Noter where Email = ?", n);

		while(r.next()) {
			st = new String[1];
			st[0] = r.getString("notem");
			s.add(st);
		}

		r.close();
		return transformation(s,1);
	}

	/**
	 * Question 6.
	 *
	 * @param n the n
	 * @return the string[][]
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public String[][] question6(String n) throws ClassNotFoundException, SQLException{
		ArrayList<String[]> s = new ArrayList<String[]>();

		String nomlab = n;

		String[] r2 = new String[1];

		ResultSet res1 = this.c.prepareStatWith1("select email from travailler where nomLabo = ?",n);
		String r = "";

		while (res1.next()) {

			String email = res1.getString("email");
			ResultSet res2 = this.c.prepareStatWith1("select count(titre) from ecrire where email = ?",email);

			while (res2.next()) {

				r += "Chercheur : " + email + " \nnombre de publications :\n\t\t" + res2.getString(1) + " article(s) :" + "\n";
				ResultSet res3 = this.c.prepareStatWith1("select titre from Ecrire where email = ? group by titre",email);

				while (res3.next()) {

					r += "\t\t\tTitre : " + res3.getString("titre") + "\n";
					String titre = res3.getString("titre");
					ResultSet res4 = this.c.prepareStatWith1("select avg(note), count(note) from noter where titre =?",titre);

					while (res4.next()) {

						r += "\t\t\t\tnombre de notes : " + res4.getInt(2) + "\n";
						if(res4.getInt(2)!=0) {
							r += "\t\t\t\tmoyenne : " + res4.getDouble(1) + "\n";
						}
					}
					res4.close();
				}
				res3.close();
			}
			res2.close();

		}
		res1.close();
		r2[0] = r;
		s.add(r2);

		return transformation(s,1);
	}

	/**
	 * Question 7.
	 *
	 * @param n the n
	 * @return the string[][]
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public String[][] question7(String n) throws ClassNotFoundException, SQLException {
		ArrayList<String[]> s = new ArrayList<String[]>();
		String[] r2 = new String[1];

		ResultSet rs = this.c.prepareStatWith2("Select Email from NOTER where titre = ? AND note = (SELECT max(note) from NOTER where titre = ?)", n, n);
		rs.next();
		while(rs.next()) {
			String emailNoteMax = rs.getString(1);

			ResultSet rs2 = this.c.prepareStatWith1("Select email from ECRIRE where titre = ?", n);
			while(rs2.next()) {
				String auteur = rs2.getString(1);

				ResultSet rs3 = this.c.prepareStatWith1("Select nomlabo from TRAVAILLER where email = ?", auteur);

				while(rs3.next()) {
					String labo = rs3.getString(1);
					ResultSet rs4 = this.c.prepareStatWith1("Select email from TRAVAILLER where nomlabo = ?", labo);

					while (rs4.next()) {
						r2 = new String[1];
						if(rs4.getString(1).equals(emailNoteMax)) {
							r2[0] = auteur;
						}
						s.add(r2);
					}
				}
			}
		}
		return transformation(s,1);
	}

	/**
	 * Question 8.
	 *
	 * @param a the a
	 * @param b the b
	 * @throws SQLException the SQL exception
	 */
	public void question8(int a, int b) throws SQLException{
		Statement st = this.c.getC().createStatement();
		if(a == 0) {
			if(b == 0) {
				if(!proc1) {
					st.execute("CREATE or REPLACE TRIGGER verifInsertNote BEFORE INSERT ON Noter\r\n" + 
							"    FOR EACH ROW\r\n" + 
							"    DECLARE\r\n" + 
							"        n number(2);\r\n" + 
							"    BEGIN\r\n" + 
							"        Select count(*) into n from Ecrire where Email =: new.Email AND\r\n" + 
							"                                                 Titre =: new.Titre;\r\n" + 
							"        if n > 0 then\r\n" + 
							"            RAISE_APPLICATION_ERROR(-20001, 'Erreur lors de l insertion');\r\n" + 
							"        end if;\r\n" + 
							"    end;");
					proc1 = true;
				}
			}else if(proc1){
				st.execute("DROP TRIGGER verifInsertNote");
				proc1 = false;
			}
		} else {
			if(b == 0 && !proc2) {
				if(!proc2) {
					st.execute("CREATE or REPLACE TRIGGER logChercheur AFTER INSERT OR UPDATE ON Annoter\r\n" + 
							"    For each row\r\n" + 
							"    BEGIN\r\n" + 
							"        if Inserting then\r\n" + 
							"            Insert into log_chercheur values(sys_context('USERENV','SESSION_USER'), sysdate, 'Insert');\r\n" + 
							"        else\r\n" + 
							"            Insert into log_chercheur values(sys_context('USERENV','SESSION_USER'), sysdate, 'Update');\r\n" + 
							"        end if;\r\n" + 
							"    end;");
					proc2 = true;
				}
			}else if(proc2){
				st.execute("DROP TRIGGER logChercheur");
				proc2 = false;
			}
		}
	}

}