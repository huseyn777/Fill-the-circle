import java.awt.CardLayout;
import java.awt.KeyboardFocusManager;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class Main {
	public static boolean musicState = true;
	public static void main(String[] args) throws IOException
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ArrayList<FillTheCircleView> views = new ArrayList<FillTheCircleView>();



		Circle circle = new Circle();
		Ball ball = new Ball();
		Circle circle2 = new Circle();
		Ball ball2 = new Ball();
		Circle circle3 = new Circle();
		Ball ball3 = new Ball();
		Ball ball4 = new Ball();
		Circle circle4 = new Circle();


		Level1 level1 = new Level1(circle, ball);
		Level2 level2 = new Level2(circle2, ball2);
		Level3 level3 = new Level3(circle3, ball3);
		Level4 level4 = new Level4(circle4, ball4);

		JPanel panel = new JPanel();
		JPanel settingspnl = new SettingsMenu();
		JPanel languagepnl = new LanguageMenu();
		JPanel musicpnl = new MusicSelection();
		JPanel mainMenupnl = new MainMenuPanel();
		JPanel lvlSelectionpnl = new LevelSelectionMenu();
		JPanel highScorepnl = new HighscorePanel();
		JPanel howToPlaypnl = new HowToPlay();
		JPanel endOfGame = new EndOfGame();
		JPanel endOfGameHighscore = new EndOfGameHighscore();
		JPanel level1pnl = new Level1panel(level1);
		JPanel level2pnl = new Level2panel(level2);
		JPanel level3pnl = new Level3panel(level3);
		JPanel level4pnl = new Level4panel(level4);


		CardLayout c1 = new CardLayout();
		panel.setLayout(c1);

		panel.add(highScorepnl, "highScore");
		panel.add(lvlSelectionpnl, "levelSelection");
		panel.add(mainMenupnl, "main");
		panel.add(settingspnl, "sttngs");
		panel.add(languagepnl, "language");
		panel.add(musicpnl, "music");
		panel.add(endOfGameHighscore, "endGameHighscore");
		panel.add(howToPlaypnl,"howToPlay");
		panel.add(endOfGame, "endOfGame");
		panel.add(endOfGameHighscore, "endOfGameHighscore");
		panel.add(level1pnl, "lvl1");
		panel.add(level2pnl, "lvl2");
		panel.add(level3pnl, "lvl3");
		panel.add(level4pnl, "lvl4");



		views.add((FillTheCircleView)highScorepnl);
		views.add((FillTheCircleView)lvlSelectionpnl);
		views.add((FillTheCircleView)mainMenupnl);
		views.add((FillTheCircleView)settingspnl);
		views.add((FillTheCircleView)languagepnl);
		views.add((FillTheCircleView)musicpnl);
		views.add((FillTheCircleView)endOfGameHighscore);
		views.add((FillTheCircleView)howToPlaypnl);
		views.add((FillTheCircleView)endOfGame);
		views.add((FillTheCircleView)level1pnl);
		views.add((FillTheCircleView)level2pnl);
		views.add((FillTheCircleView)level3pnl);
		views.add((FillTheCircleView)level4pnl);
		views.add((FillTheCircleView)endOfGameHighscore);

		//level1pnl.setFocusable(true);
		c1.show(panel,"main");
		mainMenupnl.requestFocusInWindow();

		//Listeners-----------------
		//---------------------------------------------------------------------------------------------------------------------------
		ActionListener listenerToHighOrNot1 = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(((Level1panel)level1pnl).getLost())
				{
					if(((HighscorePanel)highScorepnl).getMinScore() > ((Level1panel)level1pnl).getScore() )
					{
						((EndOfGame)endOfGame).setScoreLabel(((Level1panel)level1pnl).getScore());
						c1.show(panel, "endOfGame");
					}
					if(((HighscorePanel)highScorepnl).getMinScore() < ((Level1panel)level1pnl).getScore() )
					{
						((EndOfGame)endOfGame).setScoreLabel(((Level1panel)level1pnl).getScore());
						c1.show(panel, "endOfGameHighscore");
					}
					((Level1panel)level1pnl).getTimeOfLostOrNot().stop();
					((Level2panel)level2pnl).getTimeOfLostOrNot().stop();
					((Level3panel)level3pnl).getTimeOfLostOrNot().stop();
					((Level4panel)level4pnl).getTimeOfLostOrNot().stop();
				}

			}
		};
		ActionListener listenerToHighOrNot2 = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(((Level2panel)level2pnl).getLost())
				{
					if(((HighscorePanel)highScorepnl).getMinScore() > ((Level2panel)level2pnl).getScore() )
					{
						((EndOfGame)endOfGame).setScoreLabel(((Level2panel)level2pnl).getScore());
						c1.show(panel, "endOfGame");
					}
					if(((HighscorePanel)highScorepnl).getMinScore() < ((Level2panel)level2pnl).getScore() )
					{
						//((EndOfGame)endOfGame).setScoreLabel(((Level1panel)level1pnl).getScore());
						((EndOfGameHighscore)endOfGameHighscore).setScore(((Level2panel)level2pnl).getScore());
						c1.show(panel, "endOfGameHighscore"); 
					}
					
					((Level1panel)level1pnl).getTimeOfLostOrNot().stop();
					((Level2panel)level2pnl).getTimeOfLostOrNot().stop();
					((Level3panel)level3pnl).getTimeOfLostOrNot().stop();
					((Level4panel)level4pnl).getTimeOfLostOrNot().stop();
				}

			}
		};
		ActionListener listenerToHighOrNot3 = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(((Level3panel)level3pnl).getLost())
				{
					((EndOfGame)endOfGame).setScoreLabel(((Level3panel)level3pnl).getScore());
					c1.show(panel, "endOfGame");
					((Level1panel)level1pnl).getTimeOfLostOrNot().stop();
					((Level2panel)level2pnl).getTimeOfLostOrNot().stop();
					((Level3panel)level3pnl).getTimeOfLostOrNot().stop();
					((Level4panel)level4pnl).getTimeOfLostOrNot().stop();
				}

			}
		};
		ActionListener listenerToHighOrNot4 = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(((Level4panel)level4pnl).getLost() || ((Level4panel)level4pnl).getLevelDone())
				{
					((EndOfGame)endOfGame).setScoreLabel(((Level4panel)level4pnl).getScore());
					c1.show(panel, "endOfGame");
					((Level1panel)level1pnl).getTimeOfLostOrNot().stop();
					((Level2panel)level2pnl).getTimeOfLostOrNot().stop();
					((Level3panel)level3pnl).getTimeOfLostOrNot().stop();
					((Level4panel)level4pnl).getTimeOfLostOrNot().stop();
				}

			}
		};
		ActionListener toLvl1 = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				c1.show(panel, "lvl1");
				((Level1panel)level1pnl).restart();
				level1pnl.requestFocusInWindow();
				((Level1panel)level1pnl).listenerToLostOrNot(listenerToHighOrNot1);
			}
		};
		ActionListener toLvl2 = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				c1.show(panel, "lvl2");
				if(e.getSource() != ((Level1panel)level1pnl).getbuttonNextLevel())
				{
					level1.resetScore();
				}
				((Level2panel)level2pnl).restart();
				level2pnl.requestFocusInWindow();
				((Level2panel)level2pnl).listenerToLostOrNot(listenerToHighOrNot2);
			}
		};
		ActionListener toLvl3 = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource() != ((Level2panel)level2pnl).getbuttonNextLevel())
				{
					level3.resetScore();
				}
				c1.show(panel, "lvl3");
				((Level3panel)level3pnl).restart();
				level3pnl.requestFocusInWindow();
				((Level3panel)level3pnl).listenerToLostOrNot(listenerToHighOrNot3);
			}
		};
		ActionListener toLvl4 = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource() != ((Level3panel)level3pnl).getbuttonNextLevel())
				{
					level3.resetScore();
				}
				c1.show(panel, "lvl4");
				((Level4panel)level4pnl).restart();
				level4pnl.requestFocusInWindow();
				((Level4panel)level4pnl).listenerToLostOrNot(listenerToHighOrNot4);
			}
		};
		ActionListener listenertoLangButtons = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String lang;

				if( e.getSource() == ((LanguageMenu)languagepnl).getbtnAze())
				{
					lang = "Aze";
				}
				else if( e.getSource() == ((LanguageMenu)languagepnl).getbtnEng())
				{
					lang = "Eng";
				}
				else if( e.getSource() == ((LanguageMenu)languagepnl).getbtnRus())
				{
					lang = "Rus";
				}
				else
				{
					lang = "Trk";
				}
				for(FillTheCircleView view : views)
				{
					view.updateLanguage(lang);
				}
			}
		};

		ActionListener listenerToHighScores = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				c1.show(panel, "highScore");
			}
		};
		ActionListener toHowToPlay = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				c1.show(panel, "howToPlay");

			}
		};
		ActionListener listenerToSettings = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				c1.show(panel, "sttngs");
			}
		};

		ActionListener listenerToMain = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				c1.show(panel, "main");
				mainMenupnl.requestFocusInWindow();
				((Level1panel)level1pnl).getTimeOfLostOrNot().stop();
				((Level2panel)level2pnl).getTimeOfLostOrNot().stop();
				((Level3panel)level3pnl).getTimeOfLostOrNot().stop();
				((Level4panel)level4pnl).getTimeOfLostOrNot().stop();
			}
		};
		ActionListener listenerToSound = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(musicState) {
					((MusicSelection)musicpnl).returnCurrentMusic().stop();
					((SettingsMenu)settingspnl).getSoundButton().setIcon(new ImageIcon("images\\rsz_mute64.png"));
					((HighscorePanel)highScorepnl).getSoundButton().setIcon(new ImageIcon("images\\rsz_mute41.png"));
					((HowToPlay)howToPlaypnl).getSoundButton().setIcon(new ImageIcon("images\\rsz_mute41.png"));
					((Level1panel)level1pnl).getSoundButton().setIcon(new ImageIcon("images\\rsz_mute31.png")); 
					((Level2panel)level2pnl).getSoundButton().setIcon(new ImageIcon("images\\rsz_mute31.png")); 
					((Level3panel)level3pnl).getSoundButton().setIcon(new ImageIcon("images\\rsz_mute31.png"));
					((Level4panel)level4pnl).getSoundButton().setIcon(new ImageIcon("images\\rsz_mute31.png"));
					((EndOfGame)endOfGame).getSoundButton().setIcon(new ImageIcon("images\\rsz_mute41.png"));
					((EndOfGameHighscore)endOfGameHighscore).getSoundButton().setIcon(new ImageIcon("images\\rsz_mute41.png"));
				}
				else
				{
					((MusicSelection)musicpnl).returnCurrentMusic().loop();
					((SettingsMenu)settingspnl).getSoundButton().setIcon(new ImageIcon("images\\rsz_sound64.png"));
					((HighscorePanel)highScorepnl).getSoundButton().setIcon(new ImageIcon("images\\rsz_sound41.png"));
					((HowToPlay)howToPlaypnl).getSoundButton().setIcon(new ImageIcon("images\\rsz_sound41.png")); //howtoplay
					((Level1panel)level1pnl).getSoundButton().setIcon(new ImageIcon("images\\rsz_sound31.png")); // levels
					((Level2panel)level2pnl).getSoundButton().setIcon(new ImageIcon("images\\rsz_sound31.png"));
					((Level3panel)level3pnl).getSoundButton().setIcon(new ImageIcon("images\\rsz_sound31.png"));
					((Level4panel)level4pnl).getSoundButton().setIcon(new ImageIcon("images\\rsz_sound31.png"));
					((EndOfGame)endOfGame).getSoundButton().setIcon(new ImageIcon("images\\rsz_sound41.png"));
					((EndOfGameHighscore)endOfGameHighscore).getSoundButton().setIcon(new ImageIcon("images\\rsz_sound41.png"));
				}
				if(e.getSource() == ((Level1panel)level1pnl).getSoundButton())
				{
					level1pnl.requestFocusInWindow();
				}
				if(e.getSource() == ((Level2panel)level2pnl).getSoundButton())
				{
					level2pnl.requestFocusInWindow();
				}
				if(e.getSource() == ((Level3panel)level3pnl).getSoundButton())
				{
					level3pnl.requestFocusInWindow();
				}
				if(e.getSource() == ((Level4panel)level4pnl).getSoundButton())
				{
					level4pnl.requestFocusInWindow();
				}
				musicState = !musicState;
			}
		};


		//Buttons-------------------------------------------------------------
		((MainMenuPanel)mainMenupnl).getSettingsButton().addActionListener(listenerToSettings);
		((LanguageMenu)languagepnl).getbtnAze().addActionListener(listenertoLangButtons);
		((LanguageMenu)languagepnl).getbtnRus().addActionListener(listenertoLangButtons);
		((LanguageMenu)languagepnl).getbtnEng().addActionListener(listenertoLangButtons);
		((LanguageMenu)languagepnl).getbtnTur().addActionListener(listenertoLangButtons);
		((HighscorePanel)highScorepnl).getSoundButton().addActionListener(listenerToSound);; //highscore
		((HowToPlay)howToPlaypnl).getSoundButton().addActionListener(listenerToSound);; //howtoplay
		((Level1panel)level1pnl).getSoundButton().addActionListener(listenerToSound); // levels
		((Level2panel)level2pnl).getSoundButton().addActionListener(listenerToSound);
		((Level3panel)level3pnl).getSoundButton().addActionListener(listenerToSound);
		((Level4panel)level4pnl).getSoundButton().addActionListener(listenerToSound);
		((HighscorePanel)highScorepnl).getMainMenuButton().addActionListener(listenerToMain);
		((EndOfGame)endOfGame).getPlayButton().addActionListener(toLvl1);
		((EndOfGame)endOfGame).getMainMenuButton().addActionListener(listenerToMain);
		((EndOfGame)endOfGame).getHighscoreButton().addActionListener(listenerToHighScores);
		((EndOfGame)endOfGame).getSoundButton().addActionListener(listenerToSound);
		((HowToPlay)howToPlaypnl).getBackButton().addActionListener(listenerToSettings);
		((LevelSelectionMenu)lvlSelectionpnl).getButtonReturnBack().addActionListener(listenerToMain);
		((Level1panel)level1pnl).getbackToMain().addActionListener(listenerToMain);
		((Level1panel)level1pnl).getbuttonNextLevel().addActionListener(toLvl2);
		((MainMenuPanel)mainMenupnl).getPlayButton().addActionListener(toLvl1);
		((LevelSelectionMenu)lvlSelectionpnl).getButton1().addActionListener(toLvl1);
		((LevelSelectionMenu)lvlSelectionpnl).getButton2().addActionListener(toLvl2);
		((LevelSelectionMenu)lvlSelectionpnl).getButton3().addActionListener(toLvl3);
		((LevelSelectionMenu)lvlSelectionpnl).getButton4().addActionListener(toLvl4);
		((Level3panel)level3pnl).getbackToMain().addActionListener(listenerToMain);
		((Level4panel)level4pnl).getbackToMain().addActionListener(listenerToMain);
		((Level2panel)level2pnl).getbackToMain().addActionListener(listenerToMain);
		((Level1panel)level1pnl).getbuttonNextLevel().addActionListener(toLvl2);
		((Level2panel)level2pnl).getbuttonNextLevel().addActionListener(toLvl3);
		((Level3panel)level3pnl).getbuttonNextLevel().addActionListener(toLvl4);
		((MainMenuPanel)mainMenupnl).getHighscoreButton().addActionListener(listenerToHighScores);
		((EndOfGameHighscore)endOfGameHighscore).getHighscoreButton().addActionListener(listenerToHighScores);
		((EndOfGameHighscore)endOfGameHighscore).getPlayButton().addActionListener(toLvl1);
		((EndOfGameHighscore)endOfGameHighscore).getSoundButton().addActionListener(listenerToSound);
		((EndOfGameHighscore)endOfGameHighscore).getMainMenuButton().addActionListener(listenerToMain);

		((MainMenuPanel)mainMenupnl).getLevelsButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				c1.show(panel, "levelSelection");
			}
		});
		((SettingsMenu)settingspnl).returnBackListener(listenerToMain);
		((SettingsMenu)settingspnl).getButtonHowToPlay().addActionListener(toHowToPlay);
		((SettingsMenu)settingspnl).getButtonLanguage().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				c1.show(panel, "language");
			}
		});
		ActionListener listenerToMusic = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				c1.show(panel, "music");
			}
		};


		((LanguageMenu)languagepnl).returnBackListener(listenerToSettings);
		((MusicSelection)musicpnl).returnBackListener(listenerToSettings);
		((SettingsMenu)settingspnl).musicListener(listenerToMusic);
		((SettingsMenu)settingspnl).soundListener(listenerToSound);


		//JPanel panel1 = new MainMenuPanel();
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);


	}
}
