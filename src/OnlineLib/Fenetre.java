package OnlineLib;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Fenetre {

	private JTextField BarreDeRecherche;
	
	public Fenetre() {
		
		//Selection de la recherche a effectuer (6 sont possibles)
		Function_Content fc = new Function_Content(1);
		
		//JPanel nord
		JButton menu = new JButton("Menu");
		String explication = fc.getTitre();
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
		f.getContentPane().add(scrollpane, BorderLayout.CENTER);
		f.getContentPane().add(panSud, BorderLayout.SOUTH);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(new Dimension(400,400));
		f.setVisible(true);	

	}
	
	public static void main (String[] args) {
		new Fenetre();
	}

}
