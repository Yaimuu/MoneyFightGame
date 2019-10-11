import java.util.Scanner;

public class Game 
{
	/*
	 * ---------------- Constantes
	 * */
	public final static int JOUEUR = 0;
	public final static int ORDI = 1;
	public final static int POT = 2;
	
	public static final int[] VALEUR_PIECES = {1,5,10,25};
	public static final int[] NB_PIECES = {4,3,2,1};
	
	/*
	 * ---------------- Variables
	 * */
	public static Scanner scan;
	public static Joueur joueur;
	public static Ordinateur ordinateur;
	
	public static int[][] pieces = {{},{},{}}; // 0 : Joueur - 1 : Ordinateur - 2 : POT
	
	public static int turn = 0; // 0 : Joueur - 1 : Ordinateur
	public static int choix = 0;
	public static boolean end = false;
	
	/*
	 * Fonction principale dans laquelle le jeu se déroule
	 */
	public static void main(String[] args)
	{
		boolean bonChoix = true;
		
		setup();
	    
	    // Boucle principale  dans laquelle la partie se déroule
		while(!end)
		{
			if(turn == JOUEUR)
			{
				menu();
				do 
				{
					bonChoix = true;
					if(choix >= 1 && choix <= 4)
					{
						jeu();
					}
					else if(choix == 5)
					{
						end = true;
					}
					else
					{
						bonChoix = false;
						System.out.println("Votre choix doit être compris entre 1 et 5 : ");
						choix = scan.nextInt();
					}
					
				} while(!bonChoix);
				
			}
			else
			{
				ordinateur.IA();
			}
			
			changerDeTour();
		}
	}
	
	/*
	 * Fonction générant le menu
	 */
	public static void menu()
	{
		System.out.println(joueur.toString(VALEUR_PIECES));
		System.out.println("POT\n" + Joueur.arrayToString(pieces[POT], pieces[POT].length, VALEUR_PIECES));
		System.out.println(ordinateur.toString(VALEUR_PIECES));
		
		System.out.println("Faites votre choix");
		System.out.println("   ----------------------------");
		System.out.println("	1: piece de 1 sou");
		System.out.println("	2: piece de 5 sous");
		System.out.println("	3: piece de 10 sous");
		System.out.println("	4: piece de 25 sous");
		System.out.println("	5: Abandonner la partie");
		
		
		System.out.println("Entez votre choix : ");
		choix = scan.nextInt(); 
	}
	
	/*
	 * Procédure innitialisant les joueurs et les pièces 
	 */
	public static void setup()
	{
		scan = new Scanner(System.in);  // Create a Scanner object
		joueur = new Joueur(NB_PIECES);
		ordinateur = new Ordinateur(NB_PIECES);
		pieces[JOUEUR] = joueur.getSous();
		pieces[ORDI] = ordinateur.getSous();
		pieces[POT] = new int[] {0,0,0,0};
	}
	
	/*
	 * Procédure gérant le changement de tour
	 */
	public static void changerDeTour()
	{
		if(turn == JOUEUR)
		{
			turn = ORDI;
		}
		else
		{
			turn = JOUEUR;
		}
	}
	
	/*
	 * Procédure gérant le tour du joueur
	 */
	public static void jeu()
	{
		
	}
}
