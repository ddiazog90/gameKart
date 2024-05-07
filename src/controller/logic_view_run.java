package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import patron_v_10.archivos;
import view.view_run;
import view.lienzo;
import view.view_play;


public class logic_view_run implements ActionListener,configurable, KeyListener{

	private view_run vr;//Declaracion de la clase view_run
	private view_play vp;//Declaracion de la clase view_play
	private lienzo lienzo;//Declarar la clase lienzo
	private int cont=0;
	private boolean flag=false;//controlar la salida del vehiculo
	private Thread begin;//Carros del computador
	private proceso_carrera car1,car2, car3;//Jugador 
	private archivos file;//permite trabajar con los archivos
	private String play;//obtiene el nombre del jugador


	public logic_view_run(view_run vr) {
		super();
		this.vr = vr;
		this.vp=new view_play();
		this.vr.btn_pause.addActionListener(this);
		this.vr.btn_start.addActionListener(this);
		this.vr.btn_resume.addActionListener(this);
		this.vr.btn_start.addKeyListener(this);
		this.vr.btn_play.addActionListener(this);
		this.lienzo=vr.pn_lienzo;//Instanciar la clase lienzo
		this.file=new archivos(ruta_play);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==vr.btn_play) {
			vp.setVisible(true);
			proceso_audio audio=new proceso_audio("src/multimedia/audio/mario-kart.wav");
			audio.start();
			
		}else if(e.getSource()==vr.btn_pause) {
			
//			car1.suspend();
//			car2.suspend();
//			car3.suspend();
		}else if(e.getSource()==vr.btn_start) {
//			msg(vr,"START");
//			vr.btn_start.setEnabled(false);//bloqueo de start
		
			try {
				play=file.readerFile().split("\n")[0];
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			inicio();//setear la posición del jugador		
			flag=true;
			begin=new proceso_begin(lienzo);
			play_winner pw=new play_winner();
			
			if(play.equals("mario_play")) {
				car1=new proceso_carrera("mario_play",lienzo,vr,pw);
			}else {
				car1=new proceso_carrera("mario_kart",lienzo,vr,pw);
			}
			
			if(play.equals("peach_play")) {
				car2=new proceso_carrera("peach_play",lienzo,vr,pw);
			}else {
				car2=new proceso_carrera("peach_kart",lienzo,vr,pw);
			}
			
			if(play.equals("yoshi_play")) {
				car3=new proceso_carrera("yoshi_play",lienzo,vr,pw);
			}else {
				car3=new proceso_carrera("yoshi_kart",lienzo,vr,pw);
			}
						
			
//			car1=new proceso_carrera("mario_kart",lienzo,vr);
//			car2=new proceso_carrera("monkey_kart",lienzo,vr);
//			car3=new proceso_carrera("yoshi_kart",lienzo,vr);
//			
			begin.start();
			car1.start();
			car2.start();
			car3.start();
			
			
			
		}else if(e.getSource()==vr.btn_resume) {
//			msg(vr,"RESUME");
			car1.resume();
			car2.resume();
			car3.resume();
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==e.VK_RIGHT && flag) {
			switch(play) {
			case "mario_play"->car1.setValJugador(1);
			case "peach_play"->car2.setValJugador(1);
			case "yoshi_play"->car3.setValJugador(1);
			}
			
		}else if(e.getKeyCode()==e.VK_T) {
			if(Integer.parseInt(vr.lbl_turbo.getText())>0) {
				switch(play) {
				case "mario_play"->car1.setValJugador(100);
				case "peach_play"->car2.setValJugador(100);
				case "yoshi_play"->car3.setValJugador(100);
				}
				
				vr.lbl_turbo.setText(String.valueOf(Integer.parseInt(vr.lbl_turbo.getText())-1));
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private void inicio() {
		cont=0;
		this.lienzo.setX3(cont);
	}
	

}
