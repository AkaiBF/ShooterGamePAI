import java.awt.Color;
import java.awt.Graphics;

public class GraphicCannon extends Cannon {

	protected final int SIZE = 30;
	protected final int RADIUS = 10;
	protected final Color COLOR = Color.BLACK;
	
	public GraphicCannon() {
		super();
	}
	public void drawComponent(Graphics graphicObject, int midBottomPointX, int midBottomPointY) {
		graphicObject.setColor(COLOR);
		graphicObject.drawOval(midBottomPointX - RADIUS, midBottomPointY - RADIUS, 2 * RADIUS, 2 * RADIUS);
		graphicObject.drawLine(midBottomPointX, 
													 midBottomPointY, 
													 (int)(midBottomPointX + SIZE * MyMath.cos(getAngle())), 
													 (int)(midBottomPointY - SIZE * MyMath.sin(getAngle())));
		
	}

}
