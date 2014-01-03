import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TestF4kSolution {
	public static void main(String[] args) throws IOException {
		System.out.println("Veuillez saisir la profondeur de récursion pour la figure F4k :");
		System.out.println("Pour un rendu optimal, nous vous conseillons de générer avec une profondeur > 5 et < 10");
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in)); 
		
		int profondeur = Integer.parseInt(keyboard.readLine());
		
		AbstractSolution.params = new int[]{200,600,300,profondeur,0,0, 60, 20, 0, 2};
		new F4kSolution(profondeur);
	}
}
