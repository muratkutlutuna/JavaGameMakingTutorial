package comRrealtutsgmlSrc;

import java.awt.Graphics;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;//bu interface bize actionPerformed u override ettiriyor

import javax.swing.JPanel;
import javax.swing.Timer;

import comRealtutsgmlSrcObjects.Player;

public class Game extends JPanel implements ActionListener   {//bu sekilde pencereyi gorebilecegiz	
	private static final long serialVersionUID = 1L;// Game classi kullanilmadigi icin sari cizgi vardi altinda, ordan kendisine eclipse in onerisi olan seri numara cikarma islemi yaptik

	Timer gamelooptimer;//oyunu kac defa donguye sokacagimizi olcmeye yarar. burda import icin Javax.swing.Timer i ekleyecegiz baska birsey eklersek sorun yasariz
	Player p;
	
	public Game() {
		setFocusable(true);// bu method oyunu calistirir calistirmaz birseye tiklamadan herseyi kontrol edebilmeye yariyor
		
		gamelooptimer = new Timer(10,this);//her 10 milisaniyede bu timer calisacak, burdaki this de bu classi belirtiyor, burda cte vermesinin sebebi implement istemesinden. biz de ActionListener'e implement ediyoruz
		gamelooptimer.start();
		
		p=new Player(200,100);
	}
	
	public void paint (Graphics g) {//this method allow us to paint anything on the screen
		super.paint(g);// parent classin paint methodunu kullandik
		
		Graphics2D g2d = (Graphics2D) g;// graphic data tipini data casting yaptik, graphic2D ye . cunku graphic2D graphicten daha kullanisli
		
		p.draw(g2d);//bu methoda kadar ekranda birsey gozukmez. player datat tipi oldugu icin bu variable ile update draw ve getPlayerImage methodlarina ulasabilirim
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {//bu bizim oyun loopumuz dongumuz, timer'imiz her 10 milisaniyede bu methodu calistiracak// belkide ilerde biz baska timerlar da kuracagiz, mesela oyunu pause yaptirmak icin , ya da oyunda birseyi durdurmak icin
		p.update();//burada update methodunu dongumuzun icine aliyoruz
		repaint();//bu method her 10 milisaniyede yukaridaki paint methodunu calistirir
		
		
		
	}
	
}
