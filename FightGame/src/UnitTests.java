import static org.junit.Assert.*;

import org.junit.Test;

/*
 * Auteur : Yanis Ouled Moussa, Justin Garcia
 * Version : 1.1
 * Fichier : UnitTest.java - Classe de test unitaires, contenant les m�thodes DepenserArgentTest(), GagnerArgentTest() et isEmptyTest()
 */
public class UnitTests{
	@Test
    public void DepenserArgentTest() 
	{
        Joueur joueurTest = new Joueur(new int[] {1, 2, 3, 4}); // MyClass is tested
        
        assertEquals(2, joueurTest.sous[1]); // On a bien 2 pi�ces de 5 comme �crit dans l'initialisation
        
        joueurTest.DepenserSous(2); // Emulation du choix n� 2 dans le menu (donc de la pi�ce de 5)
        
        assertEquals(1, joueurTest.sous[1]); // On retrouve bien notre pi�ce en moins dans le test
    }
	
	@Test
    public void GagnerArgentTest() 
	{
        Joueur joueurTest = new Joueur(new int[] {1, 2, 3, 4}); // MyClass is tested
        
        assertEquals(4, joueurTest.sous[3]); // On a bien 4 pi�ces de 25 comme �crit dans l'initialisation
        assertEquals(2, joueurTest.sous[1]); // On a bien 4 pi�ces de 5 comme �crit dans l'initialisation
        
        joueurTest.GagnerSous(new int[] {0, 2, 0, 1}); // On fait remporter une pi�ece de 25 et deux pi�ces de 5 au joueur
        
        assertEquals(5, joueurTest.sous[3]); // On retrouve bien notre pi�ce de 25 en plus
        assertEquals(4, joueurTest.sous[1]); // On retrouve bien nos 2 pi�ces de 5 en plus
    }
	
	@Test
	public void isEmptyTest() 
	{
		Joueur joueurTest = new Joueur(new int[] {0, 0, 0, 0}); // MyClass is tested
		Joueur joueurTest2 = new Joueur(new int[] {0, 3, 0, 0}); // MyClass is tested
		
		assertEquals(false, joueurTest2.IsEmpty()); // Le test r�ussi car le joueur a des sous
        assertEquals(true, joueurTest.IsEmpty()); // Le test r�ussi car le joueur a 0 sous
	}
}
