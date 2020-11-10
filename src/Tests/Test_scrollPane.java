package Tests;
import java.awt.Dimension;
import java.awt.ScrollPane;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Test_scrollPane {

	public static void main (String[] args) {
		ScrollPane content = new ScrollPane();

//		ScrollPane_content scp = new ScrollPane_content();
//		ArrayList<JLabel> ls = scp.f1();
//		JLabel jl;
//		for (JLabel l : ls) {
//			jl = l;
//			jl.setPreferredSize(new Dimension(400,40));
//			System.out.println(l);
//			content.add(l);
//		}
		
		content.add(new JLabel("n°1"));
		content.add(new JLabel("n°2"));
		content.add(new JLabel("n°3"));
		
		JFrame f = new JFrame();
		f.getContentPane().add(content);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(new Dimension(400,300));
		f.setVisible(true);	
	}
	
}
