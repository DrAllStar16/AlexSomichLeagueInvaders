import java.awt.Color;
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
		f.setColor(Color.YELLOW);

		f.fillRect(x, y, w, h);
	}

}
