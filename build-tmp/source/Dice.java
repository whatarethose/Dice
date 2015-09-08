import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Dice extends PApplet {

int setupSize = 500;
public void setup()
{

  size(setupSize,setupSize);
  noLoop();
}
public void draw()
{
  background(0);
  Die dice = new Die(100,100,50);//your code here
  dice.roll();
  dice.show();
  
}
public void mousePressed()
{
  redraw();
}
class Die //models one single dice cube
{
  int dieX,dieY,pip,dieSize,dot;//variable declarations here
  Die(int x, int y,int size) //constructor
  {
    dieX = x;
    dieY = y;//variable initializations here
    dieSize = size;//size of square
    dot=dieSize/5;//size of dots
  }
  public void roll()
  {
    pip = (int)(Math.random()*6)+1;//your code here
  }
  public void show()
  {
    rect(dieX,dieY,dieSize,dieSize);//your code here
    if(pip == 1 || pip == 3 || pip == 5)
    //show center dot
    {
      ellipse(dieX + dieSize/2, dieY + dieSize/2, dot, dot);
    }
    
    if(pip == 2 || pip == 3 || pip == 4 || pip == 5 || pip == 6)
    //show top right dot and lower left dot
    {
      ellipse(dieX + (dieSize * 0.75f), dieY + (dieSize * 0.25f), dot, dot);      
      ellipse(dieX + (dieSize * 0.25f), dieY + (dieSize * 0.75f), dot, dot);
    }
    
    if(pip == 4 || pip == 5 || pip == 6)
    //show top left dot and lower right dot
    {
      ellipse(dieX + (dieSize * 0.25f), dieY + (dieSize * 0.25f), dot, dot);      
      ellipse(dieX + (dieSize * 0.75f), dieY + (dieSize * 0.75f), dot, dot);
    }
    
    if(pip == 6)
    //show center side dots
    {
      ellipse(dieX+(dieSize * 0.25f),dieY+(dieSize * 0.5f), dot, dot);      
      ellipse(dieX+(dieSize * 0.75f),dieY+(dieSize * 0.5f), dot, dot);
    }
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Dice" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
