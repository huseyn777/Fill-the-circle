public class DistractionBall {

 private int x;
 private int y;
 private int xMove;
 private int yMove;

 public DistractionBall(int x, int y, int speed) {
  this.x = x;
  this.y = y;
  this.xMove = speed;
  this.yMove = speed;
 }
 
 public void update() {
  x += xMove;
  y += yMove;
  
  if(x <= 0 || x >= 400 - 50)
   xMove *= -1;
  if (y <= 70 || y >= 600 - 50)
   yMove *= -1;
 }
 
 public int getX() {
  return x;
 }
 
 public int getY() {
  return y;
 }
}
