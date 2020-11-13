package OnlineLib;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * Classe principale permettant de créer la fenetre ainsi que son interface graphique 
 * afin de la remplir grace a d'autres classes externes
 * @author bourl
 */
public class Principale {

	//Champ permettant de remplir la chaine de caractere necessaire a la recherche
	private static JTextField BarreDeRecherche;
	
	public Principale() {
		
		/**
		 * Selection de la recherche a effectuer (6 sont possibles)
		 *
		 *   1 => Détermination de la liste des articles écrits par un auteur donné.
		 *   2 => Affichage de la liste des co-auteurs ayant travaillé avec un 
		 *        chercheur donné.
		 *   3 => Affichage de la liste des laboratoires de chaque chercheur.
		 *   4 => Affichage la liste des chercheurs ayant annoté au moins un nombre 
		 *        donné d'articles.
		 *   5 => Calcul de la moyenne des notes données par un chercheur donné.
		 *   6 => Pour chaque chercheur d'un laboratoire donné, afficher le nombre 
		 *        d'articles publiés, le nombre et la moyenne des notes obtenues. 
		 *        On classera les chercheurs par ordre décroissant du nombre d'articles 
		 *        publiés
		 * 
		 * CHOIX DELA RECHERCHE :
		 */
		int recherche = 1;
		Function_Content fc = new Function_Content(recherche);
		
		//JPanel nord
		JButton menu = new JButton("Menu");
		JPanel panNord = new JPanel();
	    panNord.setBackground(new Color(0, 64, 48));
		JLabel explication  = new JLabel(fc.getTitre());
		if (recherche==6)
			explication.setPreferredSize(new Dimension(300, 45));			
		menu.setForeground(Color.orange);
	    menu.setBackground(new Color(16, 120, 94));
	    explication.setForeground(Color.orange);
		explication.setPreferredSize(new Dimension(300, 30));
		panNord.add(explication);
		panNord.add(menu);
		
		//JPanel sud
		JPanel panSud= new JPanel();
		JButton chercher = new JButton("Chercher");
		BarreDeRecherche = new JTextField();
		BarreDeRecherche.setPreferredSize(new Dimension(270, 30));
	    panSud.setBackground(new Color(0, 64, 48));
		chercher.setForeground(Color.orange);
		chercher.setBackground(new Color(16, 120, 94));
	    BarreDeRecherche.setForeground(Color.orange);
		BarreDeRecherche.setBackground(new Color(16, 120, 94));
		panSud.add(BarreDeRecherche);
		panSud.add(chercher);
		
		//JPanel centre
		DefaultTableModel TableModel = new DefaultTableModel(fc.getListe(), fc.getIndex());
		JTable table = new JTable(TableModel);
		DefaultTableCellRenderer tableRenderer = new DefaultTableCellRenderer();
		tableRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, tableRenderer);
		
		JPanel panCentre = new JPanel(new BorderLayout());
		panCentre.setForeground(Color.blue);
		panCentre.setBackground(Color.green);
		panCentre.add(table, BorderLayout.CENTER);
		JScrollPane scrollpane = new JScrollPane(panCentre);
		
		//Construction de l'interface graphique
		JFrame f = new JFrame();
		f.getContentPane().add(panNord, BorderLayout.NORTH);
//		f.getContentPane().add(scrollpane, BorderLayout.CENTER);
		f.getContentPane().add(fc.getPanel(), BorderLayout.CENTER);
		f.getContentPane().add(panSud, BorderLayout.SOUTH);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(new Dimension(400,400));
		f.setVisible(true);	

	}
	
	public static JTextField getBarreDeRecherche() {
		return BarreDeRecherche;
	}
	
	public static void main (String[] args) {
		new Principale();
	}

}
