/*
 * Permet d'utiliser l'objet "Scanner"
 */
import java.util.Scanner;

/*
 * Classe principale du jeu
 */
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
	public static Joueur tmpjoueurs;
	
	public static int[][] pieces = {{},{},{}};
	
	public static int turn = 0;
	public static int choix = 0;
	public static boolean end = false;
	
	/*
	 * Fonction principale dans laquelle le jeu se déroule
	 */
	public static void main(String[] args)
	{
		boolean bonChoix = true;
		boolean abandon = false;
		
		setup();
	    
	    /*
	     *  Boucle principale  dans laquelle la partie se déroule
	     */
		while(!end)
		{
			if(turn == JOUEUR)
			{
				menu();
				do 
				{
					bonChoix = true;
					if((choix >= 1 && choix <= 4) && joueur.sous[choix-1] > 0)
					{
						jeu(joueur, choix);
					}
					else if(choix == 5)
					{
						score();
						end = true;
						abandon = true;
						System.out.println("Vous venez d'abandonner, l'ordinateur gagne !");
					}
					else
					{
						bonChoix = false;
						System.out.println("Votre choix doit être compris entre 1 et 5 : ");
						choix = scan.nextInt();
					}
					
				} while(!bonChoix);
				tmpjoueurs = joueur;
			}
			else
			{
				choix = ordinateur.IA(pieces[POT]);
				if(ordinateur.sous[choix-1] > 0)
				{
					jeu(ordinateur, choix);
				}
				
				if(ordinateur.IsEmpty())
				{
					end = true;
				}
			}
			
			changerDeTour();
			
			if(tmpjoueurs.IsEmpty())
			{
				end = true;
				break;
			}
		}
		if(!abandon)
		{
			score();
			
			/*
			 *  Gestion du gagnant
			 */
			if(turn != JOUEUR)
			{
				System.out.println("L'ordinateur gagne !");
			}
			else
			{
				System.out.println("Vous avez gagné !");
			}
		}
		
	}
	
	/*
	 * Fonction générant le menu
	 */
	public static void menu()
	{
		score();
		
		System.out.println("Faites votre choix");
		System.out.println("   ----------------------------");
		for(int i=0; i < 4; i++)
		{
			System.out.println("	" + (i+1) + " : piece de " + VALEUR_PIECES[i] + " sous");
		}
		System.out.println("	5 : Abandonner la partie");
		
		
		System.out.println("Entez votre choix : ");
		choix = scan.nextInt(); 
	}
	
	public static void score()
	{
		System.out.println(joueur.toString(VALEUR_PIECES));
		System.out.println("POT\n" + Joueur.arrayToString(pieces[POT], pieces[POT].length, VALEUR_PIECES));
		System.out.println(ordinateur.toString(VALEUR_PIECES));
	}
	
	/*
	 * Procédure innitialisant les joueurs et les pièces 
	 */
	public static void setup()
	{
		scan = new Scanner(System.in);
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
	public static void jeu(Joueur joueurOuOrdi, int choix)
	{
		int[] sousDepenser = joueurOuOrdi.DepenserSous(choix);
		pieces[POT][sousDepenser[0]] += 1;
		int[] tableSousRecu = new int[] {0, 0, 0, 0};
		int sommeSous = 0;
		int sousARecevoir = VALEUR_PIECES[sousDepenser[0]] - 1;
		//System.out.println("Sous need : " + sousARecevoir);
		if(choix-1 > 0) {
			sousARecevoir = VALEUR_PIECES[choix-1];
		}
		for(int i = 0; i <= pieces[POT].length-1; i++) 
		{
			while(pieces[POT][i] > 0 && sommeSous + (VALEUR_PIECES[i]) < sousARecevoir) 
			{
				tableSousRecu[i] += 1;
				sommeSous = sommeSous + (VALEUR_PIECES[i]);
				pieces[POT][i] -= 1;
			}
		}
		joueurOuOrdi.GagnerSous(tableSousRecu);
		//System.out.println("Pieces a recevoir : " + sommeSous);
	}
}
