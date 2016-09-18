import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

public class SpellingQuizMediaPlayer {

	public SpellingQuizMediaPlayer(String filename) {
		JFrame frame = new JFrame("Video Reward");
		
		MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory();
		
		Canvas canvas = new Canvas();
		canvas.setBackground(Color.BLACK);
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add(canvas,  BorderLayout.CENTER);
		frame.add(p, BorderLayout.CENTER);
		
		EmbeddedMediaPlayer mediaPlayer = mediaPlayerFactory.newEmbeddedMediaPlayer();
		mediaPlayer.setVideoSurface(mediaPlayerFactory.newVideoSurface(canvas));
		frame.setLocation(110, 110);
		frame.setSize(864, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		mediaPlayer.playMedia(filename);
	}
	
	
}
