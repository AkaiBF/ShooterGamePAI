import java.awt.Graphics;

public class GraphicBall extends Ball {
	public GraphicBall() {
		super();
	}
	
	public void drawComponent(Graphics graphicObject, int counter) {
		graphicObject.setColor(getColor());
		graphicObject.fillOval(counter, 0, getRadius() * 2, getRadius() * 2);
	}

}
