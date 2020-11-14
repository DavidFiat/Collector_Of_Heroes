package util;

import java.util.HashMap;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundPlayer {
	public static HashMap<String, Clip> sounds = new HashMap<>();
	public static String actualSong;
	
	public static void play(String path) {
		try {
			Clip sound = AudioSystem.getClip();
			sound.open(AudioSystem.getAudioInputStream(SoundPlayer.class.getResource(path)));
			sound.start();
			new Thread() {
				@Override
				public void run() {
					try {
						Thread.sleep(sound.getMicrosecondLength() / 1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void startSound(String nameSound) {
		Clip clip = sounds.get(nameSound);
		actualSong = nameSound;
		clip.start();
	}

	public static void pauseSound(String nameSound) {
		Clip clip = sounds.get(nameSound);
		clip.stop();
	}

	public static void stopSound(String nameSound) {
		Clip clip = sounds.get(nameSound);
		clip.stop();
		clip.setMicrosecondPosition(0);
	}
	
	public static void stopActualSong() {
		Clip clip = sounds.get(actualSong);
		clip.stop();
		clip.setMicrosecondPosition(0);
	}
}
