import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

public class LanguageMenu extends JPanel   implements FillTheCircleView  {
	private JButton buttonReturnBack;
	private JButton btnAze, btnEng, btnRus, btnTur; 
	private JLabel labelLanguageSelection;
	public LanguageMenu() 
	{
		setPreferredSize(new Dimension(400, 600));
		setLayout(null);

		labelLanguageSelection = new JLabel("Language Selection");
		labelLanguageSelection.setForeground(Color.WHITE);
		labelLanguageSelection.setFont(new Font("Segoe UI Black", Font.ITALIC, 26));
		labelLanguageSelection.setBounds(76, 31, 270, 60);
		add(labelLanguageSelection);


		 btnAze = new JButton("   Azerbaijani");
		btnAze.setFont(new Font("Snap ITC", Font.BOLD, 20));
		btnAze.setForeground(Color.WHITE);
		btnAze.setIcon(new ImageIcon("images\\flag-azerbaijan.png"));
		//btnEnglish.setBorder( new LineBorder(Color.white, 0));
		btnAze.setContentAreaFilled(false);
		btnAze.setBounds(89, 171, 245, 29);
		add(btnAze);



		btnEng = new JButton("   English     ");
		btnEng.setForeground(Color.WHITE);
		btnEng.setFont(new Font("Snap ITC", Font.BOLD, 20));
		btnEng.setIcon(new ImageIcon("images\\flag-united-kingdom.png"));
		//btnEnglish_1.setBorder( new LineBorder(Color.white, 0));
		btnEng.setContentAreaFilled(false);
		btnEng.setBounds(89, 234, 245, 29);
		add(btnEng);

		btnRus = new JButton("   Russian     ");
		btnRus.setForeground(Color.WHITE);
		btnRus.setFont(new Font("Snap ITC", Font.BOLD, 20));
		btnRus.setIcon(new ImageIcon("images\\flag-russia.png"));
		//btnRussian.setBorder( new LineBorder(Color.white, 0));
		btnRus.setContentAreaFilled(false);
		btnRus.setBounds(89, 303, 245, 29);
		add(btnRus);

		btnTur = new JButton("   Turkish     ");
		btnTur.setForeground(Color.WHITE);
		btnTur.setFont(new Font("Snap ITC", Font.BOLD, 20));
		btnTur.setIcon(new ImageIcon("images\\flag-turkey.png"));
		//btnTurkish.setBorder( new LineBorder(Color.white, 0));
		btnTur.setContentAreaFilled(false);
		btnTur.setBounds(89, 367, 245, 29);
		add(btnTur);

		buttonReturnBack = new JButton("");
		buttonReturnBack.setIcon(new ImageIcon("images\\rsz_go-back-icon-md.png"));
		buttonReturnBack.setContentAreaFilled(false);
		buttonReturnBack.setBorder(new LineBorder(Color.WHITE, 0));
		buttonReturnBack.setBounds(10, 549, 45, 40);
		add(buttonReturnBack);

		JLabel labelBackGround = new JLabel("");
		labelBackGround.setIcon(new ImageIcon("images\\language background.jpg"));
		labelBackGround.setBounds(0, 0, 400, 600);
		add(labelBackGround);
	}
	public void updateLanguage(String lang)
	{
		if(lang.equals("Aze"))
		{
			labelLanguageSelection.setText("         Dil Seçimi   ");
		}
		if(lang.equals("Eng"))
		{
			labelLanguageSelection.setText("Language Selection");
		}
		if(lang.equals("Rus"))
		{
			labelLanguageSelection.setText("           Язык     ");
		}
		if(lang.equals("Trk"))
		{
			labelLanguageSelection.setText("         Dil Seçeneği");
		}
	}
	public JButton getbtnAze()
	{
		return btnAze;
	}
	public JButton getbtnEng()
	{
		return btnEng;
	}
	public JButton getbtnRus()
	{
		return btnRus;
	}
	public JButton getbtnTur()
	{
		return btnTur;
	}
	public void returnBackListener(ActionListener a)
	{
		buttonReturnBack.addActionListener(a);
	}
	

}
