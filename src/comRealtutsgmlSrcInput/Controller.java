package comRealtutsgmlSrcInput;

import java.util.LinkedList;

import comRealtutsgmlSrcObjects.Enemy;
import java.awt.Graphics2D;

public class Controller {

	static LinkedList<Enemy> e = new LinkedList<Enemy>();
	
	Enemy TempEnemy;
	
	public Controller() {
		addEnemy(new Enemy(100,100));
		addEnemy(new Enemy(200,100));
		addEnemy(new Enemy(300,100));
		addEnemy(new Enemy(100,300));
		addEnemy(new Enemy(100,200));
		addEnemy(new Enemy(200,200));
	}
	
	public void draw(Graphics2D g2d) {
		for (int i = 0; i < e.size(); i++) {
			TempEnemy=e.get(i);
			TempEnemy.draw(g2d);
		}
	}
	
	public void update() {
		for (int i = 0; i < e.size(); i++) {
			TempEnemy =e.get(i);			
			TempEnemy.update();
		}
	}
	
	public void addEnemy(Enemy enemy) {
		e.add(enemy);
	}
	
	public void removeEnemy(Enemy enemy) {
		e.remove(enemy);
	}
	
	public static LinkedList<Enemy>getEnemyBounds(){
		return e;
	}
	
	
}
