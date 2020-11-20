package Vues;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextField;

import MVC_Autres.Modele;
import MVC_Autres.Observateur;
import MVC_Autres.Sujet;

/**
 * The Class VueSud.
 */
public class VueSud extends JPanel implements Observateur {

	/** The jt. */
	private JTextField jt;
	
	/** The vts. */
	private VueTextSud vts;
	
	/**
	 * Instantiates a new vue sud.
	 *
	 * @param j the j
	 * @param v the v
	 */
	public VueSud(JTextField j, VueTextSud v) {
		super();
		this.jt = j;
		this.vts = v;
		add(vts, BorderLayout.WEST);
		add(jt, BorderLayout.EAST);
		
		setBackground(new Color(0, 64, 48));
	}
	
	/**
	 * Actualiser.
	 *
	 * @param s the s
	 */
	@Override
	public void actualiser(Sujet s) {
		Modele m =(Modele)s;
		
		if(m.getQuestionCourante() == 2) {
			remove(jt);
			add(vts, BorderLayout.CENTER);
		}else if(m.getQuestionCourante() == 7) {
			remove(jt);
			add(vts, BorderLayout.CENTER);
		}else {
			remove(vts);
			add(vts, BorderLayout.WEST);
			add(jt, BorderLayout.EAST);
		}
	}

}
