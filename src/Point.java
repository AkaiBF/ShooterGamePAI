
/**
 * Abstraction of a coordinate point
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

public class Point {
	private int positionX;
	private int positionY;
	
	public Point(int positionX, int positionY) {
		this.setPositionX(positionX);
		this.setPositionY(positionY);
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	
	public boolean equals(Object object) {
		Point point = (Point)object;
		if(this.getPositionX() == point.getPositionX() && this.getPositionY() == point.getPositionY())
			return true;
		return false;
	}
}
