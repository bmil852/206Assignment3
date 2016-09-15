import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		//Center the start button
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, _startButton, 0, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, _startButton, 0, SpringLayout.VERTICAL_CENTER, this);
		//Put settings putton in top right corner
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
		
		_settingsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createAndShowGUI(new SettingsGUI());
				repaint();
			}
		});
	}

	/**
	 * The second 'tab' of the GUI
	 * Represents the 'Quiz' section of the GUI allowing the user to select which level to quiz from
	 */
	public class QuizGUI extends JPanel {
		
		//Buttons, accuracy and completion labels for each level
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
		private JLabel _completedOne = new JLabel("--");
		private JLabel _completedTwo = new JLabel("--");
		private JLabel _completedThree = new JLabel("--");
		private JLabel _completedFour = new JLabel("--");
		private JLabel _completedFive = new JLabel("--");
		private JLabel _completedSix = new JLabel("--");
		private JLabel _completedSeven = new JLabel("--");
		private JLabel _completedEight = new JLabel("--");
		private JLabel _completedNine = new JLabel("--");
		private JLabel _completedTen = new JLabel("--");
		private JLabel _accuracyOne = new JLabel("--");
		private JLabel _accuracyTwo = new JLabel("--");
		private JLabel _accuracyThree = new JLabel("--");
		private JLabel _accuracyFour = new JLabel("--");
		private JLabel _accuracyFive = new JLabel("--");
		private JLabel _accuracySix = new JLabel("--");
		private JLabel _accuracySeven = new JLabel("--");
		private JLabel _accuracyEight = new JLabel("--");
		private JLabel _accuracyNine = new JLabel("--");
		private JLabel _accuracyTen = new JLabel("--");
		
		//Button to return to main menu
		private JButton _returnButton = new JButton();
		
		public QuizGUI() {
			//Create Image return Button
			FileHandler fh = new FileHandler();
			BufferedImage returnImage = null;
			try {
				returnImage = ImageIO.read(fh.getFileAsInputStream("return_icon.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			_returnButton = new JButton(new ImageIcon(returnImage));
			
			//Create titles, underlined
			JLabel levelLabel = new JLabel("<HTML><U>Level: </U></HTML>");
			JLabel accuracyLabel = new JLabel("<HTML><U>Accuracy: </U></HTML>");
			JLabel completedLabel = new JLabel("<HTML><U>Completed: </U></HTML>");
			
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
				button.setText("Level " + i + "  ");
			}
			buttonList.get(i-1).setText("Level " + i);
			
			//Set completion and accuracy labels;
			ArrayList<JLabel> completedList = new ArrayList<JLabel>();
			completedList.add(_completedOne);
			completedList.add(_completedTwo);
			completedList.add(_completedThree);
			completedList.add(_completedFour);
			completedList.add(_completedFive);
			completedList.add(_completedSix);
			completedList.add(_completedSeven);
			completedList.add(_completedEight);
			completedList.add(_completedNine);
			completedList.add(_completedTen);
			ArrayList<JLabel> accuracyList = new ArrayList<JLabel>();
			accuracyList.add(_accuracyOne);
			accuracyList.add(_accuracyTwo);
			accuracyList.add(_accuracyThree);
			accuracyList.add(_accuracyFour);
			accuracyList.add(_accuracyFive);
			accuracyList.add(_accuracySix);
			accuracyList.add(_accuracySeven);
			accuracyList.add(_accuracyEight);
			accuracyList.add(_accuracyNine);
			accuracyList.add(_accuracyTen);
			
			//Construct the GUI
			SpringLayout layout = new SpringLayout();
			setLayout(layout);
			for (JButton button : buttonList) {
				add(button);
			}
			for (JLabel completed : completedList) {
				add(completed);
			}
			for (JLabel accuracy : accuracyList) {
				add(accuracy);
			}
			add(_returnButton);
			
			//Put completed five label at center, return button in top right corner
			layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, _completedFive, 0, SpringLayout.HORIZONTAL_CENTER, this);
			layout.putConstraint(SpringLayout.VERTICAL_CENTER, _completedFive, 0, SpringLayout.VERTICAL_CENTER, this);
			layout.putConstraint(SpringLayout.VERTICAL_CENTER, _levelFive, 0, SpringLayout.VERTICAL_CENTER, _completedFive);
			layout.putConstraint(SpringLayout.VERTICAL_CENTER, _accuracyFive, 0, SpringLayout.VERTICAL_CENTER, _completedFive);
			layout.putConstraint(SpringLayout.NORTH, _returnButton, 0, SpringLayout.NORTH, this);
			layout.putConstraint(SpringLayout.EAST, _returnButton, 0, SpringLayout.EAST, this);
			
			//Layout each button in line vertically and horizontally
			for (int j = 3; j >= 0; j--) {
				layout.putConstraint(SpringLayout.SOUTH, completedList.get(j), -15, SpringLayout.NORTH, completedList.get(j+1));
				layout.putConstraint(SpringLayout.VERTICAL_CENTER, buttonList.get(j), 0, SpringLayout.VERTICAL_CENTER, completedList.get(j));
				layout.putConstraint(SpringLayout.VERTICAL_CENTER, accuracyList.get(j), 0, SpringLayout.VERTICAL_CENTER, completedList.get(j));
			}
			for (int j = 5; j <= 9; j++) {
				layout.putConstraint(SpringLayout.NORTH, completedList.get(j), 15, SpringLayout.SOUTH, completedList.get(j-1));
				layout.putConstraint(SpringLayout.VERTICAL_CENTER, buttonList.get(j), 0, SpringLayout.VERTICAL_CENTER, completedList.get(j));
				layout.putConstraint(SpringLayout.VERTICAL_CENTER, accuracyList.get(j), 0, SpringLayout.VERTICAL_CENTER, completedList.get(j));
			}
			for (int j = 0; j < 10; j++) {
				layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, completedList.get(j), 0, SpringLayout.HORIZONTAL_CENTER, this);
				layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, buttonList.get(j), -100, SpringLayout.HORIZONTAL_CENTER, completedList.get(j));
				layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, accuracyList.get(j), 100, SpringLayout.HORIZONTAL_CENTER, completedList.get(j));
			}
			
			//Place titles above columns
			add(levelLabel);
			add(completedLabel);
			add(accuracyLabel);
			layout.putConstraint(SpringLayout.SOUTH, levelLabel, -20, SpringLayout.NORTH, _levelOne);
			layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, levelLabel, 0, SpringLayout.HORIZONTAL_CENTER, _levelOne);
			layout.putConstraint(SpringLayout.VERTICAL_CENTER, completedLabel, 0, SpringLayout.VERTICAL_CENTER, levelLabel);
			layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, completedLabel, 0, SpringLayout.HORIZONTAL_CENTER, _completedOne);
			layout.putConstraint(SpringLayout.VERTICAL_CENTER, accuracyLabel, 0, SpringLayout.VERTICAL_CENTER, levelLabel);
			layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, accuracyLabel, 0, SpringLayout.HORIZONTAL_CENTER, _accuracyOne);
			
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
	
	public class SettingsGUI extends JPanel {
		
		private JButton _returnButton = new JButton();
		private String[] voiceOptions = new String[]{"Voice 1", "Voice 2"};
		private JComboBox<String> _voiceBox = new JComboBox<>(voiceOptions);
		
		public SettingsGUI() {
			
			//Create image settings button
			FileHandler fh = new FileHandler();
			BufferedImage settingsImage = null;
			try {
				settingsImage = ImageIO.read(fh.getFileAsInputStream("return_icon.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			_returnButton = new JButton(new ImageIcon(settingsImage));
			
			//Construct the GUI
			SpringLayout layout = new SpringLayout();
			setLayout(layout);
			add(_voiceBox);
			add(_returnButton);
			JLabel voiceLabel = new JLabel("<HTML><U>Select Voice: </U></HTML>");
			add(voiceLabel);
			//Center the voice choices box
			layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, _voiceBox, 0, SpringLayout.HORIZONTAL_CENTER, this);
			layout.putConstraint(SpringLayout.VERTICAL_CENTER, _voiceBox, 0, SpringLayout.VERTICAL_CENTER, this);
			//Put return putton in top right corner
			layout.putConstraint(SpringLayout.NORTH, _returnButton, 0, SpringLayout.NORTH, this);
			layout.putConstraint(SpringLayout.EAST, _returnButton, 0, SpringLayout.EAST, this);
			//Put voice label above voice choices box
			layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, voiceLabel, 0, SpringLayout.HORIZONTAL_CENTER, _voiceBox);
			layout.putConstraint(SpringLayout.VERTICAL_CENTER, voiceLabel, -30, SpringLayout.VERTICAL_CENTER, _voiceBox);
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
