package OnlineLib;
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

	public String[] getIndex() {
		switch (recherche) {
			case (1) : return i1();
			case (2) : return i2();
			case (3) : return i3();
			case (4) : return i4();
			case (5) : return i5();
			default  : return i6();
		}
	}

	public String getTitre() {
		switch (recherche) {
			case (1) : return l1();
			case (2) : return l2();
			case (3) : return l3();
			case (4) : return l4();
			case (5) : return l5();
			default  : return l6();
		}
	}

	private String[][] f1() {
		String[][] list = new String[][] {
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
		return list;
	}

	private String[][] f2() {
		String[][] list = new String[][]{};
		return list;
	}

	private String[][] f3() {
		String[][] list = new String[][]{};
		return list;
	}

	private String[][] f4() {
		String[][] list = new String[][]{};
		return list;
	}

	private String[][] f5() {
		String[][] list = new String[][]{};
		return list;
	}

	private String[][] f6() {
		String[][] list = new String[][]{};
		return list;
	}
	
	private String[] i1() {
		String[] index= new String[]{"Rank", "Country", "Forested Area(km sq)", "% of land area"};
		return index;
	}

	private String[] i2() {
		String[] index= new String[]{};
		return index;
	}

	private String[] i3() {
		String[] index= new String[]{};
		return index;
	}

	private String[] i4() {
		String[] index= new String[]{};
		return index;
	}

	private String[] i5() {
		String[] index= new String[]{};
		return index;
	}

	private String[] i6() {
		String[] index= new String[]{};
		return index;
	}

	private String l1() {
		return "Ceci est l'explication de l'utilité de la recherche n°1";
	}

	private String l2() {
		return "Ceci est l'explication de l'utilité de la recherche n°2";
	}

	private String l3() {
		return "Ceci est l'explication de l'utilité de la recherche n°3";
	}

	private String l4() {
		return "Ceci est l'explication de l'utilité de la recherche n°4";
	}

	private String l5() {
		return "Ceci est l'explication de l'utilité de la recherche n°5";
	}

	private String l6() {
		return "Ceci est l'explication de l'utilité de la recherche n°6";
	}

}
