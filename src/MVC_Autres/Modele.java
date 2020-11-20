package MVC_Autres;

import java.sql.SQLException;
import java.util.ArrayList;

import JDBC.Question;
import Vues.VueCentre;

/**
 * Le modele de l'interface
 */
public class Modele implements Sujet {

	/** The observateurs. */
	private ArrayList<Observateur> observateurs;
	
	/** The explication. */
	//attributs pour les textes en haut de la fenetre
	private String[] explication = {"Détermination de la liste des articles écrits par un auteur donné", "Affichage de la liste des co-auteurs ayant travaillé avec un chercheur",
			"Affichage de la liste des laboratoires de chaque chercheur", "Affichage la liste des chercheurs ayant annoté au moins un nombre donné d'articles",
			"Calcul de la moyenne des notes données par un chercheur donné ", "Pour chaque chercheur d'un laboratoire donné, afficher le nombre d'articles publiés, le nombre et la moyenne des notes obtenues",
			"Verification que la note maximale d'un article donné n'a pas ete attribuee par un chercheur du meme laboratoire", "Creation / Destruction de trigger"};
	
	/** The header tab. */
	private String[][] headerTab = {{"Titre","Resume","Type"},{"Email", "Nom", "Prenom"},{"Email","Labo"},
			{"Email"}, {"Moyenne note"}, {""},{"Email"},{""}};
	
	/** The question courante. */
	//attributs de la question afficher
	private int questionCourante = 0;
	
	/** The parametre. */
	//attributs pour les parametres sql
	private String parametre;
	
	/** The q. */
	//attributs pour les requetes sql
	private Question q;
	
	/** The resultat requete. */
	private String[][] resultatRequete;
	
	/** The vc. */
	private VueCentre vc;
	
	
	/**
	 * Constructeur du modele
	 *
	 * @param u l'user
	 * @param m le mot de passe
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public Modele(String u, String m) throws ClassNotFoundException, SQLException {
		this.observateurs = new ArrayList<Observateur> ();
		this.q = new Question(u, m);
		this.resultatRequete = new String[0][0];
	}
	
	
	//Méthodes implemente par sujet
	/**
	 * Enregistrer observateur.
	 *
	 * @param o the o
	 */
	@Override
	public void enregistrerObservateur(Observateur o) {
		this.observateurs.add(o);
	}

	/**
	 * Supprimer observateur.
	 *
	 * @param o the o
	 */
	@Override
	public void supprimerObservateur(Observateur o) {
		int i = this.observateurs.indexOf(o);
		if (i >= 0) {
			this.observateurs.remove(i);
		}
	}

	/**
	 * Notifier observateurs.
	 *
	 * @param a the a
	 */
	@Override
	public void notifierObservateurs(int a) {
		Observateur observer = this.observateurs.get(a);
		observer.actualiser(this);
	}
	
	
	//methodes pour le panel nord
	/**
	 * Sets the titre.
	 *
	 * @param a the new titre
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public void setTitre(int a) throws ClassNotFoundException, SQLException {
		this.questionCourante = a;
		if(this.questionCourante == 2) {
			this.lancerRequete(null);
		}if(this.questionCourante == 7) {
			this.lancerRequete(null);
		}
		this.notifierObservateurs(0);
	}
	
	/**
	 * Gets the taille header.
	 *
	 * @return the taille header
	 */
	public int getTailleHeader() {
		return this.headerTab[this.questionCourante].length;
	}
	
	/**
	 * Gets the valeur header.
	 *
	 * @param a the a
	 * @return the valeur header
	 */
	public String getValeurHeader(int a) {
		return this.headerTab[this.questionCourante][a];
	}
	
	/**
	 * Gets the explication.
	 *
	 * @return the explication
	 */
	public String getExplication() {
		return this.explication[this.questionCourante];
	}
	
	/**
	 * Gets the question courante.
	 *
	 * @return the question courante
	 */
	public int getQuestionCourante() {
		return this.questionCourante;
	}
	
	
	//methode pour l'affichage du parametre
	/**
	 * Sets the parametre.
	 *
	 * @param n the new parametre
	 */
	public void setParametre(String n) {
		this.parametre = "Recherche pour : " + n;
	}
	
	/**
	 * Gets the parametre.
	 *
	 * @return the parametre
	 */
	public String getParametre() {
		return this.parametre;
	}
	
	
	//methode pour le tableau
	/**
	 * Lancer requete.
	 *
	 * @param n the n
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public void lancerRequete(String n) throws ClassNotFoundException, SQLException {
		this.resultatRequete = this.q.effectuerRequette(this.questionCourante, n);
		for(int i = 1; i < 5; i++) {
			this.notifierObservateurs(i);
		}
	}
	
	/**
	 * Gets the resultat requete.
	 *
	 * @return the resultat requete
	 */
	public String[][] getResultatRequete(){
		return this.resultatRequete;
	}
	
	
	//methode question 8
	/**
	 * Lancer quest 8.
	 *
	 * @param a the a
	 * @param b the b
	 * @throws SQLException the SQL exception
	 */
	public void lancerQuest8(int a, int b) throws SQLException {
		this.q.question8(a, b);
	}
	
	/**
	 * Sets the vc.
	 *
	 * @param v the new vc
	 */
	public void setVC(VueCentre v) {
		this.vc = v;
	}
	
	/**
	 * Gets the vc.
	 *
	 * @return the vc
	 */
	public VueCentre getVC() {
		return this.vc;
	}
	
	
}
