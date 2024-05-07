package controller;



import java.io.IOException;

import patron_v_10.archivos;

public class play_winner {

	private archivos file, file2;
	private int position=1; 
	public synchronized void saveWinner(String name, String time) throws IOException {
		file=new archivos("src/data/winner.txt");
		file2=new archivos("src/data/ranking");
		if(!file.getFile().exists()) {
				file.writerFile(name, true);
				file2.writerFile(name + "\t" + position + "\t" + time, false);
				position++;
		}
	}
}
