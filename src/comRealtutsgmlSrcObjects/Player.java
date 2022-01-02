package comRealtutsgmlSrcObjects;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

import comRealtutsgmlSrcInput.Controller;
import comRrealtutsgmlSrc.GlobalPosition;
import java.awt.Graphics2D;

public class Player extends GlobalPosition{//burda hareketlerimizi ve resimleri import ettik
	private int velX=0,velY=0;
	private String playerimage = "\\player.png";
	
	private LinkedList<Enemy>e = Controller.getEnemyBounds();
	
	public Player(int x, int y) {
		super(x, y);
	}

	public void update() {
		x+=velX;
		y+=velY;
		
		//Collision with outside
		if (x<0) {
			x=0;
		}
		if (y<0) {
			y=0;
		}
		if (x>596) {//mainclass'taki setsize'daki olculerden playerin pixel olculerini ve jframe in frame;inin olculerini cikarirsak kalan pixeller bu miktarda oluyor, jframe in olculerini bilmedigim icin deneyerek yaptim
			x=596;
		}
		if (y>415) {
			y=415;
		}
		Collision();
	}
	public void Collision() {
		
		for (int i = 0; i < e.size(); i++) {
			if (getBounds().intersects(e.get(i).getBounds())) {
				System.out.println("COLLISION");
			}
		}
		
		
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key==KeyEvent.VK_RIGHT) {
			velX=5;
		}else if (key==KeyEvent.VK_LEFT) {//VirtualKeycode
			velX=-5;
		}else if (key==KeyEvent.VK_DOWN) {
			velY=5;
		}else if (key==KeyEvent.VK_UP) {
			velY=-5;
		}
		
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key==KeyEvent.VK_RIGHT) {
			velX=0;
		}else if (key==KeyEvent.VK_LEFT) {//VirtualKeycode
			velX=0;
		}else if (key==KeyEvent.VK_DOWN) {
			velY=0;
		}else if (key==KeyEvent.VK_UP) {
			velY=0;
		}
	}
	
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,27,26);
	}
	
	public void draw(Graphics2D g2d) {
		g2d.drawImage(getPlayerImage(),x,y,null);
		g2d.draw(getBounds());
	}

	public Image getPlayerImage() {
		ImageIcon i = new ImageIcon(getClass().getResource(playerimage));
		return i.getImage();
	}

}
