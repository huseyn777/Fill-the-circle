import java.awt.*;


public class Levels
{
   private int chances;
   public static int score;
   private int time;
   private Circle circle;
   private Ball ball;
   private int level;
   
   public Levels(Circle circle,Ball ball)
   {
      this.circle = circle;
      this.ball = ball;
      chances = 5;
   }
   
   
   public void setLevel(int level)
   {
      this.level = level;
   }
   
   
   public int getChances()
   {
      return chances;
   }
   
   
   public void increamentScore()
   {
      score = score + (level * chances * time * 10);
   }
   
   public void resetScore()
   {
	   score = 0;
   }
   public int getScore()
   {
      return score;
   }
   public static int getScoreStatic()
   {
	   return score;
   }
   
   public void setTime(int time)
   {
      this.time = time;
   }
   
   
   public int getTime()
   {
      return time;
   }
   
   
   public Color getCircleColor()
   {
      return circle.getColor();
   }
   
   
   public Color getBallColor()
   {
      return ball.getColor();
   }
   
   
   public int getCircleRadius()
   {
      return circle.getRadius();
   }
   
   
   public int getBallRadius()
   {
      return ball.getRadius();
   }
   
   
   public Point getStartPointOfCircle()
   {
      return circle.getPoint();
   }
   
   
   public Point getStartPointOfBall()
   {
      return ball.getPoint();
   }
   
   
   public double getGravity()
   {
      return ball.getGravity();
   }
   
   
  public void updateChances(int chances)
  {
     if(chances >=0)
        this.chances = chances;
  }
  
  public void updateTime(int time)
  {
     this.time = time;
  }
}