import java.awt.*;

/**
 * Abstraction of a colored ball
 * 
 * Country: Spain
 * University: Universidad de La Laguna
 * Subject: Programación de Aplicaciones Interactivas
 * Repository: https://github.com/AkaiBF/ShooterGamePAI
 * 
 * @author Ernesto Echeverría González
 * @email alu0100881622@ull.edu.es
 * @since 05-03-2017
 * @version 1.0.0
 */

public class Ball {
	protected int DEFAULTRADIUS = 20;
	
	private Color color;							// Ball's color
	private int radius;								// Ball's radius
	private int positionX;						// Ball's position
	
	public Ball() {
		int red = (int)(Math.random() * 255);
		int green = (int)(Math.random() * 255);
		int blue = (int)(Math.random() * 255);
		setColor(new Color(red, green, blue));
		setRadius(DEFAULTRADIUS);
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public int getPositionX() {
		return positionX;
	}
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
}
