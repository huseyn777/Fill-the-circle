import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

public class Level3panel extends JPanel implements FillTheCircleView
{
	private final double GRAVITY;
	private Levels lvl3;
	private boolean levelDone, lost;
	private boolean up, down, left, right;
	private int xBall, yBall;
	private int xCircle, yCircle;
	private int BallRadius, CircleRadius, holeRadius, holeSmallRadius;
	private Timer timeOfCircleMovment, timeOfColor, timeOfLevel, timeOfGravity, timeofBlackHole,timeOfDis,timeOfLostOrNot;
	private int x,y;
	private int lengthofSmallCircle, radiusofSmallCircle;
	private int littleCircle;
	public int chances;
	private boolean inside;
	private int time;
	private int holeX, holeY;
	private int holeSmallX, holeSmallY;
	//GUI
	private JLabel lblTime, lblScore;
	private Image icon,iconBlackHole;
	private JButton buttonNextLevel,backToMain,soundButton;
	private JLabel labelHeart1,labelHeart2,labelHeart3, labelHeart4, labelHeart5;
	private String score;

	public Level3panel(Levels lvl3)   
	{
		this.lvl3 = lvl3;
		GRAVITY = lvl3.getGravity();
		time = lvl3.getTime();
		setPreferredSize (new Dimension(400, 600));
		setBackground (Color.black);
		xBall = lvl3.getStartPointOfBall().x;
		yBall = lvl3.getStartPointOfBall().y;
		xCircle = lvl3.getStartPointOfCircle().x;
		yCircle = lvl3.getStartPointOfCircle().y;
		BallRadius = lvl3.getBallRadius();
		CircleRadius = lvl3.getCircleRadius();
		radiusofSmallCircle = 10;
		chances = lvl3.getChances();
		inside = true;
		holeRadius =  CircleRadius;
		holeSmallRadius  = BallRadius ;
		holeSmallX = 275;
		holeSmallY = 175;
		holeX = 200;
		holeY = 100;

		addKeyListener(new Move());
		timeOfGravity = new Timer((int)Math.sqrt(600/(GRAVITY/2)),new Gravity());
		timeOfCircleMovment = new Timer(45, new MotionOfCircle());
		timeOfColor = new Timer(500, new SizeOfSmallCircle());
		timeOfLevel = new Timer(1000,new TimeOfTheGame());
		timeOfLostOrNot = new Timer(1000, null);
		timeofBlackHole = new Timer((int)Math.sqrt(600/(GRAVITY/2)), new BlackHole());
		timeOfDis= new Timer(100, new Vanish());
		timeOfLevel.start();
		timeOfCircleMovment.start();
		timeofBlackHole.start();
		setFocusable(true);
		setLayout(null);

		try {
			icon = new ImageIcon("images\\rsz_1level3_background.jpg").getImage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			iconBlackHole = new ImageIcon("images\\rsz_1blackhole-icon.png").getImage();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		JLabel levelLabel = new JLabel("Level 3");
		levelLabel.setForeground(new Color(253, 245, 230));
		levelLabel.setBackground(Color.LIGHT_GRAY);
		levelLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		levelLabel.setHorizontalAlignment(SwingConstants.CENTER);
		levelLabel.setBounds(163, 0, 96, 36);
		add(levelLabel);
		score = "Score: ";
		lblScore = new JLabel(score + lvl3.getScore());
		lblScore.setText(score  + lvl3.getScore());
		lblScore.setForeground(new Color(255, 255, 0));
		lblScore.setFont(new Font("Impact", Font.PLAIN, 18));
		lblScore.setBounds(10, 22, 96, 31);
		add(lblScore);

		soundButton = new JButton("");
		soundButton.setIcon(new ImageIcon("images\\rsz_sound31.png"));
		soundButton.setBounds(369, 0, 31, 31);
		soundButton.setBorder( new LineBorder(Color.white, 0));
		soundButton.setContentAreaFilled(false);
		add(soundButton);
		//Heart LAbels-------------------------------------------------------------------------------------------------------
		labelHeart1 = new JLabel("");
		labelHeart1.setIcon(new ImageIcon("images\\rsz_heart_icon.png"));
		labelHeart1.setBounds(10, 53, 15, 16);
		add(labelHeart1);

		labelHeart2 = new JLabel("");
		labelHeart2.setIcon(new ImageIcon("images\\rsz_heart_icon.png"));
		labelHeart2.setBounds(23, 53, 15, 16);
		add(labelHeart2);

		labelHeart3 = new JLabel("");
		labelHeart3.setIcon(new ImageIcon("images\\rsz_heart_icon.png"));
		labelHeart3.setBounds(36, 53, 15, 16);
		add(labelHeart3);

		labelHeart4 = new JLabel("");
		labelHeart4.setIcon(new ImageIcon("images\\rsz_heart_icon.png"));
		labelHeart4.setBounds(49, 53, 15, 16);
		add(labelHeart4);

		labelHeart5 = new JLabel("");
		labelHeart5.setIcon(new ImageIcon("images\\rsz_heart_icon.png"));
		labelHeart5.setBounds(61, 53, 15, 16);
		add(labelHeart5);

		lblTime = new JLabel(" 20");
		lblTime.setForeground(Color.CYAN);
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTime.setBackground(Color.GRAY);
		lblTime.setBounds(359, 33, 31, 31);
		add(lblTime);

		JLabel labelClock = new JLabel("");
		labelClock.setIcon(new ImageIcon("images\\rsz_timer_icon.png"));
		labelClock.setForeground(Color.CYAN);
		labelClock.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelClock.setBackground(Color.GRAY);
		labelClock.setBounds(331, 31, 31, 31);
		add(labelClock);

		backToMain = new JButton("");
		backToMain.setIcon(new ImageIcon("images\\rsz_main_menu.png"));
		backToMain.setContentAreaFilled(false);
		backToMain.setBorder(new LineBorder(Color.WHITE, 0));
		backToMain.setBounds(0, 560, 40, 40);
		add(backToMain);

		buttonNextLevel = new JButton("");
		buttonNextLevel.setIcon(new ImageIcon("images\\rsz_oie_transparent_1.png"));
		buttonNextLevel.setBounds(280, 560, 120, 40);
		buttonNextLevel.setBorder( new LineBorder(Color.red, 0));
		buttonNextLevel.setContentAreaFilled(false);
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(icon, 0, 0, this);
//		g.setColor(Color.red);
//		g.fillOval(holeX,holeY,holeRadius*2,holeRadius*2);
//		g.setColor(Color.green);
//		g.fillOval(holeSmallX,holeSmallY,holeSmallRadius*2,holeSmallRadius*2);
		g.drawImage(iconBlackHole, 250, 150, this);
		g.setColor(lvl3.getBallColor());
		g.fillOval(xBall,yBall,BallRadius*2,BallRadius*2);
		g.setColor(lvl3.getCircleColor());
		g.fillOval(xCircle,yCircle,CircleRadius*2,CircleRadius*2);
		double distance = Math.sqrt((Math.pow((xCircle + CircleRadius) - (xBall + BallRadius) ,2)) + (Math.pow((yCircle+CircleRadius) - (yBall+BallRadius),2)));
		if(distance <= CircleRadius - BallRadius)
		{
			g.setColor(Color.blue);
			if(littleCircle == 0 && levelDone == false && lost ==false)
			{
				lengthofSmallCircle = 10;
				x = xCircle + CircleRadius - radiusofSmallCircle ;
				y = yCircle + CircleRadius - radiusofSmallCircle;
				g.fillOval(x,y,lengthofSmallCircle*2,lengthofSmallCircle*2);
				g.setColor(lvl3.getBallColor());
				g.fillOval(xBall,yBall,BallRadius*2,BallRadius*2);
				timeOfColor.start();
			}
			else
			{
				g.fillOval(x,y,lengthofSmallCircle*2,lengthofSmallCircle*2);
				g.setColor(lvl3.getBallColor());
				g.fillOval(xBall,yBall,BallRadius*2,BallRadius*2);
			}
			if(littleCircle == 9 && levelDone == false && lost ==false)
			{
				timeOfColor.stop();
				timeOfLevel.stop();
				timeOfCircleMovment.stop();
				timeOfGravity.stop();
				timeofBlackHole.stop();
				setFocusable(false);
				lvl3.increamentScore();
				lblScore.setText(score + lvl3.getScore());

				add(buttonNextLevel);
				levelDone = true;
			}
			inside = false;
		}
		else
		{
			if(inside == false && levelDone == false && lost == false)
			{
				chances--;
				if(chances == 4)
				{
					labelHeart5.setIcon(null);
				}
				if(chances == 3)
				{
					labelHeart4.setIcon(null);
				}
				if(chances == 2)
				{
					labelHeart3.setIcon(null);
				}
				if(chances == 1)
				{
					labelHeart2.setIcon(null);
				}
				if(chances == 0)
				{
					labelHeart1.setIcon(null);
				}
				lvl3.updateChances(chances);
				inside = true;
				if(chances ==0)
				{
					timeOfColor.stop();
					timeOfLevel.stop();
					timeOfCircleMovment.stop();
					timeOfGravity.stop();
					timeofBlackHole.stop();
					setFocusable(false);
					lvl3.increamentScore();
					lost = true;
				}
			}
			lengthofSmallCircle = 10;
			radiusofSmallCircle = 10;
			x = xCircle + CircleRadius - radiusofSmallCircle ;
			y = yCircle + CircleRadius - radiusofSmallCircle;
			littleCircle = 0;
			g.setColor(lvl3.getBallColor());
			g.fillOval(xBall,yBall,BallRadius*2,BallRadius*2);
		}
	}


	public class Move extends KeyAdapter
	{
		public void keyPressed(KeyEvent event)
		{
			timeOfGravity.stop();
			String key  = KeyStroke.getKeyStrokeForEvent(event).toString();
			key = key.replace("pressed ", "");
			if(key.equals("UP") || key.equals("W"))
			{
				yBall = yBall - BallRadius;
				if(yBall <= 70)
					yBall = yBall + BallRadius;
			}

			if(key.equals("LEFT") || key.equals("A"))
			{
				xBall = xBall-BallRadius;
				if(xBall <= -BallRadius)
					xBall = xBall + BallRadius;
			}

			if(key.equals("RIGHT") || key.equals("D"))
			{
				xBall = xBall + BallRadius;
				if(xBall >= 400 - BallRadius)
					xBall = xBall - BallRadius;
			}

			if(key.equals("DOWN") || key.equals("S"))
			{
				yBall = yBall + BallRadius;
				if(yBall >= 600 - BallRadius)
					yBall = yBall - BallRadius;
			}
			repaint();
			timeOfGravity.start();
		}
	}


	public class Gravity implements ActionListener
	{
		public void actionPerformed(ActionEvent evnet)
		{
			yBall++;
			if(yBall >= 551)
				yBall = 550;
			if(yBall <= 0)
				yBall = yBall -  yBall;
			repaint();
		}
	}

	public class MotionOfCircle implements ActionListener
	{
		public void actionPerformed(ActionEvent evnet)
		{
			if(yCircle <= 70)
			{
				down = true;
				up = false;
				right = false;
				left = false;
			}

			if(yCircle >= 600 - CircleRadius*2)
			{
				up = true;
				down = false;
				right = false;
				left = false;
			}

			if(xCircle >= CircleRadius*2)
			{
				left = true;
				down = false;
				up = false;
				right = false;
			}

			if(xCircle <= 0)
			{
				right = true;
				down = false;
				up = false;
				left = false;
			}

			if(down == true)
			{
				yCircle = yCircle + 5;
				xCircle = xCircle + 3;
				x = x +3;
				y = y +5;
			}

			if(right == true)
			{
				yCircle = yCircle - 5;
				xCircle = xCircle + 3;
				y = y - 5;
				x = x + 3;
			}

			if(up== true)
			{
				yCircle = yCircle - 5;
				xCircle = xCircle -3;
				y = y - 5;
				x = x - 3;
			}

			if(left == true )
			{
				yCircle = yCircle + 5;
				xCircle = xCircle - 3;
				y = y + 5;
				x = x -3;
			}

			repaint();
		}
	}

	public class SizeOfSmallCircle implements ActionListener
	{
		public void actionPerformed(ActionEvent evnet)
		{
			lengthofSmallCircle = lengthofSmallCircle + 10;
			radiusofSmallCircle = radiusofSmallCircle + 10;
			x = xCircle + CircleRadius - radiusofSmallCircle ;
			y = yCircle + CircleRadius - radiusofSmallCircle;
			littleCircle ++;
			repaint();
		}
	}

	public class TimeOfTheGame implements ActionListener
	{
		public void actionPerformed(ActionEvent evnet)
		{
			lvl3.updateTime(time);
			time--;
			lblTime.setText(" "+ lvl3.getTime());
			if(time < 0)
			{
				timeOfLevel.stop();
				timeOfColor.stop();
				timeOfCircleMovment.stop();
				timeofBlackHole.stop();
				timeOfGravity.stop();
				setFocusable(false);
				lvl3.increamentScore();
				lost = true;
			}
		}
	}

	public class BlackHole implements ActionListener
	{
		public void actionPerformed(ActionEvent evnet)
		{
			double distance1 = Math.sqrt((Math.pow((holeX + holeRadius) - (xBall + BallRadius) ,2)) + (Math.pow((holeY + holeRadius) - (yBall+BallRadius),2)));
			if(distance1 <= holeRadius - BallRadius)
			{
				if(yBall < holeSmallY)
					yBall = yBall + 5;
				if(yBall > holeSmallY)
					yBall = yBall - 5;
				if(xBall < holeSmallX)
					xBall = xBall + 5;
				if(xBall > holeSmallX)
					xBall = xBall - 5;
				repaint();
				if(holeSmallX == xBall && holeSmallY == yBall)
				{
					timeofBlackHole.stop();
					timeOfLevel.stop();
					timeOfColor.stop();
					timeOfCircleMovment.stop();
					timeOfGravity.stop();
					setFocusable(false);
					lost = true;
					timeOfDis.start();
					lvl3.increamentScore();
				}
			}
		}
	}

	public class Vanish implements ActionListener
	{
		public void actionPerformed(ActionEvent evnet)
		{
			BallRadius = BallRadius - 5;
			xBall = xBall + 5;
			yBall = yBall + 5;
			lengthofSmallCircle = 0;
			if(BallRadius == 0)
			{
				timeOfDis.stop();
			}
			repaint();
		}
	}

	public void restart()
	{
		timeofBlackHole.start();
		timeOfLevel.start();
		timeOfColor.start();
		timeOfCircleMovment.start();
		timeOfGravity.start();
		timeOfLostOrNot.start();
		setFocusable(true);
		littleCircle = 0;
		time = 20;
		chances = 5;
		//lvl3.resetScore();
		xBall = lvl3.getStartPointOfBall().x;
		yBall = lvl3.getStartPointOfBall().y;
		xCircle = lvl3.getStartPointOfCircle().x;
		yCircle = lvl3.getStartPointOfCircle().y;
		BallRadius = lvl3.getBallRadius();
		levelDone = false;
		lost = false;
		inside = true;
		remove(buttonNextLevel);
		lblScore.setText(score + lvl3.getScore());
		labelHeart1.setIcon(new ImageIcon("images\\rsz_heart_icon.png"));
		labelHeart2.setIcon(new ImageIcon("images\\rsz_heart_icon.png"));
		labelHeart3.setIcon(new ImageIcon("images\\rsz_heart_icon.png"));
		labelHeart4.setIcon(new ImageIcon("images\\rsz_heart_icon.png"));
		labelHeart5.setIcon(new ImageIcon("images\\rsz_heart_icon.png"));

	}
	public void updateLanguage(String lang)
	{
		if(lang.equals("Aze"))
		{
			score = "Bal: ";
		}
		if(lang.equals("Eng"))
		{
			score = "Score: ";
		}
		if(lang.equals("Rus"))
		{
			score = "Счёт: ";
		}
		if(lang.equals("Trk"))
		{
			score = "Puan: ";
		}
	}
	public JButton getbuttonNextLevel()
	{
		return buttonNextLevel;
	}
	public JButton getbackToMain() 
	{
		return backToMain;
	}
	public JButton getSoundButton()
	{
		return  soundButton;
	}
	public void listenerToLostOrNot(ActionListener a)
	{
		timeOfLostOrNot.addActionListener(a);
	}
	public boolean getLost()
	{
		return lost;
	}
	public Timer getTimeOfLostOrNot()
	{
		return timeOfLostOrNot;
	}
	public int getScore()
	{
		return lvl3.getScore();
	}
}