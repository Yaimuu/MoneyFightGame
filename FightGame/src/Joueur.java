
public class Joueur
{
	protected int[] sous;
	
	/**
	 * @return the sous
	 */
	public int[] getSous() {
		return sous;
	}

	/**
	 * @param sous the sous to set
	 */
	public void setSous(int[] sous) {
		this.sous = sous;
	}
	
	public Joueur(int[] nbSous)
	{
		sous = nbSous;
	}
	
	public Joueur(int nbSous1, int nbSous5, int nbSous10, int nbSous25)
	{
		sous[0] = nbSous1;
		sous[1] = nbSous5;
		sous[2] = nbSous10;
		sous[3] = nbSous25;
	}
	
	public int DepenserSous(int choix)
	{
		if(this.sous[choix-1] == 0){
			return -1;
		}else{
			this.sous[choix-1] -= 1;
			return this.sous[choix-1];
		}
	}
	
	public void GagnerSous(int wonSous[])
	{
		for(int i=0; i < wonSous.length; i++){
			switch(){
				case -1:
					
				break;
			}
		}
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
