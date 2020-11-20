package OnlineLib;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * La classe de login pour la base de donner
 */
class Main_Login extends JFrame implements ActionListener {
	
	/** The connect. */
	private JButton connect =new JButton("Se connecter");;
	
	/** The label 1. */
	private JLabel label1 = new JLabel("Nom d'utilisateur");
	
	/** The label 2. */
	private JLabel label2 = new JLabel("Mot de passe ");
	
	/** The text 1. */
	private JTextField text1 = new JTextField(15);
	
	/** The text 2. */
	private JPasswordField text2 = new JPasswordField(15);
	
	/**
	 * Constructeur de la page de connexion
	 */
	public Main_Login(){

		JPanel panel = new JPanel(new GridLayout(3,1));
		
		JPanel panNorth = new JPanel(new GridLayout(1,2));
		JPanel panCenter = new JPanel(new GridLayout(1,2));
		
		panNorth.add(label1);
		panNorth.add(text1);
		
		panCenter.add(label2);
		panCenter.add(text2);
		
		panel.add(panNorth, BorderLayout.NORTH);
		panel.add(panCenter, BorderLayout.CENTER);
		panel.add(connect, BorderLayout.SOUTH);
		
		label1.setForeground(Color.orange);
		panNorth.setBackground(new Color(0, 64, 48));
		
		label2.setForeground(Color.orange);
		panCenter.setBackground(new Color(0, 64, 48));
		
		connect.setBackground(new Color(0, 64, 48));
		connect.setForeground(Color.orange);
		
		add(panel,BorderLayout.CENTER);
		connect.addActionListener(this);
		setTitle("Connection");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(300,200));
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	/**
	 * Action performed.
	 *
	 * @param ae the ae
	 */
	public void actionPerformed(ActionEvent ae){
		String value1=text1.getText();
		String value2=text2.getText();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	        String url = "jdbc:oracle:thin:@charlemagne.iutnc.univ-lorraine.fr:1521:infodb";
	        Connection c = DriverManager.getConnection(url, value1, value2);
	        Princ_inter page = new Princ_inter(value1, value2);
			dispose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,"Impossible de se connecter",
					"Error",JOptionPane.ERROR_MESSAGE);
			text2.setText("");
		}
	}
	
	/**
	 * La methode main
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Main_Login f = new Main_Login();
	}
}

