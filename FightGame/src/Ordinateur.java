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
	
	/*
	 * 
	 */
	public int IA(int[] pot)
	{
		int choix = 1;
		// A implémenter
		
		
		
		
		return choix;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(int[] valeurs) 
	{
		return "ORDINATEUR\n"
				+ (this.sous != null ? arrayToString(this.sous, this.sous.length, valeurs) : null)
				+ "";
	}
}
