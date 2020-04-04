import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.io.*;
import java.util.*;

public class HighscorePanel extends JPanel implements FillTheCircleView {

	private JButton mainMenuButton;
	JButton soundButton;
	JLabel highscoreLabel;
	JTextArea textArea;
	JLabel backgroundLabel;
	File inFile = new File("highscore.txt");
	private ArrayList<Integer> min;
	/**
	 * Create the panel.
	 */
	public HighscorePanel() {

		setLayout(null);

		min = new ArrayList<Integer>();

		soundButton = new JButton(new ImageIcon("images\\rsz_sound41.png"));
		soundButton.setBorder(new LineBorder(Color.white, 0));
		soundButton.setContentAreaFilled(false);
		soundButton.setBounds(357, 0, 41, 41);
		add(soundButton);

		ImageIcon mainIcon = new ImageIcon("images\\mainIconSmall.png");      // adding Main Menu button
		mainMenuButton = new JButton(mainIcon);
		mainMenuButton.setBorder(new LineBorder(Color.white, 0));
		mainMenuButton.setContentAreaFilled(false);
		mainMenuButton.setBounds(10, 546, 40, 40);
		add(mainMenuButton);

		highscoreLabel = new JLabel("High Scores");                              // label that shows the name of the panel
		highscoreLabel.setForeground(Color.WHITE);
		highscoreLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));
		highscoreLabel.setBounds(55, 36, 335, 54);
		add(highscoreLabel);

		textArea = new JTextArea();
		textArea.setOpaque(false);
		//textArea.setBackground(Color.GREEN);
		textArea.setForeground(Color.yellow);
		textArea.setFont(new Font("Times New Roman", Font.BOLD, 32));
		textArea.setTabSize(30);
		textArea.setRows(10);
		try
		{
			Scanner scan = new Scanner(inFile);
			//scan.useDelimiter("\n");
			while(scan.hasNext())
			{
				String info = scan.next(); 
				String next = scan.next();
				int value = Integer.parseInt(next);
				for(int i = 0; i < 20 - info.length() - next.length(); i++)
				{
					info += ".";
				}
				info += next;
				textArea.append(info + "\n");
				min.add(value);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		textArea.setBounds(55, 140, 286, 378);
		add(textArea);

		ImageIcon backgroundPhoto = new ImageIcon("images\\highscoreMenuBackground.jpg");  // background photo of panel
		backgroundLabel = new JLabel("");
		backgroundLabel.setIcon(backgroundPhoto);
		backgroundLabel.setBounds(0, 0, 400, 600);
		add(backgroundLabel);

		setPreferredSize(new Dimension(400, 600));

	}
	public void updateLanguage(String lang)
	{
		if(lang.equals("Aze"))
		{
			highscoreLabel.setText("Ən yüksək nəticələr");;
		}
		if(lang.equals("Eng"))
		{
			highscoreLabel.setText("      High Scores");
		}
		if(lang.equals("Rus"))
		{
			highscoreLabel.setText("  Лучший показатель");
		}
		if(lang.equals("Trk"))
		{

			highscoreLabel.setText("   Yüksek skorlar");
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
	public int getMinScore() {
		if(min.size() > 0)
		{
			Collections.sort(min);
			return min.get(0);
		}
		
		else return 0;
	}


}
