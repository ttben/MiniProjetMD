import java.awt.Color;
import java.awt.Graphics;


public class FkSolution extends AbstractSolution {

	
	public FkSolution(int profondeur) {
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
		drawingArea.setColor(new Color(219,124,200));
		drawingArea.fillOval(ancienX, ancienY, ancienDiametre,ancienDiametre);
		drawingArea.setColor(oldColor);
		
		
		//	Recalculer l'ensemble des nouvelles valeurs
		int nouveauDiametre = ancienDiametre/2;
		
		int nouveauXDroite = ancienX + ancienDiametre;
		int nouveauYDroite = (ancienY)+(ancienDiametre/2) - nouveauDiametre/2;
		
		int nouveauXBas =(ancienX)+(ancienDiametre/2) - nouveauDiametre/2;
		int nouveauYBas = ancienY + ancienDiametre;
		
		
		//	Créer une copie de la profondeur restante
		int prof = this.profondeur;

		
		//	Générer deux récursions (horizontale et verticale)
		this.drawSolutionk(drawingArea, new int[] {nouveauDiametre,nouveauXBas,nouveauYBas, prof});
		this.drawSolutionk(drawingArea, new int[] {nouveauDiametre,nouveauXDroite,nouveauYDroite, prof });

	}

}
