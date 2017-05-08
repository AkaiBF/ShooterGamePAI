import java.awt.Color;
import java.awt.Graphics;
/**
 * Abstraction of a printable cannon shot
 * 
 * Country: Spain
 * University: Universidad de La Laguna
 * Subject: Programación de Aplicaciones Interactivas
 * Repository: https://github.com/AkaiBF/ShooterGamePAI
 * 
 * @author Ernesto Echeverría González
 * @email alu0100881622@ull.edu.es
 * @since 05-08-2017
 * @version 1.0.0
 */

public class GraphicCannon extends Cannon {

	protected final int SIZE = 30;
	protected final int RADIUS = 10;
	protected final Color COLOR = Color.BLACK;
	private Color nextShot;
	public GraphicCannon() {
		super();
		nextShot = null;
	}
	public void drawComponent(Graphics graphicObject, int midBottomPointX, int midBottomPointY) {
		graphicObject.setColor(COLOR);
		graphicObject.drawOval(midBottomPointX - RADIUS, midBottomPointY - RADIUS, 2 * RADIUS, 2 * RADIUS);
		if(getNextShot() != null) {
			graphicObject.setColor(getNextShot());
			graphicObject.fillOval(midBottomPointX - RADIUS, midBottomPointY - RADIUS, 2 * RADIUS, 2 * RADIUS);
			graphicObject.setColor(COLOR);
		}
		graphicObject.drawLine(midBottomPointX, 
													 midBottomPointY, 
													 (int)(midBottomPointX + SIZE * MyMath.cos(getAngle())), 
													 (int)(midBottomPointY - SIZE * MyMath.sin(getAngle())));
		
	}
	public Color getNextShot() {
		return nextShot;
	}
	public void setNextShot(Color nextShot) {
		this.nextShot = nextShot;
	}
	
}
