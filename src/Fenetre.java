import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

public class Fenetre {

	private JTextField BarreDeRecherche;
	
	public Fenetre() {
		
		//JPanel nord
		JButton menu = new JButton("Menu");
		String explication = "Ceci est l'explication de l'utilité de la recherche";
		JPanel panNord = new JPanel();
		panNord.add(menu);
		panNord.add(new JLabel(explication));
		
		//JPanel sud
		JButton chercher = new JButton("Chercher");
		BarreDeRecherche = new JTextField();
		BarreDeRecherche.setPreferredSize(new Dimension(270, 30));
//		JPanel panSud= new JPanel(new GridLayout(1,2));
		JPanel panSud= new JPanel();
		panSud.add(BarreDeRecherche);
		panSud.add(chercher);
		
		//JPanel centre
		
		
		//Construction de l'interface graphique
		JFrame f = new JFrame();
		f.getContentPane().add(panNord, BorderLayout.NORTH);
//		f.getContentPane().add(panCentre, BorderLayout.CENTER);
		f.getContentPane().add(panSud, BorderLayout.SOUTH);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(new Dimension(400,400));
		f.setVisible(true);	

	}
	
	public static void main (String[] args) {
		new Fenetre();
	}

}
