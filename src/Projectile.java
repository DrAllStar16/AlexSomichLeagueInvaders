import java.awt.Graphics;

public class Projectile extends GameObject {
	int speed;

	public Projectile(int x, int y, int w, int h) {
		super(x, y, w, h);
		speed = 10;
	}

	public void update() {
		super.update();
		y -= speed;
		if (y < 0) {
			isAlive = false;
		}
	}

	public void draw(Graphics f) {
		f.drawImage(GamePanel.bulletImg, x, y, w, h, null);
	}
}
