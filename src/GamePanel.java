import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer t;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont;

	GamePanel() {
		t = new Timer(1000 / 60, this);
		titleFont = new Font("HanziPen SC", Font.ITALIC, 48);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (currentState == MENU_STATE) {

			updateMenuState();

		} else if (currentState == GAME_STATE) {

			updateGameState();

		} else if (currentState == END_STATE) {

			updateEndState();

		}
		repaint();
	}

	public void updateMenuState() {

	}

	public void updateGameState() {

	}

	public void updateEndState() {

	}

	public void drawMenuState(Graphics a) {
		a.setColor(Color.BLUE);
		a.fillRect(0, 0, LeagueInvaders.w, LeagueInvaders.h);
	}

	public void drawGameState(Graphics b) {
		b.setColor(Color.black);
		b.fillRect(0, 0, LeagueInvaders.w, LeagueInvaders.h);
	}

	public void drawEndState(Graphics c) {
		c.setColor(Color.red);
		c.fillRect(0, 0, LeagueInvaders.w, LeagueInvaders.h);
	}

	void startGame() {
		t.start();

	}

	@Override

	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {

			drawMenuState(g);

		} else if (currentState == GAME_STATE) {

			drawGameState(g);

		} else if (currentState == END_STATE) {

			drawEndState(g);

		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (KeyEvent.VK_ENTER == e.getKeyCode()) {
			currentState++;
			if (currentState > END_STATE) {
				currentState = MENU_STATE;
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}
