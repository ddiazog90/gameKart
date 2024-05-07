package controller;

import view.view_run;

public class proceso_timer extends Thread{
	
	private view_run vr;
	private boolean finished=false;

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public proceso_timer(view_run vr) {
		super();
		this.vr = vr;
	}
	
	public void run() {
		for(int seg=1;seg<60;seg++) {
			for(int mseg=1;mseg<100;mseg++) {
				try {
					sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(mseg<10) {
//					vr.lbl_seg.setText("00"+mseg);
//				}else if(mseg<100) {
					vr.lbl_seg.setText("0"+mseg);
				}else {
					vr.lbl_seg.setText(String.valueOf(mseg));
				}
				if(finished) {
					break;
				}
				
			}
			if(seg<10)
				vr.lbl_min.setText("0"+seg);
			else
				vr.lbl_min.setText(String.valueOf(seg));
			
			if(finished) {
				break;
			}
		}
	}
}
