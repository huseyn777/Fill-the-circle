import java.awt.Color;
import java.awt.Point;

public class Circle
{
   private int radius;
   private Point point;
   private Color color;
   
   public Circle()
   {
      radius = 0;
      point  = new Point(0,0);
   }
   
   public void setRadius(int r)
   {
      radius = r;
   }
   
   
   public  void setPoint(Point p)
   {
      point = p;
   }
   
   
   public void setColor(Color c)
   {
      color = c;
   }
   
   
   public int getRadius()
   {
      return radius;
   }
   
   
   public Point getPoint()
   {
      return point;
   }
   
   
   public Color getColor()
   {
      return color;
   }
}