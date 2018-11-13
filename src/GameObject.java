import java.awt.Graphics;

public class GameObject {
	int x;
	int y;
	int width;
	int height;

	public GameObject() {
		x = 0;
		y = 0;
		width = 0;
		height = 0;

	}

	public void update() {
		x++;
		y++;
	}

	public void draw(Graphics h) {
		h.fillRect(x, y, 100, 100);

	}
}
