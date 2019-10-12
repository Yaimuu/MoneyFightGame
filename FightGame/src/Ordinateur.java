/*
 * Classe "Ordinateur" h�ritant de "Joueur"
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
	
	
	public void IA(int[] pot)
	{
		// A impl�menter
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
