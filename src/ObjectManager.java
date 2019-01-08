import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	RocketShip rs;
	ArrayList<Projectile> pro = new ArrayList<Projectile>();
	ArrayList<Alien> ali = new ArrayList<Alien>();
	long enemyTimer = 0;
	int enemySpawnTime = 1000;
	int score = 0;

	int getScore() {
		return this.score;
	}

	public ObjectManager(RocketShip rs) {
		this.rs = rs;

	}

	public void update() {
		rs.update();
		for (int i = 0; i < pro.size(); i++) {
			pro.get(i).update();
		}
		for (int h = 0; h < ali.size(); h++) {
			ali.get(h).update();
		}
	}

	public void draw(Graphics e) {
		rs.draw(e);
		for (int i = 0; i < pro.size(); i++) {
			pro.get(i).draw(e);
		}
		for (int h = 0; h < ali.size(); h++) {
			ali.get(h).draw(e);
		}
	}

	public void addProjectile(Projectile p) {
		pro.add(p);
	}

	public void addAlien(Alien a) {
		ali.add(a);
	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Alien(new Random().nextInt(LeagueInvaders.w), 0, 50, 50));

			enemyTimer = System.currentTimeMillis();
		}
	}

	public void purgeObjects() {
		for (int i = 0; i < ali.size(); i++) {
			if (!ali.get(i).isAlive) {
				ali.remove(i);
			}

		}
		for (int h = 0; h < pro.size(); h++) {
			if (!pro.get(h).isAlive) {
				pro.remove(h);
			}

		}

		if (rs.isAlive == false) {
			GamePanel.currentState = GamePanel.END_STATE;
			ali = new ArrayList<Alien>();
			pro = new ArrayList<Projectile>();
			rs.resetRocket();
		}

	}

	public void checkCollision() {

		for (Alien a : ali) {

			if (rs.collisionBox.intersects(a.collisionBox)) {

				rs.isAlive = false;

			}

			for (Projectile b : pro) {

				if (a.collisionBox.intersects(b.collisionBox)) {
					score++;
					a.isAlive = false;
				}

			}

		}

	}

}
