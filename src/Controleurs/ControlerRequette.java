package Controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JTextField;

import MVC_Autres.Modele;

/**
 * La classe de controle des requettes
 */
public class ControlerRequette implements ActionListener {

	/** Le modele */
	private Modele model;

	/**
	 * Constructeur du controleur
	 *
	 * @param m le modele
	 */
	public ControlerRequette(Modele m) {
		this.model=m;
	}
	
	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JTextField j = (JTextField) e.getSource();
		
		//On verifie si la question en cours n'est pas une question sans "requette"
		if(model.getQuestionCourante() == 7) {
			model.notifierObservateurs(3);
		//sinon on recupere le parametre et on lance la requette
		}else if(model.getQuestionCourante() != 2) {
			try {
				model.setParametre(j.getText());
				model.lancerRequete(j.getText());
				
				j.setText("");
			} catch (ClassNotFoundException | SQLException e1) {
				System.out.println(e1);
			}
		}
	}

}
