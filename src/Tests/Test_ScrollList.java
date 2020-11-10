package Tests;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class Test_ScrollList extends JFrame {

  JScrollPane scrollpane;

  public Test_ScrollList() {
    setSize(300, 200);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    JPanel p1 = new JPanel(new GridLayout(2,1));
    p1.add(new JLabel("Household"));
    p1.add(new JLabel("1"));
    JPanel p2 = new JPanel(new GridLayout(2,1));
    p2.add(new JLabel("Office"));
    p2.add(new JLabel("2"));
    JPanel p3 = new JPanel(new GridLayout(2,1));
    p3.add(new JLabel("Extended Family"));
    p3.add(new JLabel("3"));
    JPanel p4 = new JPanel(new GridLayout(2,1));
    p4.add(new JLabel("Company (US)"));
    p4.add(new JLabel("4"));
    JPanel p5 = new JPanel(new GridLayout(2,1));
    p5.add(new JLabel("Company (Word)"));
    p5.add(new JLabel("5"));
    JPanel p6 = new JPanel(new GridLayout(2,1));
    p6.add(new JLabel("Team"));
    p6.add(new JLabel("6"));
    JPanel p7 = new JPanel(new GridLayout(2,1));
    p7.add(new JLabel("Will"));
    p7.add(new JLabel("7"));
    JPanel p8 = new JPanel(new GridLayout(2,1));
    p8.add(new JLabel("Birthday Card List"));
    p8.add(new JLabel("8"));
    JPanel p9 = new JPanel(new GridLayout(2,1));
    p9.add(new JLabel("High School"));
    p9.add(new JLabel("9"));
    JPanel p10 = new JPanel(new GridLayout(2,1));
    p10.add(new JLabel("Country"));
    p10.add(new JLabel("10"));
    JPanel p11 = new JPanel(new GridLayout(2,1));
    p11.add(new JLabel("Continent"));
    p11.add(new JLabel("11"));
    JPanel p12 = new JPanel(new GridLayout(2,1));
    p12.add(new JLabel("Planet"));
    p12.add(new JLabel("12"));
    JPanel Pcategories[] = {p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12};
    JLabel Lcategories[] = { new JLabel("Household"), new JLabel("Office"), 
    		new JLabel("Extended Family"), new JLabel("Company (US)"), new JLabel("Company (World)"), 
    		new JLabel("Team"), new JLabel("Will"), new JLabel("Birthday Card List"), 
    		new JLabel("High School"), new JLabel("Country"), new JLabel("Continent"), 
    		new JLabel("Planet") };
    JList<JLabel> listL = new JList<JLabel>(Lcategories);
    JList<JPanel> listP = new JList<JPanel>(Pcategories);
    scrollpane = new JScrollPane(listP);

    getContentPane().add(scrollpane, BorderLayout.CENTER);
  }

  public static void main(String args[]) {
	  Test_ScrollList sl = new Test_ScrollList();
    sl.setVisible(true);
  }
}