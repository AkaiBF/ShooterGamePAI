import java.applet.AudioClip;

import javax.swing.JApplet;

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
	public void start() {
		/*AudioClip audio = Applet.newAudioClip(getClass().getResource("scifi002.wav"));
		try {
			audio.play();
		} catch(Exception exception) {
			System.out.println("File not found");
		}*/
		
		
	}
	public void stop() {
		
	}
}
