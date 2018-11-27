import java.awt.Color;
import java.awt.Graphics;

public class RocketShip extends GameObject {
	int speed;

	public RocketShip(int x, int y, int w, int h) {
		super(x, y, w, h);
		speed = 5;
	}

	public void update() {

	}

	public void draw(Graphics d) {
		d.setColor(Color.BLUE);

		d.fillRect(x, y, w, h);
	}
}
