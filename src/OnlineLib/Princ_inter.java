package OnlineLib;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controleurs.ControlerMenu;
import Controleurs.ControlerQuest8;
import Controleurs.ControlerRequette;
import MVC_Autres.Modele;
import Vues.VueCentre;
import Vues.VueParamRequette;
import Vues.VueSud;
import Vues.VueTableau;
import Vues.VueTextArea;
import Vues.VueTextNord;
import Vues.VueTextSud;

/**
 * The Class Principale.
 */
public class Princ_inter {

	/**
	 * Instantiates a new principale.
	 *
	 * @param u l'user
	 * @param b le mot de passe
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public Princ_inter(String u, String b) throws ClassNotFoundException, SQLException {
		
		Modele m = new Modele(u, b);
		
		//JPanel nord
		JButton menu = new JButton("Menu");
		JPanel panNord = new JPanel();
		
		String[] items = {"Question 1", "Question 2", "Question 3", "Question 4", "Question 5", "Question 6", "Question 7", "Question 8"};
		JComboBox test = new JComboBox(items);		
		test.setForeground(Color.orange);
		test.setBackground(new Color(16, 120, 94));	
		ControlerMenu ch = new ControlerMenu(m);
		test.addActionListener(ch);	
		VueTextNord vtn = new VueTextNord();
		m.enregistrerObservateur(vtn);
		VueParamRequette vpr = new VueParamRequette();
		vpr.setForeground(Color.orange);
		menu.setForeground(Color.orange);
		menu.setBackground(new Color(16, 120, 94));
		panNord.setLayout(new BorderLayout());
		
		JPanel te = new JPanel();
		JPanel te2 = new JPanel();
		JPanel te3 = new JPanel();
		te.add(vtn);
		te.add(test);
		te2.add(vpr);
		te.setBackground(new Color(0, 64, 48));
		te.setForeground(Color.orange);
		te2.setBackground(new Color(0, 64, 48));
		panNord.add(te, BorderLayout.NORTH);
		panNord.add(te3, BorderLayout.CENTER);
		panNord.add(te2, BorderLayout.SOUTH);
		
		
		//JPanel sud	
		
		JTextField c = new JTextField();		
		ControlerRequette cr = new ControlerRequette(m);
		c.addActionListener(cr);
		
		VueTextSud vts = new VueTextSud();
		
		VueSud panSud = new VueSud(c,vts);
		
		c.setPreferredSize(new Dimension(270, 30));
		c.setForeground(Color.orange);
		c.setBackground(new Color(16, 120, 94));	


		
		//JPanel centre
		ControlerQuest8 cq = new ControlerQuest8(m);
		JButton acti = new JButton("Creer 1");
		JButton desac = new JButton("Supprimer 1");
		JButton acti2 = new JButton("Creer 2");
		JButton desac2 = new JButton("Supprimer 2");
		acti.addActionListener(cq);
		desac.addActionListener(cq);
		acti2.addActionListener(cq);
		desac2.addActionListener(cq);
		
		VueTableau vc = new VueTableau();
		VueTextArea va = new VueTextArea();
		VueCentre panCentre = new VueCentre(vc, va, acti, desac, acti2, desac2);
		m.enregistrerObservateur(vc);
		m.enregistrerObservateur(vpr);
		m.enregistrerObservateur(va);
		m.enregistrerObservateur(panCentre);
		m.enregistrerObservateur(panSud);
		m.enregistrerObservateur(vts);
		

		//Construction de l'interface graphique
		JFrame f = new JFrame();
		f.getContentPane().add(panNord, BorderLayout.NORTH);
		f.getContentPane().add(panCentre, BorderLayout.CENTER);
		f.getContentPane().add(panSud, BorderLayout.SOUTH);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(new Dimension(700,700));
		f.setLocationRelativeTo(null);
		f.setVisible(true);	

	}
}
