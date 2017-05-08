
/**
 * Abstraction of a cannon shot
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

public class Shot {
	private Point initialPoint;							// Cannon position
	private int radius;											// Radius of the cannon ball
	private double angle;										// Angle the cannon had when the shot was launched
	private double time;										// Time passed since launching
	
	protected final int SPEED = 3;					// Speed of the projectile
	
	public Shot(Point initialPoint, double angle, int radius) {
		this.initialPoint = initialPoint;
		this.angle = angle;
		this.radius = radius;
	}
	/**
	 * Calculates the position of the shot for the time since it was launched 
	 * @return The position of the shot
	 */
	public Point getPosition() {
		int positionX = getInitialPoint().getPositionX() + (int)(SPEED * getTime() * MyMath.cos(getAngle()));
		int positionY = getInitialPoint().getPositionY() + (int)(SPEED * getTime() * MyMath.sin(getAngle()));
		return new Point(positionX, positionY);
	}
	
	@Override
	public boolean equals(Object object) {
		Shot shot = (Shot)object;
		if(this.getInitialPoint().equals(shot.getInitialPoint()) 
				&& this.getAngle() == shot.getAngle()
				&& this.getTime() == shot.getTime())
			return true;
		return false;
	}
	@Override
	public int hashCode() {
		return (int)(getAngle() + getTime());
	}
	
	// Getters & Setters
	public Point getInitialPoint() {
		return initialPoint;
	}
	public void setInitialPoint(Point initialPoint) {
		this.initialPoint = initialPoint;
	}
	public double getAngle() {
		return angle;
	}
	public void setAngle(double angle) {
		this.angle = angle;
	}
	public double getTime() {
		return time;
	}
	public void setTime(double time) {
		this.time = time;
	}
	public void advance(double timeLapse) {
		setTime(getTime() + timeLapse);
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
}
