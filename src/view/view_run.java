package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.logic_view_run;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class view_run extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public lienzo pn_lienzo;
	public JButton btn_start;
	public JButton btn_pause;
	public JButton btn_resume;
	public JLabel lbl_min;
	public JLabel lbl_seg;
	private logic_view_run lvr;
	public JLabel lbl_turbo;
	public JButton btn_play;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view_run frame = new view_run();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public view_run() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(view_run.class.getResource("/multimedia/mario_banner.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Carrera de Autos");
		setBounds(100, 0, 1400, 848);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn_control = new JPanel();
		pn_control.setBounds(10, 86, 79, 358);
		contentPane.add(pn_control);
		pn_control.setLayout(null);
		
		btn_start = new JButton("");
		btn_start.setIcon(new ImageIcon(view_run.class.getResource("/multimedia/go.png")));
		btn_start.setToolTipText("START");
		btn_start.setForeground(SystemColor.text);
		btn_start.setBackground(SystemColor.windowText);
		btn_start.setFont(new Font("Tahoma", Font.BOLD, 30));
		btn_start.setBounds(0, 115, 85, 66);
		pn_control.add(btn_start);
		
		btn_pause = new JButton("");
		btn_pause.setEnabled(false);
		btn_pause.setToolTipText("PAUSE");
		btn_pause.setIcon(new ImageIcon(view_run.class.getResource("/multimedia/start_mario.png")));
		btn_pause.setForeground(SystemColor.text);
		btn_pause.setFont(new Font("Tahoma", Font.BOLD, 30));
		btn_pause.setBackground(Color.BLACK);
		btn_pause.setBounds(0, 191, 85, 66);
		pn_control.add(btn_pause);
		
		btn_resume = new JButton("");
		btn_resume.setEnabled(false);
		btn_resume.setToolTipText("REANUDAR");
		btn_resume.setIcon(new ImageIcon(view_run.class.getResource("/multimedia/resume_mario.png")));
		btn_resume.setForeground(SystemColor.text);
		btn_resume.setFont(new Font("Tahoma", Font.BOLD, 50));
		btn_resume.setBackground(Color.WHITE);
		btn_resume.setBounds(0, 267, 85, 66);
		pn_control.add(btn_resume);
		
		btn_play = new JButton("");
		btn_play.setIcon(new ImageIcon(view_run.class.getResource("/multimedia/players.png")));
		btn_play.setToolTipText("START");
		btn_play.setForeground(Color.WHITE);
		btn_play.setFont(new Font("Tahoma", Font.BOLD, 30));
		btn_play.setBackground(Color.BLACK);
		btn_play.setBounds(0, 37, 85, 66);
		pn_control.add(btn_play);
		
		pn_lienzo = new lienzo();
		pn_lienzo.setBounds(99, 86, 1277, 694);
		contentPane.add(pn_lienzo);
		
		JPanel pn_time = new JPanel();
		pn_time.setBackground(Color.WHITE);
		pn_time.setBounds(99, 10, 1277, 70);
		contentPane.add(pn_time);
		pn_time.setLayout(null);
		
		lbl_min = new JLabel("00");
		lbl_min.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_min.setForeground(Color.MAGENTA);
		lbl_min.setFont(new Font("Tahoma", Font.BOLD, 80));
		lbl_min.setBounds(957, 0, 144, 70);
		pn_time.add(lbl_min);
		
		lbl_seg = new JLabel("00");
		lbl_seg.setForeground(Color.PINK);
		lbl_seg.setFont(new Font("Tahoma", Font.BOLD, 80));
		lbl_seg.setBounds(1123, 0, 117, 70);
		pn_time.add(lbl_seg);
		
		JLabel lbl_sig = new JLabel(":");
		lbl_sig.setForeground(Color.YELLOW);
		lbl_sig.setFont(new Font("Tahoma", Font.BOLD, 80));
		lbl_sig.setBounds(1099, 0, 39, 70);
		pn_time.add(lbl_sig);
		
		JLabel lbl_min_1 = new JLabel("TIME=");
		lbl_min_1.setForeground(Color.RED);
		lbl_min_1.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
		lbl_min_1.setBounds(823, 0, 150, 70);
		pn_time.add(lbl_min_1);
		
		JLabel lbl_min_1_1 = new JLabel("TURBO=");
		lbl_min_1_1.setForeground(Color.RED);
		lbl_min_1_1.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
		lbl_min_1_1.setBounds(344, 0, 166, 70);
		pn_time.add(lbl_min_1_1);
		
		lbl_turbo = new JLabel("4");
		lbl_turbo.setForeground(Color.BLUE);
		lbl_turbo.setFont(new Font("Tahoma", Font.BOLD, 80));
		lbl_turbo.setBounds(520, 0, 72, 70);
		pn_time.add(lbl_turbo);
		
		lvr=new logic_view_run(this);
	}
}
