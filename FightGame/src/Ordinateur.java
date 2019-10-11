/*
 * Classe "Ordinateur" héritant de "Joueur"
 */

public class Ordinateur extends Joueur 
{
	/*
	 * Constructeur de Joueur
	 */
	public Ordinateur(int[] nbSous)
	{
		super(nbSous);
	}
	
	public Ordinateur(int nbSous1, int nbSous5, int nbSous10, int nbSous25)
	{
		super(nbSous1, nbSous5, nbSous10, nbSous25);
	}
	
	public void IA()
	{
		// A implémenter
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(int[] valeurs) 
	{
		return "ORDINATEUR\n"
				+ (sous != null ? arrayToString(sous, sous.length, valeurs) : null)
				+ "";
	}
}
