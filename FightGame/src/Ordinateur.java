/*
 * Classe "Ordinateur" h�ritant de "Joueur"
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
	 * Algorithme de d�cision de l'ordinateur.
	 * Il regarde d'abord si la valeur cumul�e des pi�ces ayant la valeur la plus basse dans le pot valent la peine d'�tre gagn�es;
	 * Si le choix est celui par d�faut, alors il joue la valeur la plus basse qu'il poss�de
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
