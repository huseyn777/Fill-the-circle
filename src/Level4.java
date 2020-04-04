import java.awt.Color;
import java.awt.Point;

public class Level4 extends Levels{

 public Level4(Circle circle, Ball ball)
 {
  super(circle,ball);
  setTime(20);
  circle.setColor(new Color(240,255,255));
  ball.setColor(Color.green);
  circle.setRadius(100);
  ball.setRadius(25);
  circle.setPoint(new Point(100,70));
  ball.setPoint(new Point(175,525));
  setLevel(1);
 }
}
