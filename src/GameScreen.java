import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;

/**
 * Game screen for the Shooter Game Bubble-like
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

public class GameScreen extends JPanel implements KeyListener, MouseListener, MouseMotionListener {
	private static final long serialVersionUID = 1L;
	
	protected final int BALLRADIUS = 40;
	protected final int CANNONSIZE = 30;
	protected final int CANNONRADIUS = 10;
	protected final double TIMELAPSE = 1;
	
	private GraphicCannon cannon;
	private ArrayList<GraphicShot> shots;
	private ArrayList<GraphicBall> balls;

	
	public GameScreen(int width) {
		super();
		cannon = new GraphicCannon();
		shots = new ArrayList<GraphicShot>();
		balls = new ArrayList<GraphicBall>();
		for(int i = 0; i < width / (BALLRADIUS + 1); i++) {
			GraphicBall ball = new GraphicBall();
			ball.setPositionX(i * BALLRADIUS);
			balls.add(ball);
		}
			
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		setFocusable(true);
		
		ActionListener timerEvent = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				ArrayList<GraphicBall> toRemove = new ArrayList<GraphicBall>();
				ArrayList<GraphicShot> removeShot = new ArrayList<GraphicShot>();
				Iterator<GraphicShot> shotIterator = getShots().iterator();
				while(shotIterator.hasNext()) {
					GraphicShot i = shotIterator.next();
					i.advance(TIMELAPSE);
					Iterator<GraphicBall> ballIterator = getBalls().iterator();
					while(ballIterator.hasNext()) {
						GraphicBall j = ballIterator.next();
						if(i.impact(j, (int)getSize().getHeight())) {
							toRemove.add(j);
							removeShot.add(i);
						}
					}
				}
				if(toRemove.size() == 1)
					getBalls().remove(toRemove.get(0));
				for(GraphicShot i: removeShot)
					getShots().remove(i);
				repaint();
			}
		};
		new Timer((int)(TIMELAPSE * 10), timerEvent).start();
		if(getBalls().size() > 0)
			getCannon().setNextShot(getBalls().get((int)(Math.random() * getBalls().size())).getColor());
			else 
				System.out.println("You won");
		
	}
	public void paintComponent(Graphics graphicObject) {
		graphicObject.setColor(Color.WHITE);
		graphicObject.fillRect(0, 0, (int)getSize().getWidth(), (int)getSize().getHeight());
		for(GraphicBall i: getBalls())
			i.drawComponent(graphicObject);
		int midBottomPointX = (int)getSize().getWidth() / 2;
		int midBottomPointY = (int)getSize().getHeight();
		getCannon().drawComponent(graphicObject, midBottomPointX, midBottomPointY);
		Iterator<GraphicShot> iterator = getShots().iterator();
		while(iterator.hasNext()) {
			GraphicShot i = iterator.next();
			if(midBottomPointY - i.getPosition().getPositionY() <= 0) {
				iterator.remove();
			}
			i.drawComponent(graphicObject, midBottomPointY);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent evento) {
		if(evento.getKeyCode() == 37)
			getCannon().setAngle(getCannon().getAngle() + 2);
		if(evento.getKeyCode() == 39)
			getCannon().setAngle(getCannon().getAngle() - 2);
		if(evento.getKeyCode() == KeyEvent.VK_SPACE) {
			int circleX = (int)(getSize().getWidth() / 2) + (int)(MyMath.cos(getCannon().getAngle()) * CANNONSIZE);
			int circleY = (int)(MyMath.sin(getCannon().getAngle()) * CANNONSIZE);
			getShots().add(new GraphicShot(new Point(circleX, circleY), getCannon().getAngle(), getCannon().getNextShot(), CANNONRADIUS));
			if(getBalls().size() > 0)
			getCannon().setNextShot(getBalls().get((int)(Math.random() * getBalls().size())).getColor());
			else 
				System.out.println("You won");
		}
			
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
		getShots().add(new GraphicShot(new Point(circleX, circleY), angle, getCannon().getNextShot(), CANNONRADIUS));
		if(getBalls().size() > 0)
		getCannon().setNextShot(getBalls().get((int)(Math.random() * getBalls().size())).getColor());
		else 
			System.out.println("You won");
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
	
	// Getters & Setters
	public ArrayList<GraphicShot> getShots() {
		return shots;
	}
	public void setShots(ArrayList<GraphicShot> shots) {
		this.shots = shots;
	}
	public ArrayList<GraphicBall> getBalls() {
		return balls;
	}
	public void setBalls(ArrayList<GraphicBall> balls) {
		this.balls = balls;
	}
	public GraphicCannon getCannon() {
		return cannon;
	}
	public void setCannon(GraphicCannon cannon) {
		this.cannon = cannon;
	}
}
