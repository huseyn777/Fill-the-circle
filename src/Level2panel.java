import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import java.io.*;
import java.util.ArrayList;

public class Level2panel extends JPanel implements FillTheCircleView{

	/**
	 * Create the panel.
	 */

	private final double GRAVITY;
	private Levels level2;
	private boolean levelDone,lost;
	private boolean up,down,left,right;
	private int xBall,yBall;
	private int xCircle,yCircle;
	private int BallRadius,CircleRadius;
	private Timer timeOfCircleMovment,timeOfColor,timeOfLevel,timeOfGravity, timeOfLostOrNot;
	private int x,y;
	private int lengthofSmallCircle,radiusofSmallCircle;
	private int littleCircle;
	public int chances;
	private boolean inside;
	private int time;
	//GUI
	private JLabel lblTime, lblScore;
	private Image icon;
	private JButton buttonNextLevel,backToMain,soundButton;
	private JLabel labelHeart1,labelHeart2,labelHeart3, labelHeart4, labelHeart5;
	private String score;

	// extra balls
	private final int WIDTH = 400, HEIGHT = 600;
	private final int DELAY = 20, IMAGE_SIZE = 50;
	private int numOfDistractionBalls;
	private ArrayList<DistractionBall> distractionBalls;

	private ImageIcon distractionBallImage;
	private Timer timerExtraBalls;

