
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
