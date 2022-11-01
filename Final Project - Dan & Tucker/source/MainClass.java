import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MainClass {
    private static JFrame frame;

	/**
	 * Main method. You will not need to modify this class
	 * @param args
	 */
	public static void main(String[] args) {
        frame = new JFrame();

        // Creates the display and runs it
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
				new IDPanel(frame).setVisible(true);
            }
        });
    }

}
