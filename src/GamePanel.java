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
	Font GameOverFont;
	RocketShip RS;
	ObjectManager OM;

	public GamePanel() {
		t = new Timer(1000 / 60, this);
		titleFont = new Font("HanziPen SC", Font.ITALIC, 36);
		GameOverFont = new Font("Futura", Font.BOLD, 36);
		RS = new RocketShip(250, 700, 50, 50);
		OM = new ObjectManager(RS);
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
		OM.update();
		OM.manageEnemies();
	}

	public void updateEndState() {

	}

	public void drawMenuState(Graphics a) {
		a.setColor(Color.BLUE);
		a.fillRect(0, 0, LeagueInvaders.w, LeagueInvaders.h);
		a.setFont(titleFont);
		a.setColor(Color.WHITE);
		a.drawString("League Invaders", 130, 40);
		a.drawString("Press ENTER to start", 90, 400);
		a.drawString("Press SPACE for intructions", 50, 700);
	}

	public void drawGameState(Graphics b) {
		b.setColor(Color.black);
		b.fillRect(0, 0, LeagueInvaders.w, LeagueInvaders.h);
		OM.draw(b);
	}

	public void drawEndState(Graphics c) {
		c.setColor(Color.red);
		c.fillRect(0, 0, LeagueInvaders.w, LeagueInvaders.h);
		c.setFont(GameOverFont);
		c.setColor(Color.WHITE);
		c.drawString("Game Over", 140, 40);
		c.drawString("You killed 0 enemies", 50, 400);
		c.drawString("Press ENTER to restart", 40, 700);
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

		if (KeyEvent.VK_UP == e.getKeyCode()) {
			RS.y -= 20;
		} else if (KeyEvent.VK_DOWN == e.getKeyCode()) {
			RS.y += 20;
		}
		if (KeyEvent.VK_LEFT == e.getKeyCode()) {
			RS.x -= 20;
		}
		if (KeyEvent.VK_RIGHT == e.getKeyCode()) {
			RS.x += 20;
		}
		if (KeyEvent.VK_SPACE == e.getKeyCode()) {
			OM.addProjectile(new Projectile(RS.x + 20, RS.y, 10, 10));

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}
