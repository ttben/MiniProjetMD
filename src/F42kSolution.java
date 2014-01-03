import java.awt.Color;
import java.awt.Graphics;


public class F42kSolution extends AbstractSolution {
	
	public F42kSolution(int profondeur) {
		super(profondeur);
	}
	
	@Override
	public void drawSolutionk(Graphics drawingArea, int... arg) {
		
		int ancienWidth = arg[0];
		int ancienX = arg[1];
		int ancienY = arg[2];
		
		int profondeurRestant = arg[3];
		if(profondeurRestant <= 0) { return; }
		int prof = profondeurRestant;
		
		int orientation = arg[4];
		int iteration = arg[5];
		
		int r = arg[6];
		int g = arg[7];
		int b = arg[8];

		int coef = arg[9];
		
		if (r <= 0 ) {
			r = 0;

		}
		if (g <= 0) {
			g = 0;
		}

		if (b <= 0) {
			b = 0;
		}
		
		
		if (r > 255 ) {
			r = 255;

		}
		if (g > 255 ) {
			g= 255;

		}		
		if (b > 255 ) {
			b = 255;

		}
		
		drawingArea.setColor(new Color(r,g,b));
		drawingArea.drawOval(ancienX, ancienY, ancienWidth,ancienWidth);
		drawingArea.fillOval(ancienX, ancienY, ancienWidth,ancienWidth);
		
		
		int nouveauDiametre = ancienWidth/2;
		
		int nouveauXDroite = ancienX + ancienWidth;
		int nouveauYDroite = (ancienY)+(ancienWidth/2) - nouveauDiametre/2;
		nouveauYDroite += 14 * coef;
		
		int nouveauXBas =(ancienX)+(ancienWidth/2) - nouveauDiametre/2;
		int nouveauYBas = ancienY + ancienWidth;
		nouveauXBas -= 14 *coef;
		
		int nouveauXHaut =(ancienX)+(ancienWidth/2) - nouveauDiametre/2;
		int nouveauYHaut = ancienY - nouveauDiametre;
		nouveauXHaut+= 14 *coef;
		
		int nouveauXGauche =ancienX  - nouveauDiametre;
		int nouveauYGauche = (ancienY)+(ancienWidth/2) - nouveauDiametre/2;
		nouveauYGauche -= 14 *coef;
		
		this.profondeur = profondeurRestant;
		this.profondeur --;
		
		prof = this.profondeur;

		int facteurDegrade = 30;

		int coefExplosion = 16/10;
		
		if(iteration == 0) {
			iteration ++;

			this.drawSolutionk(drawingArea, new int[] {nouveauDiametre,nouveauXHaut,nouveauYHaut, prof, 0,iteration,r+facteurDegrade,g+facteurDegrade,b+facteurDegrade,(coef*coefExplosion)});
			this.drawSolutionk(drawingArea, new int[] {nouveauDiametre,nouveauXDroite,nouveauYDroite, prof,15,iteration,r+facteurDegrade,g+facteurDegrade,b+facteurDegrade,(coef*coefExplosion)});
			this.drawSolutionk(drawingArea, new int[] {nouveauDiametre,nouveauXGauche,nouveauYGauche, prof,45,iteration,r+facteurDegrade,g+facteurDegrade,b+facteurDegrade,(coef*coefExplosion)});
			this.drawSolutionk(drawingArea, new int[] {nouveauDiametre,nouveauXBas,nouveauYBas, prof,30,iteration,r+facteurDegrade,g+facteurDegrade,b+facteurDegrade,(coef*coefExplosion)});
			return;
		}
		
		
		
		
		switch(orientation) {
		case 0:
			this.drawSolutionk(drawingArea, new int[] {nouveauDiametre,nouveauXHaut,nouveauYHaut, prof, 0,iteration,r+facteurDegrade,g,b,(coef*coefExplosion)});
			this.drawSolutionk(drawingArea, new int[] {nouveauDiametre,nouveauXDroite,nouveauYDroite, prof,15,iteration,r+facteurDegrade,g,b,(coef*coefExplosion)});
			this.drawSolutionk(drawingArea, new int[] {nouveauDiametre,nouveauXGauche,nouveauYGauche, prof, 45,iteration,r+facteurDegrade,g,b,(coef*coefExplosion)});
		
			break;
		case 15:
			this.drawSolutionk(drawingArea, new int[] {nouveauDiametre,nouveauXBas,nouveauYBas, prof,30,iteration,r,g+facteurDegrade,b,(coef*coefExplosion)});
			this.drawSolutionk(drawingArea, new int[] {nouveauDiametre,nouveauXHaut,nouveauYHaut, prof,0,iteration,r,g+facteurDegrade,b,(coef*coefExplosion)});
			this.drawSolutionk(drawingArea, new int[] {nouveauDiametre,nouveauXDroite,nouveauYDroite, prof,15,iteration,r,g+facteurDegrade,b,(coef*coefExplosion)});
		
			break;
		case 30:
			this.drawSolutionk(drawingArea, new int[] {nouveauDiametre,nouveauXBas,nouveauYBas, prof,30,iteration,r,g,b+facteurDegrade,(coef*coefExplosion)});
			this.drawSolutionk(drawingArea, new int[] {nouveauDiametre,nouveauXDroite,nouveauYDroite, prof, 15,iteration,r,g,b+facteurDegrade,(coef*coefExplosion)});
			this.drawSolutionk(drawingArea, new int[] {nouveauDiametre,nouveauXGauche,nouveauYGauche, prof, 45,iteration,r,g,b+facteurDegrade,(coef*coefExplosion)});
		
			break;
		case 45:
			this.drawSolutionk(drawingArea, new int[] {nouveauDiametre,nouveauXHaut,nouveauYHaut, prof, 0,iteration,r+facteurDegrade,g+facteurDegrade,b+facteurDegrade,(coef*coefExplosion)});
			this.drawSolutionk(drawingArea, new int[] {nouveauDiametre,nouveauXBas,nouveauYBas, prof, 30,iteration,r+facteurDegrade,g+facteurDegrade,b+facteurDegrade,(coef*coefExplosion)});
			this.drawSolutionk(drawingArea, new int[] {nouveauDiametre,nouveauXGauche,nouveauYGauche, prof, 45,iteration,r+facteurDegrade,g+facteurDegrade,b+facteurDegrade,(coef*coefExplosion)});
		
			break;
		}

	}
}
