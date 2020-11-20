package Vues;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;

import MVC_Autres.Modele;
import MVC_Autres.Observateur;
import MVC_Autres.Sujet;

/**
 * The Class VueTextNord.
 */
public class VueTextNord extends JLabel implements Observateur {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new vue text nord.
	 */
	public VueTextNord() {
		super("<html>Détermination de la liste des articles écrits par un auteur donné</html>");
		this.setForeground(Color.orange);
		this.setPreferredSize(new Dimension(500, 30));
	}

	/**
	 * Actualiser.
	 *
	 * @param s the s
	 */
	@Override
	public void actualiser(Sujet s) {
		Modele m = (Modele)s;
		this.setText("<html>" + m.getExplication() + "</html>");	
	}
}
