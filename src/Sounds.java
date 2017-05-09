import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Game sound library for the Shooter Game
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

public class Sounds {
	/**
	 * Plays a success sound
	 */
	public static void success() {
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("../scifi002.wav").getAbsoluteFile());
			Clip sound = AudioSystem.getClip();
			sound.open(audioStream);
			sound.start();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
	
	/**
	 * Plays an error sound
	 */
	public static void error() {
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("../error.wav").getAbsoluteFile());
			Clip sound = AudioSystem.getClip();
			sound.open(audioStream);
			sound.start();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
