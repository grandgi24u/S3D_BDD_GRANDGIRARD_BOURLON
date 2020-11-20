package Controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JComboBox;

import MVC_Autres.Modele;

/**
 * La classe de controle du menu
 */
public class ControlerMenu implements ActionListener {

	/** Le modele */
	private Modele model;

	/**
	 * Constructeur du controleur
	 *
	 * @param m le modele
	 */
	public ControlerMenu(Modele m) {
		this.model=m;
	}
	
	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox j = (JComboBox) e.getSource();
		try {
			model.setTitre(j.getSelectedIndex());
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	}

}
