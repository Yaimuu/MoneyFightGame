/*
 * Classe "Joueur"
 */

public class Joueur
{
	protected int[] sous;
	
	/**
	 * Getter de "sous"
	 * Retourne la valeur des sous du joueur
	 */
	public int[] getSous() 
	{
		return sous;
	}

	/**
	 * Setter de "sous"
	 * Défini la valeur des sous du joueur
	 */
	public void setSous(int[] sous) 
	{
		this.sous = sous;
	}
	
	/*
	 * Constructeur de Joueur
	 */
	public Joueur(int[] nbSous)
	{
		sous = nbSous;
	}
	
	/*
	 * Surcharge du constructeur de Joueur
	 */
	public Joueur(int nbSous1, int nbSous5, int nbSous10, int nbSous25)
	{
		sous[0] = nbSous1;
		sous[1] = nbSous5;
		sous[2] = nbSous10;
		sous[3] = nbSous25;
	}
	
	/*
	 * Méthode permettant au joueur de dépenser ses sous
	 */
	public void DepenserSous()
	{
		
	}
	
	/*
	 * Méthode permettant au joueur de gagner des sous
	 */
	public void GagnerSous()
	{
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(int[] valeurs) 
	{
		return "JOUEUR\n"
				+ (sous != null ? arrayToString(sous, sous.length, valeurs) : null)
				+ "";
	}

	/*
	 * Méthode transformant un tableau en chaîne de caractère,
	 * formalisée pour l'affichage des sous
	 */
	public static String arrayToString(Object array, int len, int[] valeurs) 
	{
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < len; i++) 
		{
			if (i > 0)
				buffer.append("\n");
			if (array instanceof int[])
			{
				buffer.append("\t" + valeurs[i] + " sous : ");
				for(int j = 0; j < ((int[]) array)[i]; j++)
				{
					buffer.append("O ");
				}
			}
		}
		return buffer.toString();
	}
}
