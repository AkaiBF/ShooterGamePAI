import javax.swing.JApplet;

/**
 * Applet for the Shooter Game Bubble-like
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

public class Applet extends JApplet {
	private static final long serialVersionUID = 1L;

	protected final int WIDTH = 1200;
	
	public Applet() {
		super();
	}
	
	public void init() {
		setSize(WIDTH, 500);
		setVisible(true);
		add(new GameScreen(WIDTH));
	}
	
	public void start() {}
	public void stop() {}
	
	public static void main(String args[]) {
		new Window();
	}
}
