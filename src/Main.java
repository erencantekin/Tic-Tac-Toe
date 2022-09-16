import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Main {

	public static void main(String[] args) throws LineUnavailableException, UnsupportedAudioFileException, IOException {
		
		File file = new File("C:\\Users\\lenovo\\Desktop\\Eclipse Workspace\\Tic-Tac-Toe\\src\\Look Both Ways - Nathan Moore.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		
		TicTacToe tictactoe = new TicTacToe();
		
		Scanner scanner = new Scanner(System.in);
		scanner.nextInt();

		

	}

}
