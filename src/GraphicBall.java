import java.awt.Graphics;

/**
 * Abstraction of a printable colored ball
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

public class GraphicBall extends Ball {
	public GraphicBall() {
		super();
	}
	
	public void drawComponent(Graphics graphicObject) {
		graphicObject.setColor(getColor());
		graphicObject.fillOval(getPositionX(), 0, getRadius() * 2, getRadius() * 2);
	}

}
