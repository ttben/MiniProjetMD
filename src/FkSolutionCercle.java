import java.awt.Graphics;


public class FkSolutionCercle  extends AbstractSolution {

	
	public FkSolutionCercle(int profondeur) {
		super(profondeur);
	}
	
	@Override
	public void drawSolutionk(Graphics drawingArea, int... arg) {
		
		int ancienDiametre = arg[0];
		int ancienX = arg[1];
		int ancienY = arg[2];
		int profondeurRestant = arg[3];
		if(profondeurRestant <= 0) { return; }
		int orientation = arg[4];
		int nbIteration = arg[5];
		

		
		this.profondeur = profondeurRestant;
		this.profondeur --;

//		System.out.println("\nIteration n°" + this.profondeur);
//		
//		System.out.println("Dessin de ");
//		
//		System.out.println("\tX :\t\t" + ancienX);
//		System.out.println("\tY :\t\t" + ancienY);
//		
//		System.out.println("\tDiametre :\t" + ancienDiametre);
		
		drawingArea.drawOval(ancienX, ancienY, ancienDiametre,ancienDiametre);		
		int nouveauDiametre = ancienDiametre/2;
		
		int nouveauXDroite = ancienX + ancienDiametre;
		int nouveauYDroite = (ancienY)+(ancienDiametre/2) - nouveauDiametre/2;
		
		int nouveauXBas =(ancienX)+(ancienDiametre/2) - nouveauDiametre/2;
		int nouveauYBas = ancienY + ancienDiametre;
		
		int nouveauXHaut =(ancienX)+(ancienDiametre/2) - nouveauDiametre/2;
		int nouveauYHaut = ancienY - nouveauDiametre;
		
		int nouveauXGauche =ancienX  - nouveauDiametre;
		int nouveauYGauche = (ancienY)+(ancienDiametre/2) - nouveauDiametre/2;
		
		int prof = this.profondeur;

		if(nbIteration == 0) {
			nbIteration ++;

			this.drawSolutionk(drawingArea, new int[] {nouveauDiametre,nouveauXHaut,nouveauYHaut, prof, 0,nbIteration});
			this.drawSolutionk(drawingArea, new int[] {nouveauDiametre,nouveauXDroite,nouveauYDroite, prof,15,nbIteration});
			this.drawSolutionk(drawingArea, new int[] {nouveauDiametre,nouveauXGauche,nouveauYGauche, prof,45,nbIteration});
			this.drawSolutionk(drawingArea, new int[] {nouveauDiametre,nouveauXBas,nouveauYBas, prof,30,nbIteration});
			return;
		}
		
		
		switch(orientation) {
		case 0:
			this.drawSolutionk(drawingArea, new int[] {nouveauDiametre,nouveauXHaut,nouveauYHaut, prof, 0,nbIteration});
			this.drawSolutionk(drawingArea, new int[] {nouveauDiametre,nouveauXDroite,nouveauYDroite, prof,15,nbIteration });
			this.drawSolutionk(drawingArea, new int[] {nouveauDiametre,nouveauXGauche,nouveauYGauche, prof, 45,nbIteration});
		
			break;
		case 15:
			this.drawSolutionk(drawingArea, new int[] {nouveauDiametre,nouveauXBas,nouveauYBas, prof,30,nbIteration});
			this.drawSolutionk(drawingArea, new int[] {nouveauDiametre,nouveauXHaut,nouveauYHaut, prof,0,nbIteration});
			this.drawSolutionk(drawingArea, new int[] {nouveauDiametre,nouveauXDroite,nouveauYDroite, prof,15,nbIteration });
		
			break;
		case 30:
			this.drawSolutionk(drawingArea, new int[] {nouveauDiametre,nouveauXBas,nouveauYBas, prof,30,nbIteration});
			this.drawSolutionk(drawingArea, new int[] {nouveauDiametre,nouveauXDroite,nouveauYDroite, prof, 15,nbIteration});
			this.drawSolutionk(drawingArea, new int[] {nouveauDiametre,nouveauXGauche,nouveauYGauche, prof, 45,nbIteration});
		
			break;
		case 45:
			this.drawSolutionk(drawingArea, new int[] {nouveauDiametre,nouveauXHaut,nouveauYHaut, prof, 0,nbIteration});
			this.drawSolutionk(drawingArea, new int[] {nouveauDiametre,nouveauXBas,nouveauYBas, prof, 30,nbIteration});
			this.drawSolutionk(drawingArea, new int[] {nouveauDiametre,nouveauXGauche,nouveauYGauche, prof, 45,nbIteration});
		
			break;
		}
		

		

	}
}
