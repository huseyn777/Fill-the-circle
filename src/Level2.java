import java.awt.*;

public class Level2 extends Levels
{
 public Level2(Circle circle, Ball ball)
    {
       super(circle,ball);
       setTime(20);
       circle.setColor(new Color(240,255,255));
       ball.setColor(new Color(34, 144, 255));
       circle.setRadius(100);
       ball.setRadius(25);
       circle.setPoint(new Point(100,70));
       ball.setPoint(new Point(175,550));
       setLevel(2);
    }
}
