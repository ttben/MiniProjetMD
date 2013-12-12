import java.awt.Dimension;
import java.awt.Graphics;
import java.io.IOException;


public class FkSolution extends AbstractSolution {

	
	public FkSolution(int profondeur) {
		super(profondeur);

	}

	@Override
	public void drawSolutionk(Graphics drawingArea, int... arg) {
		
		int ancienDiametre = arg[0];
		int ancienX = arg[1];
		int ancienY = arg[2];
		int profondeurRestant = arg[3];
		if(profondeurRestant <= 0) { return; }
		
		this.profondeur = profondeurRestant;
		
		this.profondeur --;

		System.out.println("\nIteration n°" + this.profondeur);
		
		System.out.println("Dessin de ");
		
		System.out.println("\tX :\t\t" + ancienX);
		System.out.println("\tY :\t\t" + ancienY);
		
		System.out.println("\tDiametre :\t" + ancienDiametre);
		
	
		drawingArea.drawOval(ancienX, ancienY, ancienDiametre,ancienDiametre);

		int nouveauDiametre = ancienDiametre/2;
		
		int nouveauXDroite = ancienX + ancienDiametre;
		int nouveauYDroite = (ancienY)+(ancienDiametre/2) - nouveauDiametre/2;
		
		int nouveauXBas =(ancienX)+(ancienDiametre/2) - nouveauDiametre/2;
		int nouveauYBas = ancienY + ancienDiametre;
		
		int prof = this.profondeur;

		this.drawSolutionk(drawingArea, new int[] {nouveauDiametre,nouveauXBas,nouveauYBas, prof});

		this.drawSolutionk(drawingArea, new int[] {nouveauDiametre,nouveauXDroite,nouveauYDroite, prof });

	}

}
