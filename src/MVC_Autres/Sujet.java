package MVC_Autres;

/**
 * The Interface Sujet.
 */
public interface Sujet {
	
	/**
	 * Enregistrer observateur.
	 *
	 * @param o the o
	 */
	public void enregistrerObservateur(Observateur o);
	
	/**
	 * Supprimer observateur.
	 *
	 * @param o the o
	 */
	public void supprimerObservateur(Observateur o);
	
	/**
	 * Notifier observateurs.
	 *
	 * @param a the a
	 */
	public void notifierObservateurs(int a);
}
