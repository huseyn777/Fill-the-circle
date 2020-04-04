import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;


public class MainMenuPanel extends JPanel implements FillTheCircleView {

	JButton playButton;
	JButton highscoreButton;
	JButton likeButton;
	JButton levelsButton;
	JButton settingsButton;
	JButton exitButton;
	JLabel labelBackground;
	/**
	 * Create the panel.
	 */
	public MainMenuPanel() {
		setLayout(null);

		setPreferredSize(new Dimension(400, 600));

		ImageIcon playIcon = new ImageIcon("images\\playIcon.png");
		playButton = new JButton(new ImageIcon("images\\playIcon.png"));
		playButton.setFont(new Font("Broadway", Font.BOLD, 16));
		playButton.setBounds(128, 413, 160, 80);
		playButton.setBorder(new LineBorder(Color.white, 0));
		playButton.setContentAreaFilled(false);
		add(playButton);

		// adding Facebook button
		ImageIcon facebookIcon = new ImageIcon("images\\facebookIcon.gif");           
		likeButton = new JButton(new ImageIcon("images\\facebookIcon.gif"));
		likeButton.setBounds(20, 534, 41, 41);
		likeButton.setBorder(new LineBorder(Color.white, 0));
		likeButton.setContentAreaFilled(false);
		likeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {    // listener which connects the user with Facebook
				Desktop browser = Desktop.getDesktop();     // when facebook button is clicked
				try
				{
					browser.browse(new URI("https://www.facebook.com/FillTheCircleGame/"));
				}
				catch(IOException err)
				{

				}
				catch (URISyntaxException er)
				{

				}
			}
		});
		add(likeButton);

		// adding Levels Icon;
		ImageIcon levelsIcon = new ImageIcon("images\\levelsIcon.png");          
		levelsButton = new JButton(new ImageIcon("images\\levelsIcon.png"));
		levelsButton.setFont(new Font("Ravie", Font.BOLD | Font.ITALIC, 17));
		levelsButton.setBackground(new Color(46, 139, 87));
		levelsButton.setForeground(Color.GREEN);
		levelsButton.setBorder(new LineBorder(Color.white, 0));
		levelsButton.setContentAreaFilled(false);
		levelsButton.setBounds(147, 534, 120, 41);
		add(levelsButton);

		ImageIcon highscoreIcon = new ImageIcon("images\\highscoreIcon.png");     // adding High Score button
		highscoreButton = new JButton(new ImageIcon("images\\highscoreIcon.png"));
		highscoreButton.setBounds(77, 534, 41, 41);
		highscoreButton.setBorder(new LineBorder(Color.white, 0));
		highscoreButton.setContentAreaFilled(false);
		add(highscoreButton);

		ImageIcon settingsIcon = new ImageIcon("images\\settingsIconSmall.png");     // adding Settings button
		settingsButton = new JButton(new ImageIcon("images\\settingsIconSmall.png"));
		settingsButton.setBounds(288, 534, 41, 41);
		settingsButton.setBorder(new LineBorder(Color.white, 0));
		settingsButton.setContentAreaFilled(false);
		add(settingsButton);

		JLabel gameName = new JLabel("Fill The Circle");
		gameName.setForeground(new Color(0, 255, 255));
		gameName.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 57));
		gameName.setBounds(10, 11, 381, 50);
		add(gameName);

		ImageIcon exitIconSmall = new ImageIcon("images\\exitIconSmall.png");     // adding Exit button
		ImageIcon exitIconBig = new ImageIcon("images\\exitIconBig.png");     // adding Exit button
		exitButton = new JButton(new ImageIcon("images\\exitIconSmall.png"));
		exitButton.setBounds(340, 534, 41, 41);
		exitButton.setBorder(new LineBorder(Color.white, 0));
		exitButton.setContentAreaFilled(false);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {    // listener which connects the user with Facebook
				if(e.getSource() == exitButton)
					System.exit(1);
			}
		});
		add(exitButton);

		ImageIcon backgroundIcon = new ImageIcon("images\\mainBackground.png");     // adding Background button
		labelBackground = new JLabel("");
		labelBackground.setBackground(Color.GREEN);
		labelBackground.setForeground(Color.CYAN);
		labelBackground.setIcon(new ImageIcon("images\\mainBackground.png"));
		labelBackground.setBounds(0, 0, 400, 600);
		add(labelBackground);

	}

	public void updateLanguage(String lang)
	{
		if(lang.equals("Aze"))
		{
			
		}
		if(lang.equals("Eng"))
		{
			
		}
		if(lang.equals("Rus"))
		{
			
		}
		if(lang.equals("Trk"))
		{
			
		}
	}
	public JButton getPlayButton()
	{
		return playButton;
	}

	public JButton getHighscoreButton()
	{
		return highscoreButton;
	}

	public JButton getLikeButton()
	{
		return likeButton;
	}

	public JButton getLevelsButton()
	{
		return levelsButton;
	}

	public JButton getSettingsButton()
	{
		return settingsButton;
	}
}
