import javax.swing.JPanel;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.border.*;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class SettingsMenu extends JPanel implements FillTheCircleView{

	private JButton buttonLanguage;
	private JButton buttonReturnBack;
	private JButton buttonMusic;
	private JButton buttonSound;
	private JButton buttonHowToPlay;
	private JLabel labelSettings;
	public SettingsMenu() {
		setBackground(Color.WHITE);

		setPreferredSize(new Dimension(400, 600));
		setLayout(null);

		labelSettings = new JLabel("SETTINGS\r\n");
		labelSettings.setHorizontalAlignment(SwingConstants.CENTER);
		labelSettings.setForeground(Color.WHITE);
		labelSettings.setFont(new Font("Times New Roman", Font.BOLD, 27));
		labelSettings.setBounds(61, 33, 257, 60);
		add(labelSettings);

		buttonLanguage = new JButton("Language");
		buttonLanguage.setBackground(new Color(175, 238, 238));
		buttonLanguage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonLanguage.setFont(new Font("Verdana", Font.BOLD, 18));
		buttonLanguage.setBounds(104, 281, 193, 40);
		add(buttonLanguage);
		
		buttonHowToPlay = new JButton("How To Play");
		buttonHowToPlay.setBackground(new Color(175, 238, 238));
		buttonHowToPlay.setFont(new Font("Verdana", Font.BOLD, 18));
		buttonHowToPlay.setBounds(104, 374, 193, 40);
		buttonHowToPlay.setOpaque(true);
		add(buttonHowToPlay);

		buttonMusic = new JButton("");
		buttonMusic.setIcon(new ImageIcon("images\\rsz_music-icon.png"));
		buttonMusic.setBorder( new LineBorder(Color.white, 0));
		buttonMusic.setContentAreaFilled(false);
		buttonMusic.setBounds(206, 189, 64, 64);
		add(buttonMusic);

	    buttonSound = new JButton("");
	    buttonSound.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });
		buttonSound.setIcon(new ImageIcon("images\\rsz_sound64.png"));
		buttonSound.setBorder( new LineBorder(Color.WHITE, 0));
		buttonSound.setContentAreaFilled(false);
		buttonSound.setBounds(118, 189, 64, 64);
		add(buttonSound);

		buttonReturnBack = new JButton("");
		buttonReturnBack.setIcon(new ImageIcon("images\\rsz_go-back-icon-md.png"));
		buttonReturnBack.setBorder( new LineBorder(Color.WHITE, 0));
		buttonReturnBack.setContentAreaFilled(false);
		buttonReturnBack.setBounds(10, 549, 45, 40);
		add(buttonReturnBack);

		JLabel labelBackGround = new JLabel("");
		labelBackGround.setIcon(new ImageIcon("images\\settingsmenu.jpg"));
		labelBackGround.setBounds(0, 0, 400, 600);
		add(labelBackGround);

	}
	public void updateLanguage(String lang)
	{
		buttonHowToPlay.setFont(new Font("Verdana", Font.BOLD, 18));
		if(lang.equals("Aze"))
		{
			labelSettings.setText("PARAMETRLƏR");
			buttonLanguage.setText("Dil"); 
			buttonHowToPlay.setText("Necə oynamalı ?");
			buttonHowToPlay.setFont(new Font("Verdana", Font.BOLD, 16));
		}
		if(lang.equals("Eng"))
		{
			labelSettings.setText("SETTINGS");
			buttonLanguage.setText("Language"); 
			buttonHowToPlay.setText("How To Play");
		}
		if(lang.equals("Rus"))
		{
			labelSettings.setText("НАСТРОЙКИ");
			buttonLanguage.setText("Язык"); 
			buttonHowToPlay.setText("Инструкция");
		}
		if(lang.equals("Trk"))
		{
			labelSettings.setText("AYARLAR");
			buttonLanguage.setText("Dil Seçeneği"); 
			buttonHowToPlay.setText("Nasıl oynanır?");
		}
	}
	public JButton getButtonLanguage()
	{
		return buttonLanguage;
	}
	
	public void returnBackListener(ActionListener a)
	{
		buttonReturnBack.addActionListener(a);
	}
	public void musicListener(ActionListener a)
	{
		buttonMusic.addActionListener(a);
	}
	public void soundListener(ActionListener a)
	{
		buttonSound.addActionListener(a);
	}
	public JButton getSoundButton()
	{
		return buttonSound;
	}
	public JButton getButtonHowToPlay()
	{
		return buttonHowToPlay;
	}
}
