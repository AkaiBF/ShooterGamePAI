import javax.swing.*;

/**
 * JFrame used to show the Bubble-like game
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

public class Window extends JFrame {
	private static final long serialVersionUID = 1L;

	protected final int WIDTH = 1200;
	
	public Window() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, 500);
		setVisible(true);
		add(new GameScreen(WIDTH));
	}
	
	public static void main(String args[]) {
		new Window();
	}
}
