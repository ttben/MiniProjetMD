import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TestF2kSolution {
	public static void main(String[] args) throws IOException {
		System.out.println("Veuillez saisir la profondeur de récursion pour la figure F2k :");
		
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in)); 
		
		int profondeur = Integer.parseInt(keyboard.readLine());
		
		AbstractSolution.params = new int[]{220,450,250,profondeur,0,0};
		new F2kSolution(profondeur);
		
		/* 	Si on colorie l’intérieur des cercles en vert fluo,
		 * 	quelle sera, en fonction de k, la taille de la surface colorée ?
		 * 
		 * 	Soit Ck un ou le cercle généré à l'itération k.
		 * 	A(C1) = 1 * PI
		 * 	A(C2) = 1/2 * PI
		 * 	A(C3) = 1/4 * PI
		 * 	A(C4) = 1/8 * PI
		 * 
		 * 	Or il y a 1 * C1 ; 4 * C2 ; 12 * C3 ; 36 * C4
		 * 
		 * 	Soit Ak l'aire des cercles générés à l'itération k
		 * 
		 * 	A1 = 1 * PI
		 * 	A2 = A1 + 4  * A(C2)
		 * 	A3 = A2 + 12 * A(C3)
		 * 	A4 = A3 + 36 * A(C4)
		 * 
		 * 	A1 = PI
		 * 	A2 = A1 + 4 * A(C2)
		 * 
		 * 	Ak = A(k-1) + k * (k-1) * 3 * A(Ck)
		 */
	}
}
