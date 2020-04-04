import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.*;


public class EndOfGameHighscore extends JPanel implements FillTheCircleView {

	/**
	 * Create the panel.
	 */

	private JTextField playerNameField;
	private JButton soundButton;
	private JButton highscoreButton;
	private JButton playButton;
	private JButton mainMenuButton;
	private JLabel pageName;
	private JLabel scoreLabel;
	private JLabel highscoreLabel;
	private JLabel enterNameLabel;
	private JLabel backgroundLabel;
	private File inFile;
	private String fileName;
	private int score;
	private int countOfScores;
	private ArrayList<Integer> allScores;
	private ArrayList<String> allNames;

	public EndOfGameHighscore() throws IOException {

		setLayout(null);
		fileName = "highscore.txt";
		countOfScores = 0;
		inFile = new File(fileName);
		Scanner scan = new Scanner(inFile);
		allScores = new ArrayList<Integer>();
		allNames = new ArrayList<String>();
		try {
		if(scan.hasNext())
		{
			allNames.add(scan.next());
			String next = scan.next();
			int value = Integer.parseInt(next);
			allScores.add(value);
			
		}}
		catch(Exception e )
		{
			e.printStackTrace();
		}
		

		// adding High Score button
		ImageIcon muteIcon = new ImageIcon("images\\muteIcon.png");     
		soundButton = new JButton(new ImageIcon("images\\rsz_sound41.png"));
		soundButton.setBorder(new LineBorder(Color.white, 0));
		soundButton.setContentAreaFilled(false);
		soundButton.setBounds(35, 546, 41, 41);
		add(soundButton);

		// adding High Score button
		ImageIcon highscoreIcon = new ImageIcon("images\\highscoreIcon.png");     
		highscoreButton = new JButton(highscoreIcon);
		highscoreButton.setBorder(new LineBorder(Color.white, 0));
		highscoreButton.setContentAreaFilled(false);
		highscoreButton.setBounds(322, 546, 41, 41);
		add(highscoreButton);

		// adding play icon
		ImageIcon playIcon = new ImageIcon("images\\playIconBig.png");               
		playButton = new JButton(playIcon);
		playButton.setBorder(new LineBorder(Color.white, 0));
		playButton.setContentAreaFilled(false);
		playButton.setBounds(91, 327, 100, 100);
		add(playButton);

		// adding Main Menu button
		ImageIcon mainIcon = new ImageIcon("images\\mainIconBig.png");      
		mainMenuButton = new JButton(mainIcon);
		mainMenuButton.setBorder(new LineBorder(Color.white, 0));
		mainMenuButton.setContentAreaFilled(false);
		mainMenuButton.setBounds(218, 327, 100, 100);
		add(mainMenuButton);

		// name of the panel
		pageName = new JLabel("Your Score");                           
		pageName.setFont(new Font("Ravie", Font.BOLD | Font.ITALIC, 40));
		pageName.setForeground(Color.WHITE);
		pageName.setBounds(35, 29, 355, 62);
		add(pageName);

		// label that shows the Score of the player
		scoreLabel = new JLabel("Score");                              
		scoreLabel.setForeground(Color.WHITE);
		scoreLabel.setFont(new Font("Ravie", Font.BOLD | Font.ITALIC, 40));
		scoreLabel.setBounds(114, 91, 204, 54);
		add(scoreLabel);

		// filed where player adds his/her name when he/she has a high score
		playerNameField = new JTextField();                                   
		playerNameField.setForeground(Color.LIGHT_GRAY);
		playerNameField.setFont(new Font("Ravie", Font.ITALIC, 11));
		playerNameField.setColumns(30);
		playerNameField.setBounds(75, 278, 253, 20);
		playerNameField.addActionListener(new MyActionListener());
		add(playerNameField);

		// this label shows that player got a highscore 
		highscoreLabel = new JLabel("! HIGHSCORE !");                  
		highscoreLabel.setForeground(Color.ORANGE);
		highscoreLabel.setFont(new Font("Ravie", Font.BOLD | Font.ITALIC, 18));
		highscoreLabel.setBounds(102, 143, 196, 54);
		add(highscoreLabel);

		enterNameLabel = new JLabel("Enter Name");
		enterNameLabel.setFont(new Font("Ravie", Font.PLAIN, 17));
		enterNameLabel.setForeground(Color.LIGHT_GRAY);
		enterNameLabel.setBounds(75, 254, 174, 23);
		add(enterNameLabel);

		ImageIcon backgroundPhoto = new ImageIcon("images\\highscoreBackground.jpg");  // background photo of panel
		backgroundLabel = new JLabel("");
		backgroundLabel.setIcon(backgroundPhoto);
		backgroundLabel.setBounds(0, 0, 400, 600);
		add(backgroundLabel);

		setPreferredSize(new Dimension(400, 600));


	}

	private class MyActionListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent event)
		{
			countOfScores++;
			
			try
			{
				if(countOfScores <= 10)
				{
					allScores.add(score);
					allNames.add(playerNameField.getText());
				}
				else
				{
					for(int i = 0; i < 10; i++)
					{
						if(score < allScores.get(i))
						{
							allScores.set(i, score);
							allNames.set(i, playerNameField.getText());
						}
					}
				}

				int small;
				String smallName;

				for(int j = 0; j < allScores.size(); j++)
				{
					for(int k = j+1; k < allScores.size(); k++)
					{
						if(allScores.get(k) < allScores.get(j))
						{
							small = allScores.get(k);
							allScores.set(k, allScores.get(j));
							allScores.set(j, small);
							
							smallName = allNames.get(k);
							allNames.set(k, allNames.get(j));
							allNames.set(j, smallName);
						}
					}
				}

				
				PrintWriter outFile = new PrintWriter(inFile);
				int count = 0 ;
				
				for(int m = allNames.size()-1; m >= 0; m--)
				{
					count++;
					String output = allNames.get(m);
					outFile.println(output);
					outFile.println(allScores.get(m));
					if(count == 10) 
						m = 0;
				}
				outFile.flush();
				outFile.close();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}

			playerNameField.setText("");
		}
	}
	public void updateLanguage(String lang)
	{
		if(lang.equals("Aze"))
		{
			pageName.setText("Sizin Balınız");
			highscoreLabel.setText("! YÜKSƏK NƏTİCƏ !");
			enterNameLabel.setText("Adınızı girin:");
		}
		if(lang.equals("Eng"))
		{
			pageName.setText("Your Score");
			highscoreLabel.setText("! HIGHSCORE !");
			enterNameLabel.setText("Enter Name:");
		}
		if(lang.equals("Rus"))
		{
			pageName.setText("Ваш Счет");
			highscoreLabel.setText("! ЛУЧШИЙ ПОКАЗАТЕЛЬ !");
			enterNameLabel.setText("Введите Имя:");
		}
		if(lang.equals("Trk"))
		{
			pageName.setText("Sizin Skor");
			highscoreLabel.setText("! YÜKSEK SKOR !");
			enterNameLabel.setText("İsim giriniz:");
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
	public void setScore(int score)
	{
		this.score = score;
		System.out.println(this.score);
	}
}
