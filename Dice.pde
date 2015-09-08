int setupSize = 500;
void setup()
{

  size(setupSize,setupSize);
  noLoop();
}
void draw()
{
  background(0);
  Die dice = new Die(100,100,50);//your code here
  dice.roll();
  dice.show();
  
}
void mousePressed()
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
  void roll()
  {
    pip = (int)(Math.random()*6)+1;//your code here
  }
  void show()
  {
    rect(dieX,dieY,dieSize,dieSize);//your code here
    if(pip == 1 || pip == 3 || pip == 5)//goes to the center of the cube
    {
      ellipse(dieX + dieSize/2, dieY + dieSize/2, dot, dot);
    }
    
    if(pip == 2 || pip == 3 || pip == 4 || pip == 5 || pip == 6)//goes to top right and lowerleft     
    {
      ellipse(dieX + (dieSize * 0.75), dieY + (dieSize * 0.25), dot, dot);
      ellipse(dieX + (dieSize * 0.25), dieY + (dieSize * 0.75), dot, dot);
    }
    
    if(pip == 4 || pip == 5 || pip == 6)//top left and lower right
    {
      ellipse(dieX + (dieSize * 0.25), dieY + (dieSize * 0.25), dot, dot);      
      ellipse(dieX + (dieSize * 0.75), dieY + (dieSize * 0.75), dot, dot);
    }
    
    if(pip == 6)//center dot
    {
      ellipse(dieX+(dieSize * 0.25),dieY+(dieSize * 0.5), dot, dot);      
      ellipse(dieX+(dieSize * 0.75),dieY+(dieSize * 0.5), dot, dot);
    }
  }
}
