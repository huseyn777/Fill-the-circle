import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;


public class EndOfGame extends JPanel implements FillTheCircleView {

	
	private JButton mainMenuButton;
	private JButton soundButton;
	private JButton highscoreButton;
	private JButton playButton;
	private JLabel pageName;
	private JLabel scoreLabel;
	private JLabel backgroundLabel;
	/**
	 * Create the panel.
	 */
	public EndOfGame() {
		
		setPreferredSize(new Dimension(400, 600));
		setLayout(null);
		
		//ImageIcon muteIcon = new ImageIcon("images\\muteIcon.png");     // adding High Score button
		soundButton = new JButton(new ImageIcon("images\\rsz_sound41.png"));
		soundButton.setBorder(new LineBorder(Color.white, 0));
		soundButton.setContentAreaFilled(false);
		soundButton.setBounds(35, 546, 41, 41);
		add(soundButton);
		
		ImageIcon highscoreIcon = new ImageIcon("images\\highscoreIcon.png");     // adding High Score button
		highscoreButton = new JButton(highscoreIcon);
		highscoreButton.setBorder(new LineBorder(Color.white, 0));
		highscoreButton.setContentAreaFilled(false);
		highscoreButton.setBounds(322, 546, 41, 41);
		add(highscoreButton);
		
		ImageIcon playIcon = new ImageIcon("images\\playIconBig.png");     
		playButton = new JButton(playIcon);
		playButton.setBorder(new LineBorder(Color.white, 0));
		playButton.setContentAreaFilled(false);
		playButton.setBounds(90, 281, 100, 100);
		add(playButton);
		
		ImageIcon mainIcon = new ImageIcon("images\\mainIconBig.png");
		mainMenuButton = new JButton(mainIcon);
		mainMenuButton.setBorder(new LineBorder(Color.white, 0));
		mainMenuButton.setContentAreaFilled(false);
		mainMenuButton.setBounds(245, 297, 72, 73);
		add(mainMenuButton);
		
		pageName = new JLabel("Your Score");
		pageName.setHorizontalAlignment(SwingConstants.CENTER);
		pageName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
		pageName.setForeground(Color.WHITE);
		pageName.setBounds(35, 29, 355, 62);
		add(pageName);
		
		scoreLabel = new JLabel(""+Levels.getScoreStatic());
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreLabel.setForeground(Color.WHITE);
		scoreLabel.setFont(new Font("Ravie", Font.BOLD | Font.ITALIC, 40));
		scoreLabel.setBounds(114, 91, 204, 54);
		add(scoreLabel);
		
		
		ImageIcon backgroundPhoto = new ImageIcon("images\\highscoreBackground.jpg");
		backgroundLabel = new JLabel("");
		backgroundLabel.setIcon(backgroundPhoto);
		backgroundLabel.setBounds(0, 0, 400, 600);
		add(backgroundLabel);
		
	}
	public void updateLanguage(String lang)
	{
		if(lang.equals("Aze"))
		{
			pageName.setText("Sizin Balınız");
		}
		if(lang.equals("Eng"))
		{
			pageName.setText("Your Score");
		}
		if(lang.equals("Rus"))
		{
			pageName.setText("Ваш Счет");
		}
		if(lang.equals("Trk"))
		{
			pageName.setText("Sizin Skor");
		}
	}
	public JButton getMainMenuButton()
	{
		return mainMenuButton;
	}
	
	public JButton getSoundButton()
	{
		return soundButton;
	}
	
	public JButton getPlayButton()
	{
		return playButton;
	}

	public JButton getHighscoreButton()
	{
		return highscoreButton;
	}
	public void setScoreLabel(int score)
	{
		scoreLabel.setText("" + score);
	}
}
