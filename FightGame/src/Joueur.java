/*
 * Classe "Joueur"
 * Version 1.1 - Yanis
 * Version 1.2 - Justin
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
		return this.sous.clone();
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
		this.sous = nbSous;
	}
	
	
	/*
	 * Méthode permettant au joueur de dépenser ses sous
	 */
	public int[] DepenserSous(int choix)
	{
		int[] returnList = new int[]{0,0};
		int[] sousActuel = this.getSous();
		
		if(sousActuel[choix-1] <= 0)
		{
			returnList[0] = 0;
			returnList[1] = -1;
		}
		else
		{
			sousActuel[choix-1] -= 1;
			this.setSous(sousActuel);
			returnList[0] = (choix-1);
			returnList[1] = sousActuel[choix-1];
		}
		
		return returnList;
	}
	
	/*
	 * Méthode permettant au joueur de gagner des sous
	 */
	public void GagnerSous(int wonSous[])
	{
		int[] sousActuel = this.getSous();
		for(int i=0; i < wonSous.length; i++){
			sousActuel[i] += wonSous[i];
		}
		this.setSous(sousActuel);
	}
	
	/*
	 * Permet de savoir si sous est vide
	 */
	public boolean IsEmpty()
	{
		boolean isEmpty = true;
		int[] sousActuel = this.getSous();
		for(int piece : sousActuel)
		{
			if(piece != 0)
			{
				isEmpty = false;
			}
		}
		return isEmpty;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(int[] valeurs) 
	{
		return "JOUEUR\n"
				+ (this.sous != null ? arrayToString(this.sous, this.sous.length, valeurs) : null)
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
