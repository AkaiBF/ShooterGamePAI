import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;

public class GameScreen extends JPanel implements KeyListener, MouseListener, MouseMotionListener {
	private static final long serialVersionUID = 1L;
	
	protected final int CANNONSIZE = 30;
	protected final int CANNONRADIUS = 10;
	protected final double TIMELAPSE = 1;
	
	private GraphicCannon cannon;
	private ArrayList<GraphicShot> shots;
	private ArrayList<GraphicBall> balls;

	private AudioClip audio;
	
	public GameScreen() {
		super();
		try {
			audio = Applet.newAudioClip(getClass().getResource("D:/Eclipse/workspace/Shooter/scifi002.wav"));
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		cannon = new GraphicCannon();
		shots = new ArrayList<GraphicShot>();
		balls = new ArrayList<GraphicBall>();
		for(int i = 0; i < 40; i++) 
			balls.add(new GraphicBall());
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
		for(GraphicBall i: getBalls()) {
			i.drawComponent(graphicObject, counter);
			counter += 40;
		}
		
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
	
	public GraphicCannon getCannon() {
		return cannon;
	}

	public void setCannon(GraphicCannon cannon) {
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
		getShots().add(new GraphicShot(new Point(circleX, circleY), angle, Color.GREEN));
		getCannon().setNextShot(getBalls().get((int)(Math.random() * getBalls().size())).getColor());
		audio.play();
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
	
}
