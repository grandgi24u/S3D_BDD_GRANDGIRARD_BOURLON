package Vues;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import MVC_Autres.Modele;
import MVC_Autres.Observateur;
import MVC_Autres.Sujet;

// TODO: Auto-generated Javadoc
/**
 * The Class VueCentre.
 */
public class VueCentre extends JPanel implements Observateur {

	/** The vc. */
	private VueTableau vc;
	
	/** The va. */
	private VueTextArea va;
	
	/** The acti. */
	private JButton acti;
	
	/** The desac. */
	private JButton desac;
	
	/** The acti 2. */
	private JButton acti2;
	
	/** The desac 2. */
	private JButton desac2;
	
	/** The jp. */
	private JPanel jp = new JPanel(new BorderLayout());
	
	/** The jp 2. */
	private JPanel jp2 = new JPanel(new BorderLayout());

	/**
	 * Instantiates a new vue centre.
	 *
	 * @param v the v
	 * @param v2 the v 2
	 * @param a the a
	 * @param d the d
	 * @param a2 the a 2
	 * @param d2 the d 2
	 */
	public VueCentre(VueTableau v, VueTextArea v2, JButton a, JButton d, JButton a2, JButton d2) {
		super();
		this.vc = v;
		this.va = v2;
		this.acti = a;
		this.desac = d;
		this.acti2 = a2;
		this.desac2 = d2;
		setLayout(new BorderLayout());
	}

	/**
	 * Actualiser.
	 *
	 * @param s the s
	 */
	@Override
	public void actualiser(Sujet s) {
		Modele m = (Modele)s;

		if(m.getQuestionCourante() == 7){
			this.remove(vc.getTableHeader());
			this.remove(vc);
			this.remove(va);
			jp = new JPanel(new BorderLayout());
			jp2 = new JPanel(new BorderLayout());
			
			JLabel jl1 = new JLabel("Creer ou detruire le premier Trigger");
			JLabel jl2 = new JLabel("Creer ou detruire le deuxieme Trigger");
			
			jp.add(jl1, BorderLayout.NORTH);
			jp.add(acti);
			jp.add(desac, BorderLayout.SOUTH);

			jp2.add(jl2, BorderLayout.NORTH);
			jp2.add(acti2);
			jp2.add(desac2, BorderLayout.SOUTH);
			
			jl1.setHorizontalAlignment(SwingConstants.CENTER);
			jl2.setHorizontalAlignment(SwingConstants.CENTER);
			acti2.setHorizontalAlignment(SwingConstants.CENTER);
			acti.setHorizontalAlignment(SwingConstants.CENTER);
			desac2.setHorizontalAlignment(SwingConstants.CENTER);
			desac.setHorizontalAlignment(SwingConstants.CENTER);
			
			add(jp, BorderLayout.PAGE_START);
			add(jp2, BorderLayout.AFTER_LAST_LINE);
		}else if(m.getQuestionCourante() != 5) {
			this.remove(va);
			this.remove(jp);
			this.remove(jp2);
			add(vc.getTableHeader(), BorderLayout.PAGE_START);
			add(vc, BorderLayout.CENTER);
		}else {
			this.remove(vc.getTableHeader());
			this.remove(vc);
			this.remove(jp);
			this.remove(jp2);
			add(va);
		}
		m.setVC(this);

	}

}
