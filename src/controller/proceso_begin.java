package controller;

import java.awt.Color;

import view.lienzo;
public class proceso_begin extends Thread{
	
	private lienzo lienzo;

	public proceso_begin(view.lienzo lienzo) {
		super();
		this.lienzo = lienzo;
	}
	public void run() {
		proceso_audio audio=new proceso_audio("src/multimedia/audio/kart-start-mario.wav");
		audio.start();
		
		try {
			lienzo.setColor1(Color.red);
			lienzo.repaint();
			sleep(1500);
			lienzo.setColor2(Color.yellow);
			lienzo.repaint();
			sleep(1500);
			lienzo.setColor3(Color.green);
			lienzo.repaint();
			sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}