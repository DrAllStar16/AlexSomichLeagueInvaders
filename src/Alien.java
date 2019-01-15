import java.awt.Graphics;

public class Alien extends GameObject {

	public Alien(int x, int y, int w, int h) {
		super(x, y, w, h);

	}

	public void update() {
		super.update();
		y++;
	}

	public void draw(Graphics f) {
		f.drawImage(GamePanel.alienImg, x, y, w, h, null);
	}

}
