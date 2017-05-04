import javax.swing.*;
public class Window extends JFrame {
	private static final long serialVersionUID = 1L;

	public Window() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200, 500);
		setVisible(true);
		add(new GameScreen());
	}
	
	public static void main(String args[]) {
		new Window();
	}
}
