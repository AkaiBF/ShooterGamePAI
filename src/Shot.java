
public class Shot {
	private Point initialPoint;
	private double angle;
	private double time;										// Launching time
	
	protected final int SPEED = 3;
	
	public Shot(Point initialPoint, double angle) {
		this.initialPoint = initialPoint;
		this.angle = angle;
	}
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

	
}
