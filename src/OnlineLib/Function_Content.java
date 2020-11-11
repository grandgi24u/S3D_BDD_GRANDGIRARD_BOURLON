package OnlineLib;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Function_Content {
	
	private int recherche;
	
	public Function_Content(int i) {
		if ( i>0 && i<7)
			recherche = i;
		else
			recherche = 1;
	}
	
	public String[][] getListe() {
		switch (recherche) {
			case (1) : return f1();
			case (2) : return f2();
			case (3) : return f3();
			case (4) : return f4();
			case (5) : return f5();
			default  : return f6();
		}
	}

	public JPanel getPanel() {
		String[][] list;
		switch (recherche) {
			case (1) : list = f1();
			case (2) : list = f2();
			case (3) : list = f3();
			case (4) : list = f4();
			case (5) : list = f5();
			default  : list = f6();
		}
		DefaultTableModel TableModel = new DefaultTableModel(list, this.getIndex());
		JTable table = new JTable(TableModel);
		DefaultTableCellRenderer tableRenderer = new DefaultTableCellRenderer();
		tableRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, tableRenderer);
		
		JPanel panCentre = new JPanel(new BorderLayout());
		panCentre.setForeground(Color.blue);
		panCentre.setBackground(Color.green);
		panCentre.add(table, BorderLayout.CENTER);
		JScrollPane scrollpane = new JScrollPane(panCentre);

		return panCentre;
	}

	public String[] getIndex() {
		switch (recherche) {
			case (1) : return new String[]{"Rank", "Country", "Forested Area(km sq)", "% of land area"};
			         //return new String[]{"Titre", "Resume", "TypeArticle"};
			case (2) : return new String[]{"Rank", "Country", "Forested Area(km sq)", "% of land area"};
       	             //return new String[]{"Email", "NomChercheur", "PrénomChercheur", "UrlChercheur"};
			case (3) : return new String[]{"Email", "NomChercheur", "PrénomChercheur", "UrlChercheur", "NomLaboratoire", "SigleLaboratoire", "AdresseLaboratoire", "UrlLaboratoire"};
			case (4) : return new String[]{"Email", "NomChercheur", "PrénomChercheur", "UrlChercheur"};
			case (5) : return new String[]{};
			default  : return new String[]{"Email", "NomChercheur", "PrénomChercheur", "UrlChercheur", "NbArticles", "NbNotes", "MoyNotes"};
		}
	}

	public String getTitre() {
		String titre;
		switch (recherche) {
			case (1) : titre = "Détermination de la liste des articles écrits par un auteur donné : "; break;
			case (2) : titre = "Affichage de la liste des co-auteurs ayant travaillé avec un chercheur : "; break;
			case (3) : titre = "Affichage de la liste des laboratoires de chaque chercheur : "; break;
			case (4) : titre = "Affichage la liste des chercheurs ayant annoté au moins un nombre donné d'articles : "; break;
			case (5) : titre = "Calcul de la moyenne des notes données par un chercheur donné : "; break;
			default  : titre = "Pour chaque chercheur d'un laboratoire donné, afficher le nombre d'articles publiés, le nombre et la moyenne des notes obtenues : "; break;
		}
		return "<html>"+titre+"</html>";
	}

	private String[][] f1() {
		return new String[][] {
			{"Rank", "Country", "Forested Area(km sq)", "% of land area"},
			{"1", "Russia", "8,149,300", "49.40%"},
			{"2", "Canada", "4.196,438", "49.24%"},
			{"3", "Brazil", "4,777,980", "56.10%"},
			{"4", "United States", "2,083,210", "33%"},
			{"5", "China", "2,083,210", "21.83"},
			{"6", "Congo", "1,819,326", "50%"},
			{"7", "Australia", "1,147,832", "19.90%"},
			{"8", "Argentina", "945,336", "34%"},
			{"9", "Indonesia", "884,950", "46.46%"},
			{"10", "India", "778,424", "24.68%"},
			{"1", "Russia", "8,149,300", "49.40%"},
			{"2", "Canada", "4.196,438", "49.24%"},
			{"3", "Brazil", "4,777,980", "56.10%"},
			{"4", "United States", "2,083,210", "33%"},
			{"5", "China", "2,083,210", "21.83"},
			{"6", "Congo", "1,819,326", "50%"},
			{"7", "Australia", "1,147,832", "19.90%"},
			{"8", "Argentina", "945,336", "34%"},
			{"9", "Indonesia", "884,950", "46.46%"},
			{"10", "India", "778,424", "24.68%"},
		};
	}

	private String[][] f2() {
		return new String[][] {
			{"1", "Russia", "8,149,300", "49.40%"},
			{"2", "Canada", "4.196,438", "49.24%"},
			{"3", "Brazil", "4,777,980", "56.10%"},
			{"4", "United States", "2,083,210", "33%"},
			{"5", "China", "2,083,210", "21.83"},
			{"6", "Congo", "1,819,326", "50%"},
			{"7", "Australia", "1,147,832", "19.90%"},
			{"8", "Argentina", "945,336", "34%"},
			{"9", "Indonesia", "884,950", "46.46%"},
			{"10", "India", "778,424", "24.68%"},
		};
		
	}

	private String[][] f3() {
		return new String[][]{};
	}

	private String[][] f4() {
		return new String[][]{};
	}

	private String[][] f5() {
		return new String[][]{};
	}

	private String[][] f6() {
		return new String[][]{};
	}
	
//	private String[] i1() {
////		return new String[]{"Titre", "Resume", "TypeArticle"};
//		return new String[]{"Rank", "Country", "Forested Area(km sq)", "% of land area"};
//	}
//
//	private String[] i2() {
////		return new String[]{"Email", "NomChercheur", "PrénomChercheur", "UrlChercheur"};
//		return new String[]{"Rank", "Country", "Forested Area(km sq)", "% of land area"};
//	}
//
//	private String[] i3() {
//		return new String[]{"Email", "NomChercheur", "PrénomChercheur", "UrlChercheur", "NomLaboratoire", "SigleLaboratoire", "AdresseLaboratoire", "UrlLaboratoire"};
//	}
//
//	private String[] i4() {
//		return new String[]{"Email", "NomChercheur", "PrénomChercheur", "UrlChercheur"};
//	}
//
//	private String[] i5() {
//		return new String[]{};
//	}
//
//	private String[] i6() {
//		return new String[]{"Email", "NomChercheur", "PrénomChercheur", "UrlChercheur", "NbArticles", "NbNotes", "MoyNotes"};
//	}
//
//	private String l1() {
//		return "<html>Détermination de la liste des articles écrits par un auteur donné : </html>";
//	}
//
//	private String l2() {
//		return "<html>Affichage de la liste des co-auteurs ayant travaillé avec un chercheur : </html>";
//	}
//
//	private String l3() {
//		return "<html>Affichage de la liste des laboratoires de chaque chercheur : </html>";
//	}
//
//	private String l4() {
//		return "<html>Affichage la liste des chercheurs ayant annoté au moins un nombre donné d'articles : </html>";
//	}
//
//	private String l5() {
//		return "<html>Calcul de la moyenne des notes données par un chercheur donné : </html>";
//	}
//
//	private String l6() {
//		return "<html>Pour chaque chercheur d'un laboratoire donné, afficher le nombre d'articles publiés, le nombre et la moyenne des notes obtenues : </html>";
//	}

}
