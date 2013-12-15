import java.awt.*;                    // Pour  Graphics, Frame
import java.awt.event.WindowAdapter;  // Pour fermer
import java.awt.event.WindowEvent;    // Pour fermer

public abstract class AbstractSolution extends Frame {
	protected static final int WIDTH = 1366;       // taille initiale de la frame 
	protected static final int HEIGHT = 768;
	protected int profondeur; // profondeur de récursivité

	public AbstractSolution(int profondeur) {

		if(profondeur < 1) {
			throw new IllegalArgumentException("La profondeur doit être > 0");
		}
		
	    
	    this.setSize(WIDTH, HEIGHT);
		this.setVisible(true);
		this.setBackground (Color.white);
		this.profondeur= profondeur;
		addWindowListener(new WindowHandler());  // pour fermer
		setTitle("Dessins recursifs au niveau : "+profondeur);
	}

	private class WindowHandler extends WindowAdapter {
		public void windowClosing(WindowEvent e) {System.exit(0);}
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

		int frameHeight = getSize().height; // taille du frame, cette fois avec les bordures
		int frameWidth = getSize().width;   
		g2d.setColor(Color.black);  // La couleur avec laquelle on va dessiner
		//g2d.translate(frameWidth/2,frameHeight/2); //pour déplacer l'origine si besoin

		// mettre ici un appel de drawSolutionk avec une liste d'arguments adaptés, par exemple : 
		// POUR TESTER FKSOLUTION :
		//drawSolutionk(g2d, 380,15,40,profondeur,0,0);
		
		// POUR TESTER FKSOLUTIONCERCLE : 
		// drawSolutionk(g2d, 220,450,250,profondeur,0,0);
			
		drawSolutionk(g2d, 220,450,250,profondeur,0,0);
		
	}

	/** drawSolutionk 
	 *  Produit un dessin recursif
	 * Parametres: 
	 *    Graphics drawingArea : L'objet graphique dans lequel on dessine
	 *    int ... arg : les coordonnées, longueur et autres si besoin, et profondeur de récursivité
	 **/ 
	public abstract void drawSolutionk(Graphics drawingArea, int ... arg) ;

}


