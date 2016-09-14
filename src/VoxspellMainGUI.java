import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public class VoxspellMainGUI extends JPanel {

	private static JFrame _currentFrame;
	private JButton _startButton;
	private JButton _settingsButton;
	
	public VoxspellMainGUI() {
		_startButton = new JButton("Begin Quiz");
		
		//Create image settings button
		FileHandler fh = new FileHandler();
		BufferedImage settingsImage = null;
		try {
			settingsImage = ImageIO.read(fh.getFileAsInputStream("settings_icon.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		_settingsButton = new JButton(new ImageIcon(settingsImage));
		
		//Construct the GUI
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		add(_startButton);
		add(_settingsButton);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, _startButton, 0, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, _startButton, 0, SpringLayout.VERTICAL_CENTER, this);
		layout.putConstraint(SpringLayout.NORTH, _settingsButton, 0, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, _settingsButton, 0, SpringLayout.EAST, this);
		setPreferredSize(new Dimension(400, 500));
		
		//Add action listeners
		_startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createAndShowGUI(new QuizGUI());
				repaint();
			}
		});
	}

	/**
	 * The second 'tab' of the GUI
	 * Represents the 'Quiz' section of the GUI allowing the user to select which level to quiz from
	 */
	public class QuizGUI extends JPanel {

		private JButton _levelOne = new JButton();
		private JButton _levelTwo = new JButton();
		private JButton _levelThree = new JButton();
		private JButton _levelFour = new JButton();
		private JButton _levelFive = new JButton();
		private JButton _levelSix = new JButton();
		private JButton _levelSeven = new JButton();
		private JButton _levelEight = new JButton();
		private JButton _levelNine = new JButton();
		private JButton _levelTen = new JButton();
		
		private JButton _returnButton = new JButton();
		
		public QuizGUI() {
			//Create Image settings Button
			//Create image settings button
			FileHandler fh = new FileHandler();
			BufferedImage returnImage = null;
			try {
				returnImage = ImageIO.read(fh.getFileAsInputStream("return_icon.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			_returnButton = new JButton(new ImageIcon(returnImage));
			
			//Set level buttons;
			ArrayList<JButton> buttonList = new ArrayList<JButton>();
			buttonList.add(_levelOne);
			buttonList.add(_levelTwo);
			buttonList.add(_levelThree);
			buttonList.add(_levelFour);
			buttonList.add(_levelFive);
			buttonList.add(_levelSix);
			buttonList.add(_levelSeven);
			buttonList.add(_levelEight);
			buttonList.add(_levelNine);
			buttonList.add(_levelTen);
			
			int i = 0;
			for (JButton button : buttonList) {
				i++;
				button.setText("Level " + i);
			}
			
			//Construct the GUI
			SpringLayout layout = new SpringLayout();
			setLayout(layout);
			for (JButton button : buttonList) {
				add(button);
			}
			add(_returnButton);
			
			layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, _levelFive, 0, SpringLayout.HORIZONTAL_CENTER, this);
			layout.putConstraint(SpringLayout.VERTICAL_CENTER, _levelFive, 0, SpringLayout.VERTICAL_CENTER, this);
			layout.putConstraint(SpringLayout.NORTH, _returnButton, 0, SpringLayout.NORTH, this);
			layout.putConstraint(SpringLayout.EAST, _returnButton, 0, SpringLayout.EAST, this);
			
			for (int j = 3; j >= 0; j--) {
				layout.putConstraint(SpringLayout.SOUTH, buttonList.get(j), -10, SpringLayout.NORTH, buttonList.get(j+1));
			}
			for (int j = 5; j <= 9; j++) {
				layout.putConstraint(SpringLayout.NORTH, buttonList.get(j), 10, SpringLayout.SOUTH, buttonList.get(j-1));
			}
			for (int j = 0; j < 10; j++) {
				layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, buttonList.get(j), 0, SpringLayout.HORIZONTAL_CENTER, this);
			}
			setPreferredSize(new Dimension(400, 500));
			
			//Add action listeners
			_returnButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					createAndShowGUI(new VoxspellMainGUI());
					repaint();
				}
			});
		}
		
	}
	
	public static void createAndShowGUI(JComponent pane) {
		//Clear the current Frame
		if (_currentFrame != null) {
			_currentFrame.removeAll();
			_currentFrame.setVisible(false);
		}
		
		//Create and set up the GUI and window
		_currentFrame = new JFrame("VOXSPELL");
		_currentFrame.add(pane);
		_currentFrame.pack();
		_currentFrame.setLocationRelativeTo(null);
		_currentFrame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		//Create and show the GUI
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI(new VoxspellMainGUI());
			}
		});
	}

}
