import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;

public class GameScreen extends JPanel implements KeyListener, MouseListener, MouseMotionListener {
	private static final long serialVersionUID = 1L;
	
	protected final int CANNONSIZE = 30;
	protected final int CANNONRADIUS = 10;
	protected final double TIMELAPSE = 1;
	
	private Cannon cannon;
	private ArrayList<Shot> shots;
	private ArrayList<Ball> balls;

	public GameScreen() {
		super();
		cannon = new Cannon();
		shots = new ArrayList<Shot>();
		balls = new ArrayList<Ball>();
		for(int i = 0; i < 40; i++) 
			balls.add(new Ball());
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		setFocusable(true);
		
		ActionListener timerEvent = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				for(Shot i: getShots()) 
					i.advance(TIMELAPSE);
				repaint();
			}
		};
		new Timer((int)(TIMELAPSE * 10), timerEvent).start();
		
	}
	public void paintComponent(Graphics graphicObject) {
		graphicObject.setColor(Color.WHITE);
		graphicObject.fillRect(0, 0, (int)getSize().getWidth(), (int)getSize().getHeight());
		int counter = 0;
		for(Ball i: getBalls()) {
			graphicObject.setColor(i.getColor());
			graphicObject.fillOval(counter, 0, i.getRadius() * 2, i.getRadius() * 2);
			counter += 40;
		}
		
		int midBottomPointX = (int)getSize().getWidth() / 2;
		int midBottomPointY = (int)getSize().getHeight();
		graphicObject.setColor(Color.BLACK);
		graphicObject.drawOval(midBottomPointX - CANNONRADIUS, midBottomPointY - CANNONRADIUS, 2 * CANNONRADIUS, 2 * CANNONRADIUS);
		graphicObject.drawLine(midBottomPointX, 
													 midBottomPointY, 
													 (int)(midBottomPointX + CANNONSIZE * MyMath.cos(getCannon().getAngle())), 
													 (int)(midBottomPointY - CANNONSIZE * MyMath.sin(getCannon().getAngle())));
		graphicObject.setColor(Color.GREEN);
		
		Iterator<Shot> iterator = getShots().iterator();
		while(iterator.hasNext()) {
			Shot i = iterator.next();
			if(midBottomPointY - i.getPosition().getPositionY() <= 0) {
				iterator.remove();
			}
			graphicObject.drawOval(i.getPosition().getPositionX() - CANNONRADIUS,
														 midBottomPointY - i.getPosition().getPositionY() - CANNONRADIUS,
														 2 * CANNONRADIUS,
														 2 * CANNONRADIUS);
		}
		
	}
	public Cannon getCannon() {
		return cannon;
	}

	public void setCannon(Cannon cannon) {
		this.cannon = cannon;
	}
	@Override
	public void keyPressed(KeyEvent evento) {
		if(evento.getKeyCode() == 37)
			getCannon().setAngle(getCannon().getAngle() + 0.5);
		if(evento.getKeyCode() == 39)
			getCannon().setAngle(getCannon().getAngle() - 0.5);
		repaint();
	}
	@Override
	public void mouseMoved(MouseEvent evento) {
		int capturedX = evento.getX() - (int)(getSize().getWidth() / 2);			
		int capturedY = evento.getY() - (int)(getSize().getHeight());
		double hypotenuse = MyMath.hypotenuse(capturedX, capturedY);
		double angle = MyMath.arccos(capturedX / hypotenuse);
		getCannon().setAngle(angle);
		repaint();
	}
	@Override
	public void mousePressed(MouseEvent evento) {
		int capturedX = evento.getX() - (int)(getSize().getWidth() / 2);			
		int capturedY = evento.getY() - (int)(getSize().getHeight());
		double hypotenuse = MyMath.hypotenuse(capturedX, capturedY);
		double angle = MyMath.arccos(capturedX / hypotenuse);
		int circleX = (int)(getSize().getWidth() / 2) + (int)(MyMath.cos(angle) * CANNONSIZE);
		int circleY = (int)(MyMath.sin(angle) * CANNONSIZE);
		getShots().add(new Shot(new Point(circleX, circleY), angle));
		repaint();
	}
	
	
	// Unused events
	@Override
	public void keyReleased(KeyEvent arg0) {}
	@Override
	public void keyTyped(KeyEvent arg0) {}
	@Override
	public void mouseClicked(MouseEvent evento) {}
	@Override
	public void mouseEntered(MouseEvent evento) {}
	@Override
	public void mouseExited(MouseEvent evento) {}
	
	@Override
	public void mouseReleased(MouseEvent evento) {}
	
	@Override
	public void mouseDragged(MouseEvent arg0) {}
	public ArrayList<Shot> getShots() {
		return shots;
	}
	public void setShots(ArrayList<Shot> shots) {
		this.shots = shots;
	}
	public ArrayList<Ball> getBalls() {
		return balls;
	}
	public void setBalls(ArrayList<Ball> balls) {
		this.balls = balls;
	}
	
}
