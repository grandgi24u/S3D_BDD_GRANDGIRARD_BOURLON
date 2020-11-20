package Controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import MVC_Autres.Modele;

/**
 * La classe de controle pour la question 8
 */
public class ControlerQuest8 implements ActionListener {

	/** Le modele */
	private Modele model;
	
	/** Boolean d'etat du trigger 1 */
	private Boolean c1 = false;
	
	/** Boolean d'etat du trigger 2 */
	private Boolean c2 = false;

	/**
	 * Constructeur du controleur
	 *
	 * @param m le modele
	 */
	public ControlerQuest8(Modele m) {
		this.model=m;
	}
	
	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//creation du trigger numero un
		if(e.getActionCommand().equals("Creer 1")) {			
			try {
				model.lancerQuest8(0,0);
				if(!c1) {
					JOptionPane.showMessageDialog(model.getVC(),"Trigger 1 creer",
							"Error",JOptionPane.INFORMATION_MESSAGE);
					c1 = true;
				}else {
					JOptionPane.showMessageDialog(model.getVC(),"Trigger deja existant",
							"Error",JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}	
		
		//suppression du trigger numero un
		if(e.getActionCommand().equals("Supprimer 1")) {
			try {
				model.lancerQuest8(0,1);
				if(c1) {
					JOptionPane.showMessageDialog(model.getVC(),"Trigger 1 supprimer",
							"Error",JOptionPane.INFORMATION_MESSAGE);
					c1 = false;
				}else {
					JOptionPane.showMessageDialog(model.getVC(),"Trigger n'existe pas",
							"Error",JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		//creation du trigger numero deux
		if(e.getActionCommand().equals("Creer 2")) {
			try {
				model.lancerQuest8(1,0);
				if(!c2) {
					JOptionPane.showMessageDialog(model.getVC(),"Trigger 2 creer",
							"Error",JOptionPane.INFORMATION_MESSAGE);
					c2 = true;
				}else {
					JOptionPane.showMessageDialog(model.getVC(),"Trigger deja existant",
							"Error",JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		//suppression du trigger numero deux
		if(e.getActionCommand().equals("Supprimer 2")) {
			try {
				model.lancerQuest8(1,1);
				if(c2) {
					JOptionPane.showMessageDialog(model.getVC(),"Trigger 2 supprimer",
							"Error",JOptionPane.INFORMATION_MESSAGE);
					c2 = false;
				}else {
					JOptionPane.showMessageDialog(model.getVC(),"Trigger n'existe pas",
							"Error",JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}	
	}
}
