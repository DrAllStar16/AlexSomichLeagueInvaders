import java.awt.Graphics;

public class ObjectManager {
	RocketShip rs;

	public ObjectManager(RocketShip rs) {
		this.rs = rs;
	}

	public void update() {
		rs.update();

	}

	public void draw(Graphics e) {
		rs.draw(e);
	}

}
