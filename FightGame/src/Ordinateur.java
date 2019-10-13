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
	 * Algorithme de décision de l'ordinateur
	 */
	public int IA(int[] pot)
	{
		int choix = 1;
		
		for(int i = 0; i < sous.length; i++)
		{
			if(sous[i] != 0)
			{
				choix = i+1;
				break;
			}
		}
		
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
