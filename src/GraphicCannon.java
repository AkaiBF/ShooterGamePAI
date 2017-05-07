import java.awt.Color;
import java.awt.Graphics;

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
