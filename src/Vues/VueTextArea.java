package Vues;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import MVC_Autres.Modele;
import MVC_Autres.Observateur;
import MVC_Autres.Sujet;

/**
 * The Class VueTextArea.
 */
public class VueTextArea extends JTextArea implements Observateur {

	/**
	 * Instantiates a new vue text area.
	 */
	public VueTextArea() {
		super();
	}
	
	/**
	 * Actualiser.
	 *
	 * @param s the s
	 */
	@Override
	public void actualiser(Sujet s) {
		Modele m = (Modele)s;
		
		if(m.getQuestionCourante() == 5) {
			this.setText(m.getResultatRequete()[0][0]);
		}
	}

}
