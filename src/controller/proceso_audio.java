package controller;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class proceso_audio extends Thread{

	private Clip clip;
	public proceso_audio(String wav) {
		super(wav);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(getName()).getAbsoluteFile());
	        clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	       } catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
	         System.out.println("Error al reproducir el sonido."+ex);
	       }
	}

	
}
