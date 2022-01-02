package comRealtutsgmlSrcObjects;

import comRrealtutsgmlSrc.GlobalPosition;
import comRrealtutsgmlSrc.MainClass;
import java.awt.Rectangle;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Enemy extends GlobalPosition{
	
	private String image = "\\enemy.png";

	int speed = 10;
	
	public Enemy(int x, int y) {
		super(x, y);

	}

	public void update() {
		x+=speed;
		if (x>MainClass.WIDTH-32) {
			speed=-5;
		}
		if (x<0) {
			speed=5;
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,32,32);
	}
	
	
	public void draw(Graphics2D g2d) {
		g2d.drawImage(getEnemyImage(),x,y,null);
	}
	
	public Image getEnemyImage() {
		ImageIcon i = new ImageIcon(getClass().getResource(image));
		return i.getImage();
	}
	
	
	
}
