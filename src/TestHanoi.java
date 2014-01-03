
public class TestHanoi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		Piquet p1 = new Piquet(1);
		Piquet p2 = new Piquet(2);
		Piquet p3 = new Piquet(3);
		
		p1.addDisque(3);
		p1.addDisque(2);
		p1.addDisque(1);
		affiche(p1, p2, p3);

		resolve(3, p1, p3, p2);
		affiche(p1, p2, p3);
		
	}

	public static void resolve(int n, Piquet depart, Piquet arrivee, Piquet intermediaire) {
		if(n == 0) return;
		
		resolve(n-1, depart, intermediaire, arrivee);
		arrivee.addDisque(depart.pop());
		resolve(n-1, intermediaire, arrivee, depart);
		
	}

	public static void affiche(Piquet depart, Piquet arrivee, Piquet intermediaire) {
		System.out.println(depart + " " + arrivee + " " + intermediaire);
	}
}
