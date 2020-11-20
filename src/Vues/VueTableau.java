package Vues;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import MVC_Autres.Modele;
import MVC_Autres.Observateur;
import MVC_Autres.Sujet;

/**
 * The Class VueTableau.
 */
public class VueTableau extends JTable implements Observateur {

	/**
	 * Instantiates a new vue tableau.
	 */
	public VueTableau() {
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
		
		//affichage des resultats de requetes
		if(m.getQuestionCourante() == 7) {}else if(m.getQuestionCourante() != 5) {
			if(m.getResultatRequete().length > 0) {
				
				String[] header = new String[m.getTailleHeader()];
				Object[][] data = new Object[m.getResultatRequete().length][m.getTailleHeader()];
		
				//creation du header en fonction de la question courante
				for(int x = 0; x < m.getTailleHeader(); x++) {
					header[x] = m.getValeurHeader(x);
				}
				
				//creation des valeurs du tableau en fonction de la requete
				for(int i = 0; i < m.getResultatRequete().length; i++) {
					for(int j = 0; j < m.getTailleHeader(); j++) {
	 					data[i][j] = m.getResultatRequete()[i][j];
					}
				}
				
				DefaultTableModel newModel = new DefaultTableModel(data, header);
				this.setModel(newModel);
				this.repaint();
			} else {
				JOptionPane.showMessageDialog(this,"Pas de résultat pour cette requette",
						"Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}

}
