import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TestFkSolution {
	public static void main(String[] args) throws IOException {
		System.out.println("Veuillez saisir la profondeur de récursion pour la figure F1 :");
		
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in)); 
		
		int profondeur = Integer.parseInt(keyboard.readLine());
		
		AbstractSolution.params = new int[]{380,15,40,profondeur,0,0};
		new FkSolution(profondeur);
		
		/*
		 * 2. 	Quelle est la taille maximale de la figure obtenue,
		 * 		de manière plus précise, quelle est la taille du 
		 * 		plus petit carré contenant la figure Fk. pour tout
		 * 		entier k , on supposera que le diamètre du disque
		 * 		initial est 1?
		 * 
		 * 		Vu que le diamètre est divisé par 2 à chaque nouvelle
		 * 		itération, le carré devra avoir une largeur de 1 + 1/2
		 * 		+ 1/4 + 1/8 ... jusqu'à k.
		 * 
		 * 		Or, S = 1/2 + 1/4 + 1/8 + ... + 1/(2^n) = 1
		 * 		(admis depuis collège)
		 * 
		 * 		Donc largeur carré = Stotale = 1 + S = 1 + 1 = 2
		 * 		
		 * 		Même raisonnement sur la hauteur 
		 * 			(de toute façon c'est un carré)
		 * 
		 * 		Donc le carré doit faire 2x2
		 */
	}
}
