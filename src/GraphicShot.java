import java.awt.Color;
import java.awt.Graphics;

public class GraphicShot extends Shot {

	protected final int RADIUS = 10;
	private Color color;
	
	public GraphicShot(Point initialPoint, double angle, Color color) {
		super(initialPoint, angle);
		this.setColor(color);
		
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public void drawComponent(Graphics graphicObject, int midBottomPointY) {
		graphicObject.drawOval(getPosition().getPositionX() - RADIUS,
				 midBottomPointY - getPosition().getPositionY() - RADIUS,
				 2 * RADIUS,
				 2 * RADIUS);
	}

}
