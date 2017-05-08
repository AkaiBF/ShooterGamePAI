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


public class GraphicShot extends Shot {
	private Color color;
	
	public GraphicShot(Point initialPoint, double angle, Color color, int radius) {
		super(initialPoint, angle, radius);
		this.setColor(color);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public void drawComponent(Graphics graphicObject, int midBottomPointY) {
		graphicObject.setColor(getColor());
		graphicObject.fillOval(getPosition().getPositionX() - getRadius(),
				 midBottomPointY - getPosition().getPositionY() - getRadius(),
				 2 * getRadius(),
				 2 * getRadius());
	}
	public boolean impact(GraphicBall ball, int jPanelHeight) {
		int ballX = ball.getPositionX();
		int ballY = ball.getRadius();
		int shotX = this.getPosition().getPositionX();
		int shotY = jPanelHeight - this.getPosition().getPositionY();
		int distance = (int)MyMath.hypotenuse(ballX - shotX, ballY - shotY);
		return (distance <= (ball.getRadius() + getRadius()));
	}
	

}
