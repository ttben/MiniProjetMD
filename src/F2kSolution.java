import java.awt.Color;
import java.awt.Graphics;


public class F2kSolution  extends AbstractSolution {

	
	public F2kSolution(int profondeur) {
		super(profondeur);
	}
	
	@Override
	public void drawSolutionk(Graphics drawingArea, int... arg) {
		
		//	Récupérer les paramètres de l'itération
		//	précédente
		int ancienDiametre = arg[0];
		int ancienX = arg[1];
		int ancienY = arg[2];
		int profondeurRestante = arg[3];
		int orientation = arg[4];
		int nbIteration = arg[5];
		
			
		//	Vérifier la condition d'arrêt
		if(profondeurRestante <= 0) { return; }
	

		//	Décrémenter la profondeur restante et
		//	la réassigner
		profondeurRestante --;		
		this.profondeur = profondeurRestante;

		//	Dessiner le cercle courant
		drawingArea.drawOval(ancienX, ancienY, ancienDiametre,ancienDiametre);		

		//	Remplir le cercle courant
		Color oldColor = drawingArea.getColor();
		drawingArea.setColor(new Color(0,255,0));
		drawingArea.fillOval(ancienX, ancienY, ancienDiametre,ancienDiametre);
		drawingArea.setColor(oldColor);
		
		
		//	Recalculer l'ensemble des nouvelles valeurs
		int nouveauDiametre = ancienDiametre/2;
		
		int nouveauXDroite = ancienX + ancienDiametre;
		int nouveauYDroite = (ancienY)+(ancienDiametre/2) - nouveauDiametre/2;
		
		int nouveauXBas =(ancienX)+(ancienDiametre/2) - nouveauDiametre/2;
		int nouveauYBas = ancienY + ancienDiametre;
		
		int nouveauXHaut =(ancienX)+(ancienDiametre/2) - nouveauDiametre/2;
		int nouveauYHaut = ancienY - nouveauDiametre;
		
		int nouveauXGauche =ancienX  - nouveauDiametre;
		int nouveauYGauche = (ancienY)+(ancienDiametre/2) - nouveauDiametre/2;
		
		
		//	Créer une copie de la profondeur restante
		int prof = this.profondeur;

		
		//	Gérer le cas particuler de la toute première itération
		if(nbIteration == 0) {
			nbIteration ++;

			this.drawSolutionk(drawingArea, new int[] {nouveauDiametre,nouveauXHaut,nouveauYHaut, prof, 0,nbIteration});
			this.drawSolutionk(drawingArea, new int[] {nouveauDiametre,nouveauXDroite,nouveauYDroite, prof,15,nbIteration});
			this.drawSolutionk(drawingArea, new int[] {nouveauDiametre,nouveauXGauche,nouveauYGauche, prof,45,nbIteration});
			this.drawSolutionk(drawingArea, new int[] {nouveauDiametre,nouveauXBas,nouveauYBas, prof,30,nbIteration});
			return;
		}
		
		
		//	Générer 3 récursions en traitant le cas des orientations
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
