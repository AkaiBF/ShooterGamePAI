/**
 * Set of math functions adapted to the use of degrees and some other trigonometric uses.
 * 
 * Country: Spain
 * University: Universidad de La Laguna
 * Subject: Programación de Aplicaciones Interactivas
 * 
 * @author Ernesto Echeverría González
 * @email alu0100881622@ull.edu.es
 * @since 05-03-2017
 * @version 1.0.0
 */
public class MyMath {
	/**
	 * Calculates the hypotenuse given two cathetus 
	 * @param cathetusA First cathetus size
	 * @param cathetusB Second cathetus size
	 * @return Hypotenuse size
	 */
	public static double hypotenuse(double cathetusA, double cathetusB) {
		return Math.sqrt((cathetusA * cathetusA) + (cathetusB * cathetusB));
	}
	/**
	 * Calculates the cosine of a given angle set in degrees
	 * @param angle Angle in degrees
	 * @return Cosine
	 */
	public static double cos(double angle) {
		return Math.cos(Math.toRadians(angle));
	}
	/**
	 * Calculates the sine of a given angle set in degrees
	 * @param angle Angle in degrees
	 * @return Sine
	 */
	public static double sin(double angle) {
		return Math.sin(Math.toRadians(angle));
	}
	/**
	 * Calculates the angle for the cosine given
	 * @param cos Cosine
	 * @return Angle whose cosine is equal to the given cosine
	 */
	public static double arccos(double cos) {
		return Math.toDegrees(Math.acos(cos));
	}
	/**
	 * Calculates the angle for the sine given
	 * @param sin Sine
	 * @return Angle whose sine is equal to the given sine
	 */
	public static double arcsin(double sin) {
		return Math.toDegrees(Math.asin(sin));
	}
}
