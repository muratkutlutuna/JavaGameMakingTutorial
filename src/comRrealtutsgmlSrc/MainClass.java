package comRrealtutsgmlSrc;

import javax.swing.JFrame;

public class MainClass {
	
	public static final int WIDTH = 640, HEIGHT = 480;
	public static final String TITLE = "Tutorial RealTutsGML";
	
	public static void main(String[] args) {
		JFrame frame = new JFrame(TITLE);//JFrame class ini cagiriyoruz
		frame.pack();//pencereyi paketler
		frame.setSize(WIDTH,HEIGHT);//pencerenin olcusunu ayarlar
		frame.setResizable(false);//pencereni olcusunu degistrmeyi engeller
		frame.setLocationRelativeTo(null);//pencere ortada acilir. Bu kodu yazdigimiz JFrame kodlarinin arasini orta kismina yazmak daha uygun olur
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//ekran i kapattiginda porgram da calismayi birakir
		frame.add(new Game());
		frame.setVisible(true);//pencere gorunur olur
		
		

	}

}
