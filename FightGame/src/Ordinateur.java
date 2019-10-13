/*
 * Classe "Ordinateur" héritant de "Joueur"
 * Version 1.1 - Yanis
 * Version 1.2 - Justin
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
	 * Algorithme de décision de l'ordinateur.
	 * Il regarde d'abord si la valeur cumulée des pièces ayant la valeur la plus basse dans le pot valent la peine d'être gagnées;
	 * Si le choix est celui par défaut, alors il joue la valeur la plus basse qu'il possède
	 */
	public int IA(int[] pot, int[] valeurs)
	{
		int choix = 1;
		int somme = 0;
		
		for(int i = 0; i < pot.length-1; i++)
		{
			somme += pot[i]*valeurs[i];
			if(somme >= valeurs[i+1]-(valeurs[i+1]/2+1) && somme <= valeurs[i+1]-1)
			{
				choix = i+1;
				break;
			}
		}
		System.out.println("Choix : " + choix + " - Somme : " + somme);
		
		
		if(choix == 1)
		{
			for(int i = 0; i < sous.length; i++)
			{
				if(sous[i] != 0)
				{
					choix = i+1;
					break;
				}
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
