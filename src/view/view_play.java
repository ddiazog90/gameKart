package view;

import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.logic_view_play;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class view_play extends JFrame{
	
	private JPanel contenPane;
	private JPanel pn_play1;
	public JLabel lbl_peach;
	public JLabel lbl_mario;
	public JLabel lbl_yoshi;
	public JButton btn_play1;
	public JButton btn_play2;
	public JButton btn_play3;
	private logic_view_play lvp;

	public view_play() throws HeadlessException {
		super();
		setTitle("JUGADORES");
		setResizable(false);
		addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosed(e);
			}
			
		});
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500,200,667,317);
		getContentPane().setLayout(null);
		
		JPanel pn_jugadores = new JPanel();
		pn_jugadores.setBackground(Color.BLACK);
		pn_jugadores.setBounds(0, 0, 651, 287);
		getContentPane().add(pn_jugadores);
		pn_jugadores.setLayout(null);
		
		pn_play1 = new JPanel();
		pn_play1.setBackground(Color.WHITE);
		pn_play1.setBounds(10, 10, 203, 224);
		pn_jugadores.add(pn_play1);
		
		lbl_mario = new JLabel("");
		lbl_mario.setIcon(new ImageIcon(view_play.class.getResource("/multimedia/mario_winner_sc.png")));
		pn_play1.add(lbl_mario);
		
		JPanel pn_play1_1 = new JPanel();
		pn_play1_1.setBackground(Color.WHITE);
		pn_play1_1.setBounds(223, 10, 203, 224);
		pn_jugadores.add(pn_play1_1);
		
		lbl_peach = new JLabel("");
		lbl_peach.setIcon(new ImageIcon(view_play.class.getResource("/multimedia/peach_winner_sc.png")));
		pn_play1_1.add(lbl_peach);
		
		JPanel pn_play1_2 = new JPanel();
		pn_play1_2.setBackground(Color.WHITE);
		pn_play1_2.setBounds(437, 10, 203, 224);
		pn_jugadores.add(pn_play1_2);
		
		lbl_yoshi = new JLabel("");
		lbl_yoshi.setIcon(new ImageIcon(view_play.class.getResource("/multimedia/yoshi_winner_sc.png")));
		pn_play1_2.add(lbl_yoshi);
		
		btn_play1 = new JButton("MARIO ");
		btn_play1.setBackground(Color.BLACK);
		btn_play1.setForeground(Color.WHITE);
		btn_play1.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		btn_play1.setBounds(10, 230, 203, 43);
		pn_jugadores.add(btn_play1);
		
		btn_play2 = new JButton("PEACH");
		btn_play2.setForeground(Color.WHITE);
		btn_play2.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		btn_play2.setBackground(Color.BLACK);
		btn_play2.setBounds(223, 230, 203, 43);
		pn_jugadores.add(btn_play2);
		
		btn_play3 = new JButton("YOSHI");
		btn_play3.setForeground(Color.WHITE);
		btn_play3.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		btn_play3.setBackground(Color.BLACK);
		btn_play3.setBounds(436, 230, 203, 43);
		pn_jugadores.add(btn_play3);
		
		lvp=new logic_view_play(this);
		
	}
}
