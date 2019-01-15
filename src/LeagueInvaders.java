import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame f;
	static final int w = 500;
	static final int h = 800;
	GamePanel GP;

	public static void main(String[] args) {
		LeagueInvaders o = new LeagueInvaders();

	}

	LeagueInvaders() {
		f = new JFrame();
		GP = new GamePanel();
		setup();
		f.getContentPane().setPreferredSize(new Dimension(w, h));
		f.pack();
		f.setVisible(true);

	}

	void setup() {
		f.add(GP);
		f.addKeyListener(GP);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GP.startGame();
	}
}