	public Level2panel(Levels level2) 
	{
		this.level2 = level2;
		GRAVITY = level2.getGravity();
		time = level2.getTime();
		xBall = level2.getStartPointOfBall().x;
		yBall = level2.getStartPointOfBall().y;
		xCircle = level2.getStartPointOfCircle().x;
		yCircle = level2.getStartPointOfCircle().y;
		BallRadius = level2.getBallRadius();
		CircleRadius = level2.getCircleRadius();
		radiusofSmallCircle = 10;
		chances = level2.getChances();
		inside = true;

		addKeyListener(new Move());
		timeOfGravity = new Timer((int)Math.sqrt(600/(GRAVITY/2)),new Gravity());
		timeOfCircleMovment = new Timer(45, new MotionOfCircle());
		timeOfColor = new Timer(500, new SizeOfSmallCircle());
		timeOfLevel = new Timer(1000,new TimeOfTheGame());
		timeOfLostOrNot = new Timer(1000, null);
		timeOfLevel.start();
		timeOfCircleMovment.start();
		setFocusable(true);


		setForeground(Color.BLACK);
		setLayout(null);
		setPreferredSize(new Dimension(400,600));

		try {
			icon = new ImageIcon("images\\rsz_level1.jpg").getImage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		JLabel levelLabel = new JLabel("Level 2");
		levelLabel.setForeground(new Color(253, 245, 230));
		levelLabel.setBackground(Color.LIGHT_GRAY);
		levelLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		levelLabel.setHorizontalAlignment(SwingConstants.CENTER);
		levelLabel.setBounds(163, 0, 96, 36);
		add(levelLabel);
		score = "Score: ";
		lblScore = new JLabel(score + level2.getScore());
		lblScore.setText(score  + level2.getScore());
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

		// extra balls
		timerExtraBalls = new Timer(DELAY, new ExtraBallsListener());

		distractionBallImage = new ImageIcon ("images\\blueBall.png");
		numOfDistractionBalls = 15;
		distractionBalls = new ArrayList<>();
		for(int i = 0; i < numOfDistractionBalls; i++) {
			distractionBalls.add(new DistractionBall(i * 20, 70 + i * 30, 3 + i));
		}


		setPreferredSize (new Dimension(WIDTH, HEIGHT));
		timerExtraBalls.start();
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		g.drawImage(icon, 0, 0, this);
		g.setColor(level2.getBallColor());
		g.fillOval(xBall,yBall,BallRadius*2,BallRadius*2);
		g.setColor(level2.getCircleColor());
		g.fillOval(xCircle,yCircle,CircleRadius*2,CircleRadius*2);


		for(int i = 0; i < numOfDistractionBalls; i++) {
			g.drawImage(distractionBallImage.getImage(), distractionBalls.get(i).getX(), distractionBalls.get(i).getY(), this);
		}

		double distance = Math.sqrt((Math.pow((xCircle + CircleRadius) - (xBall + BallRadius) ,2)) + (Math.pow((yCircle+CircleRadius) - (yBall+BallRadius),2)));
		if(distance <= CircleRadius - BallRadius && lost == false && levelDone == false)
		{
			g.setColor(Color.yellow);
			if(littleCircle == 0)
			{
				lengthofSmallCircle = 10;
				x = xCircle + CircleRadius - radiusofSmallCircle ;
				y = yCircle + CircleRadius - radiusofSmallCircle;
				g.fillOval(x,y,lengthofSmallCircle*2,lengthofSmallCircle*2);
				g.setColor(level2.getBallColor());
				g.fillOval(xBall,yBall,BallRadius*2,BallRadius*2);
				timeOfColor.start();
				for(int i = 0; i < numOfDistractionBalls; i++) {
					g.drawImage(distractionBallImage.getImage(), distractionBalls.get(i).getX(), distractionBalls.get(i).getY(), this);
				}
			}
			else
			{
				g.fillOval(x,y,lengthofSmallCircle*2,lengthofSmallCircle*2);
				g.setColor(level2.getBallColor());
				g.fillOval(xBall,yBall,BallRadius*2,BallRadius*2);
				for(int i = 0; i < numOfDistractionBalls; i++) {
					g.drawImage(distractionBallImage.getImage(), distractionBalls.get(i).getX(), distractionBalls.get(i).getY(), this);
				}
			}
			if(littleCircle == 9 && levelDone == false && lost ==false)
			{
				buttonNextLevel.setVisible(true);
				timeOfColor.stop();
				timeOfLevel.stop();
				timeOfCircleMovment.stop();
				timeOfGravity.stop();
				timerExtraBalls.stop();
				setFocusable(false);
				level2.increamentScore();
				levelDone = true;

				lblScore.setText(score + level2.getScore());

				add(buttonNextLevel);
				

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

				level2.updateChances(chances);
				inside = true;
				if(chances == 0)
				{
					timeOfColor.stop();
					timeOfLevel.stop();
					timeOfCircleMovment.stop();
					timerExtraBalls.stop();
					setFocusable(false);
					level2.increamentScore();
					lost = true;
				}
			}
			lengthofSmallCircle = 10;
			radiusofSmallCircle = 10;
			x = xCircle + CircleRadius - radiusofSmallCircle ;
			y = yCircle + CircleRadius - radiusofSmallCircle;
			littleCircle = 0;
			g.setColor(level2.getBallColor());
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

			if(up == true)
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
		public void actionPerformed(ActionEvent event)
		{
			level2.updateTime(time);
			time--;
			lblTime.setText(" "+ level2.getTime());
			if(time < 0)
			{
				timeOfLevel.stop();
				timeOfColor.stop();
				timeOfCircleMovment.stop();
				timerExtraBalls.stop();
				setFocusable(false);
				level2.increamentScore();
				lost = true;
			}
		}
	}

	// extra balls listener
	public class ExtraBallsListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
		{

			for(int i = 0; i < numOfDistractionBalls; i++) {
				distractionBalls.get(i).update();
			}

			repaint();
		}
	}

	public void restart()
	{
		timeOfLevel.start();
		timeOfColor.start();
		timeOfCircleMovment.start();
		timeOfGravity.start();
		timerExtraBalls.start();
		timeOfLostOrNot.start();
		setFocusable(true);
		littleCircle = 0;
		time = 20;
		chances = 5;
		levelDone = false;
		lost = false;
		inside = true;
		//level2.resetScore();
		buttonNextLevel.setVisible(false);
		xBall = level2.getStartPointOfBall().x;
		yBall = level2.getStartPointOfBall().y;
		xCircle = level2.getStartPointOfCircle().x;
		yCircle = level2.getStartPointOfCircle().y;
		lblScore.setText(score + level2.getScore());
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
		return level2.getScore();
	}
}
