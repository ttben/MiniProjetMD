import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TestF3kSolution {
	public static void main(String[] args) throws IOException {
		System.out.println("Veuillez saisir la profondeur de récursion pour la figure F3k :");
		
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in)); 
		
		int profondeur = Integer.parseInt(keyboard.readLine());
		
		AbstractSolution.params = new int[]{200,600,300,profondeur,0,0};
		new F3kSolution(profondeur);
	}
}
