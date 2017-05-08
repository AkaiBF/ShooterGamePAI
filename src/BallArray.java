import java.awt.Color;
import java.util.*;

/**
 * Array of colored balls
 * 
 * Country: Spain
 * University: Universidad de La Laguna
 * Subject: Programación de Aplicaciones Interactivas
 * Repository: https://github.com/AkaiBF/ShooterGamePAI
 * 
 * @author Ernesto Echeverría González
 * @email alu0100881622@ull.edu.es
 * @since 05-03-2017
 * @version 1.0.0
 */
public class BallArray {
	private ArrayList<Ball> balls;
	/**
	 * 
	 * @return An ArrayList of all colors that the set of balls has.
	 */
	public ArrayList<Color> getColors() {
		ArrayList<Color> colors = new ArrayList<Color>();
		for(Ball i: getBalls()) {
			colors.add(i.getColor());
		}
		return colors;
	}
	public ArrayList<Ball> getBalls() {
		return balls;
	}

	public void setBalls(ArrayList<Ball> balls) {
		this.balls = balls;
	}
}
