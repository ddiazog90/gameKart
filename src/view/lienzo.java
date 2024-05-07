package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import patron_v_10.archivos;

public class lienzo extends JPanel{

	private int x1=0, x2=0, x3=0;
	private Color color1=Color.white, color2=Color.white, color3=Color.white;
	private String winner_photo="", banner_photo="";
	private archivos file;
	
	public void setWinner_photo(String winner_photo) {
		this.winner_photo = winner_photo;
	}

	public void setColor1(Color color1) {
		this.color1 = color1;
	}

	public void setColor2(Color color2) {
		this.color2 = color2;
	}

	public void setColor3(Color color3) {
		this.color3 = color3;
	}
	public void setX1(int x1) {
		
		this.x1 = x1;
	}
	public void setX2(int x2) {
		
		this.x2 = x2;
	}
	public void setX3(int x3) {
		
		this.x3 = x3;
	}
	public lienzo() {
		this.setBounds(0,0,592,358);
		file=new archivos("src/data/play");
		try {
			banner_photo=file.readerFile().split("\n")[0];
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		repaint();
	}
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.magenta);
		g.setFont(new Font("Comic",Font.BOLD,20));
		g.drawString("COMPETENCIA DE CARROS DE MARIO KART", 350, 20);
		int [] posYpista= {30,180,320,480};
		int [] posXpista= {115,1060,1070,1220};
		g.setColor(Color.black);
		for(int linea=0;linea<4;linea++) {
			g.fillRect(10,posYpista[linea] , 1220, 5);
			g.fillRect(posXpista[linea], 30, 10, 454);
		}
		g.setColor(color1);
		g.fillOval(10, 60, 100, 100);
		
		ImageIcon car1=new ImageIcon("src/multimedia/mario_kart_sf.png");
		g.drawImage(car1.getImage(), (10+x1), 60, 100, 100, null);
		
		g.setColor(color2);
		g.fillOval(10, 200, 100, 100);
		
		ImageIcon car2=new ImageIcon("src/multimedia/peach_kart_sf.png");
		g.drawImage(car2.getImage(), (10+x2), 200, 100, 100, null);
		
		g.setColor(color3);
		g.fillOval(10, 360, 100, 100);
		
		ImageIcon car3=new ImageIcon("src/multimedia/yoshi_kart_sf.png");
		g.drawImage(car3.getImage(), (10+x3), 360, 100, 100, null);
		
		
		ImageIcon img=new ImageIcon("src/multimedia/fondo_bandera.jpg");
		g.drawImage(img.getImage(), 0, 494, 1277, 200, null);
		
		ImageIcon banner1=new ImageIcon("src/multimedia/mario_banner.png");
		g.drawImage(banner1.getImage(), 810, 550, 100, 100, null);
		
		ImageIcon banner2=new ImageIcon("src/multimedia/peach_banner.png");
		g.drawImage(banner2.getImage(), 920, 550, 100, 100, null);
		
		ImageIcon banner3=new ImageIcon("src/multimedia/yoshi_banner.png");
		g.drawImage(banner3.getImage(), 1030, 550, 100, 100, null);
		
		if(!winner_photo.equals("")) {
			g.setColor(Color.ORANGE);
			g.setFont(new Font("Comic",Font.BOLD,50));
			g.drawString("WIN!!!"+winner_photo, 400, 150);
			ImageIcon winner=new ImageIcon("src/multimedia/"+winner_photo+".png");
			g.drawImage(winner.getImage(), 400, 200, 400, 400, null);
		}
		
//		if(!banner_photo.equals("")) {
//			ImageIcon banner=new ImageIcon("src/multimedia/"+banner_photo+".png");
//			g.drawImage(banner.getImage(), 1000, 500, 180, 180, null);
//		}
	}

	public void setBanner_photo(String banner_photo) {
		this.banner_photo = banner_photo;
	}
}
