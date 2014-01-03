import java.util.ArrayList;
import java.util.List;


public class Piquet {
	private List<Integer> elements = new ArrayList<Integer>();
	private int numero;
	private int taille;
	
	
	public Piquet(int numero) {
		this.numero = numero;
		this.taille = 3;
	}
	
	public int pop() {
		int elem = this.elements.get(this.elements.size() - 1);
		this.elements.remove(this.elements.size() - 1);
		return elem;
	}
	
	public Integer getEtat(int etageDansLeDisque) {
		if( etageDansLeDisque > this.elements.size() || this.elements.size() == 0) {
			return null;
		}
		return this.elements.get(etageDansLeDisque);
	}
	
	public void addDisque(int numeroDeDisque) {
		
		if(this.elements.size() != 0 && this.elements.get(this.elements.size() - 1) < numeroDeDisque) {
			throw new IllegalArgumentException("Piquet n°" + this.numero + "Vous essayez de poser le disque n°" 
										+ numeroDeDisque 
										+ " sur le disque plus petit n°"
										+ this.elements.get(this.elements.size() - 1));
		}
		
		this.elements.add(numeroDeDisque);
	}
	
	public String toString() {
		return this.elements.toString();
	}
}
