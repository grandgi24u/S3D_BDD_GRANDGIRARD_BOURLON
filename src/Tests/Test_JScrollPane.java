package Tests;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;

public class Test_JScrollPane extends JFrame {

	private static final long serialVersionUID = 1L;

	public Test_JScrollPane(){
       super("JScrollPaneExemple");
       this.setSize(400,340);
       this.setPreferredSize(new Dimension(400,340));
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setLocationRelativeTo(null);
       this.setVisible(true);
  
       JPanel global = new JPanel(new GridLayout(4, 1));

       JPanel p0 = new JPanel(new GridLayout(1,3));
       JLabel t0 = new JLabel("Titre de l'article");
       JLabel r0 = new JLabel("Resume de l'article   ");
       JLabel y0 = new JLabel("Type de l'article");
       t0.setForeground(Color.orange);
       r0.setForeground(Color.orange);
       y0.setForeground(Color.orange);
       p0.add(t0);
       p0.add(r0);
       p0.add(y0);
       p0.setBackground(new Color(0, 64, 48));
       p0.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
       global.add(p0);
       JPanel p1 = new JPanel(new GridLayout(1,3));
       JLabel t1 = new JLabel("1er titre");
       JLabel r1 = new JLabel("1er resume");
       JLabel y1 = new JLabel("1er type");
       t1.setForeground(Color.white);
       r1.setForeground(Color.white);
       y1.setForeground(Color.white);
       p1.add(t1);
       p1.add(r1);
       p1.add(y1);
       p1.setBackground(new Color(15, 166, 129));
       p1.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
       global.add(p1);
       JPanel p2 = new JPanel(new GridLayout(1,3));
       JLabel t2 = new JLabel("2eme titre");
       JLabel r2 = new JLabel("2eme resume");
       JLabel y2 = new JLabel("2eme type");
       t2.setForeground(Color.white);
       r2.setForeground(Color.white);
       y2.setForeground(Color.white);
       p2.add(t2);
       p2.add(r2);
       p2.add(y2);
       p2.setBackground(new Color(15, 166, 129));
       p2.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
       global.add(p2);
       JPanel p3 = new JPanel(new GridLayout(1,3));
       JLabel t3 = new JLabel("3eme titre");
       JLabel r3 = new JLabel("3eme resume");
       JLabel y3 = new JLabel("3eme type");
       t3.setForeground(Color.white);
       r3.setForeground(Color.white);
       y3.setForeground(Color.white);
       p3.add(t3);
       p3.add(r3);
       p3.add(y3);
       p3.setBackground(new Color(15, 166, 129));
       global.add(p3);

       JPanel p4 = new JPanel(new GridLayout(1,3));
       JLabel t4 = new JLabel("4eme titre");
       JLabel r4 = new JLabel("4eme resume");
       JLabel y4 = new JLabel("4eme type");
       t4.setForeground(Color.white);
       r4.setForeground(Color.white);
       y4.setForeground(Color.white);
       p4.add(t4);
       p4.add(r4);
       p4.add(y4);
       p4.setBackground(new Color(15, 166, 129));
       global.add(p4);

       JPanel p5 = new JPanel(new GridLayout(1,3));
       JLabel t5 = new JLabel("5eme titre");
       JLabel r5 = new JLabel("5eme resume");
       JLabel y5 = new JLabel("5eme type");
       t5.setForeground(Color.white);
       r5.setForeground(Color.white);
       y5.setForeground(Color.white);
       p5.add(t5);
       p5.add(r5);
       p5.add(y5);
       p5.setBackground(new Color(15, 166, 129));
       global.add(p5);
       JPanel p6 = new JPanel(new GridLayout(1,3));
       JLabel t6 = new JLabel("6eme titre");
       JLabel r6 = new JLabel("6eme resume");
       JLabel y6 = new JLabel("6eme type");
       t6.setForeground(Color.white);
       r6.setForeground(Color.white);
       y6.setForeground(Color.white);
       p6.add(t6);
       p6.add(r6);
       p6.add(y6);
       p6.setBackground(new Color(15, 166, 129));
       global.add(p6);
       JPanel p7 = new JPanel(new GridLayout(1,3));
       JLabel t7 = new JLabel("7eme titre");
       JLabel r7 = new JLabel("7eme resume");
       JLabel y7 = new JLabel("7eme type");
       t7.setForeground(Color.white);
       r7.setForeground(Color.white);
       y7.setForeground(Color.white);
       p7.add(t7);
       p7.add(r7);
       p7.add(y7);
       p7.setBackground(new Color(15, 166, 129));
       global.add(p7);
       JPanel p8 = new JPanel(new GridLayout(1,3));
       JLabel t8 = new JLabel("8eme titre");
       JLabel r8 = new JLabel("8eme resume");
       JLabel y8 = new JLabel("8eme type");
       t8.setForeground(Color.white);
       r8.setForeground(Color.white);
       y8.setForeground(Color.white);
       p8.add(t8);
       p8.add(r8);
       p8.add(y8);
       p8.setBackground(new Color(15, 166, 129));
       global.add(p8);

//       global.add(jta);
       
       JScrollPane jsp = new JScrollPane(global);
       
//       JPanel[] jp = {p0,p1,p2,p3,p4,p5,p6,p7,p8};
//       JScrollPane jsp = new JScrollPane(new JList<JPanel>(jp));       

       jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
       jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
       this.add(jsp, BorderLayout.CENTER);
//       this.add(global, BorderLayout.CENTER);
       this.pack();
    }
 
    public static void main(String[] args) {
       new Test_JScrollPane();
    }
}

