package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import patron_v_10.archivos;
import view.view_play;
import view.lienzo;
public class logic_view_play implements ActionListener, MouseListener, configurable{

	private view_play vp;
	private archivos file;
	private lienzo lienzo;
	
	public logic_view_play(view_play vp) {
		super();
		this.vp = vp;
		this.vp.btn_play1.addActionListener(this);
		this.vp.btn_play2.addActionListener(this);
		this.vp.btn_play3.addActionListener(this);
		this.vp.btn_play1.addMouseListener(this);
		this.vp.btn_play2.addMouseListener(this);
		this.vp.btn_play3.addMouseListener(this);
		file=new archivos(ruta_play);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==vp.btn_play1) {
			selectPlay("mario_play");
			vp.setVisible(false);
		}else if(e.getSource()==vp.btn_play2) {
			selectPlay("peach_play");
			vp.setVisible(false);
		}else if(e.getSource()==vp.btn_play3) {
			selectPlay("yoshi_play");
			vp.setVisible(false);
		}
		
	}

	private void selectPlay(String play) {
		try {
			file.writerFile(play, true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==vp.btn_play1) {
			vp.btn_play1.setBackground(Color.red);
			vp.btn_play1.setForeground(Color.blue);
		}else if(e.getSource()==vp.btn_play2) {
			vp.btn_play2.setBackground(Color.magenta);
			vp.btn_play2.setForeground(Color.white);
		}else if(e.getSource()==vp.btn_play3) {
			vp.btn_play3.setBackground(Color.green);
			vp.btn_play3.setForeground(Color.white);
		}


	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==vp.btn_play1) {
			vp.btn_play1.setBackground(Color.black);
			vp.btn_play1.setForeground(Color.white);
		}else if(e.getSource()==vp.btn_play2) {
			vp.btn_play2.setBackground(Color.black);
			vp.btn_play2.setForeground(Color.white);
		}else if(e.getSource()==vp.btn_play3) {
			vp.btn_play3.setBackground(Color.black);
			vp.btn_play3.setForeground(Color.white);
		}
	}

}
