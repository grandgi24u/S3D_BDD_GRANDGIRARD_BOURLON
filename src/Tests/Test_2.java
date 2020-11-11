package Tests;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;


public class Test_2 {

	String [] index;
	JFrame jf;
	DefaultTableModel dTableModel;
	JTable table1; 
	JLabel label1;
	JPanel jp;

	Test_2() {

		index= new String[]{"Rank", "Country", "Forested Area(km sq)", "% of land area"};

		jf= new JFrame("JScrollPane with JTable");
		label1 = new JLabel("Top 10 countries with most forested area",JLabel.CENTER);
		

		String[][] rawData = new String[][] {
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

		//creating a DeFaultTableModel object, which is subclass of TableModel
		dTableModel = new DefaultTableModel(rawData, index);
		
		//Initializing a JTable from DefaultTableModel.
		table1 = new JTable(dTableModel);

		//Adjusting the contents of each cell of JTable in CENTER
		DefaultTableCellRenderer tableRenderer = new DefaultTableCellRenderer();
		tableRenderer.setHorizontalAlignment(JLabel.CENTER); //Aligning the table data centrally.
		table1.setDefaultRenderer(Object.class, tableRenderer);
		
		//Creating a JPanel, setting it layout to BorderLayout and adding JTable to it.
		jp= new JPanel(new BorderLayout());
		jp.setForeground(Color.blue);
		jp.setBackground(Color.green);
		jp.add(table1, BorderLayout.CENTER);
		
		//Creating a JScrollPane and adding its functionalities to JPanel
		JScrollPane scrollP = new JScrollPane(jp);
		
		//Adding a JLabel and JScrollPane to JFrame.
		jf.add(label1, BorderLayout.NORTH);
		jf.add(scrollP,BorderLayout.CENTER);
		
		jf.setSize(400,300);
		jf.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Test_2();
	}//Closing the main method

}