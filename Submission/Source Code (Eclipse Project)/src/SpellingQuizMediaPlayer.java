import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

public class SpellingQuizMediaPlayer {

	public SpellingQuizMediaPlayer(String filename) {
		final JFrame frame = new JFrame("Video Reward");
		
		MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory();
		
		Canvas canvas = new Canvas();
		canvas.setBackground(Color.BLACK);
		JPanel p = new JPanel();
		JPanel p2 = new JPanel();
		p.setLayout(new BorderLayout());
		p2.setLayout(new BorderLayout());
		p.add(canvas,  BorderLayout.CENTER);
		JButton stopButton = new JButton("Stop");
		final JButton pauseButton = new JButton("Pause");
		p2.add(stopButton, BorderLayout.EAST);
		p2.add(pauseButton, BorderLayout.WEST);
		frame.add(p, BorderLayout.CENTER);
		frame.add(p2, BorderLayout.SOUTH);
		
		final EmbeddedMediaPlayer mediaPlayer = mediaPlayerFactory.newEmbeddedMediaPlayer();
		mediaPlayer.setVideoSurface(mediaPlayerFactory.newVideoSurface(canvas));

		stopButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mediaPlayer.stop();
				frame.setVisible(false);
			}
			
		});
		pauseButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mediaPlayer.pause();
				if (pauseButton.getText().equals("Pause")) {
					pauseButton.setText("Play");
				} else {
					pauseButton.setText("Pause");
				}
				
			}
			
		});
		
		frame.setLocation(110, 110);
		frame.setSize(864, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.toFront();
		frame.repaint();
		
		mediaPlayer.playMedia(filename);
	}
	
	
}
