package Vues;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import MVC_Autres.Modele;
import MVC_Autres.Observateur;
import MVC_Autres.Sujet;

/**
 * The Class VueParamRequette.
 */
public class VueParamRequette extends JLabel implements Observateur {

	/**
	 * Instantiates a new vue param requette.
	 */
	public VueParamRequette() {
		super("Recherche pour :");
		setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	/**
	 * Actualiser.
	 *
	 * @param s the s
	 */
	@Override
	public void actualiser(Sujet s) {
		Modele m = (Modele)s;
		if(m.getQuestionCourante() != 7 && m.getResultatRequete().length > 0) {
			this.setText("<html>" + m.getParametre() + "</html>");
		}
	}
	
}
