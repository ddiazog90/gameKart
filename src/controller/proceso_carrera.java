//package controller;
//import java.io.IOException;
//
//import javax.swing.JOptionPane;
//
//import patron_v_10.archivos;
//import view.lienzo;
//import view.view_run;
//public class proceso_carrera extends Thread {
//	
//	private lienzo lienzo;
//	private int cont=0, jug=0;
//	private view_run vr;
//	private archivos file;
//	
//	private Thread audio;//Permite cargar el audio
//	public proceso_carrera(String car,lienzo lienzo,view_run vr) {
//		super(car);
//		this.lienzo=lienzo;
//		this.vr=vr;
//		file=new archivos("src/data/winners.txt");
//		try {
//			file.writerFile("",true);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	private int valor() {
//		cont+=(int)(Math.random()*30);
//		return cont;
//	}
//	
//	public void run() {
//		try {
//			sleep(5000);
//			if(getName()=="mario_kart") {
//				audio=new Thread(new proceso_audio("src/multimedia/audio/kart-mario.wav"));
//				audio.start();
//			}
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		for(int i=0;i<70;i++) {
//			switch(getName()) {
//			case "mario_kart"->lienzo.setX1(valor());
//			case "monkey_kart"->lienzo.setX2(valor());
//			case "yoshi_kart"->lienzo.setX3(jug);			
//			}
//			lienzo.repaint();
//			try {
//				sleep(500);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
////		vr.btn_start.setEnabled(true);//activar el boton start
//		try {
//			
//			file.writerFile(getName(), false);
//			String [] win=file.readerFile().split("\n");
//			JOptionPane.showMessageDialog(lienzo,"WIN "+win[1]);
//			lienzo.setX1(0);
//			lienzo.setX2(0);
//			lienzo.setX3(0);
//			lienzo.repaint();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//	}
//	
//	public void setValJugador(int val) {
//		this.jug=val;
//	}
//
//}
package controller;
import java.io.IOException;

import javax.swing.JOptionPane;

import patron_v_10.archivos;
import view.lienzo;
import view.view_run;
public class proceso_carrera extends Thread {
	
	private lienzo lienzo;
	private int cont=0, jugador=0;
	private view_run vr;
	private archivos file;
	private proceso_timer timer;
	private proceso_audio audio;
	private play_winner pw;
	
	public proceso_carrera(String car,lienzo lienzo,view_run vr, play_winner pw) {
		super(car);
		this.lienzo=lienzo;
		this.vr=vr;
		this.pw=pw;
		file=new archivos("src/data/winner.txt");
		if(file.getFile().exists()) {
			file.getFile().delete();
		}
//		try {
//			file.writerFile("WINNERS",true);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	private int valor() {
		if(cont<1080)
			cont+=(int)(Math.random()*50);
		return cont;
	}
	
	public void run() {
		try {
			sleep(5000);//tiempo de espera para los vehiculos
			if(getName().split("_")[0].equals("mario")) {
				audio=new proceso_audio("src/multimedia/audio/kart-mario.wav");
				timer=new proceso_timer(vr);
				timer.start();
				audio.start();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<45;i++) {
			switch(getName()) {
			case "mario_kart"->lienzo.setX1(valor());
			case "peach_kart"->lienzo.setX2(valor());
			case "yoshi_kart"->lienzo.setX3(valor());			
			case "mario_play"->lienzo.setX1(jugador);
			case "peach_play"->lienzo.setX2(jugador);
			case "yoshi_play"->lienzo.setX3(jugador);
			}
			lienzo.repaint();
			try {
				sleep((int)(Math.random()*1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(jugador>=1072 || cont>=1072) {
				break;//interrupe el bucle
			}
		}
//		vr.btn_start.setEnabled(true);//activar el boton start
		try {
			if(getName().split("_")[0].equals("mario")) {
				timer.setFinished(true);//finaliza el timer
			}
			
			//file.writerFile(getName(), false);
			
			pw.saveWinner(getName(),vr.lbl_min.getText()+":"+vr.lbl_seg.getText());
			String win=file.readerFile().split("\n")[0];
			lienzo.setWinner_photo(win.split("_")[0]+"_winner");
			proceso_audio audio_winner=new proceso_audio("src/multimedia/audio/kart1-mario-kart.wav");
			audio_winner.start();
			
			sleep(10000);//para limpiar los campos
			if(this.isAlive()) {
				lienzo.setX1(0);
				lienzo.setX2(0);
				lienzo.setX3(0);
				lienzo.setWinner_photo("");
				lienzo.repaint();
				vr.lbl_min.setText("00");
				vr.lbl_seg.setText("00");
				vr.lbl_turbo.setText("4");
				if(file.getFile().exists()) {
					file.getFile().delete();
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void setValJugador(int val) {
		if(jugador<1080)
			this.jugador+=val;
	}

}

