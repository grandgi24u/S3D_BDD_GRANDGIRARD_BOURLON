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
public class VueTextSud extends JLabel implements Observateur {


	/**
	 * Instantiates a new vue text nord.
	 */
	public VueTextSud() {
		super("<html>Entrer un email :</html>");
		this.setForeground(Color.orange);
	}

	/**
	 * Actualiser.
	 *
	 * @param s the s
	 */
	@Override
	public void actualiser(Sujet s) {
		Modele m = (Modele)s;
		this.setText("<html>" + m.getParamRequete() + "</html>");	
	}
}