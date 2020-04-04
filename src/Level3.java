import java.awt.*;

public class Level3 extends Levels
{
   
   public Level3(Circle circle, Ball ball)
   {
      super(circle,ball);
      setTime(15);
      circle.setColor(Color.white);
      ball.setColor(Color.yellow);
      circle.setRadius(100);
      ball.setRadius(25);
      circle.setPoint(new Point(100,70));
      ball.setPoint(new Point(175,550));
      setLevel(3);
   }
}