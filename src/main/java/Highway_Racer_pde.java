import java.awt.Frame;

import javax.swing.WindowConstants;

import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.awt.PSurfaceAWT;
import processing.awt.PSurfaceAWT.SmoothCanvas;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

//import Highway_Racer_pde.car;
//import Highway_Racer_pde.carPosition;
//import Highway_Racer_pde.roadLine;
//import Highway_Racer_pde.tree;
 /*
  * Dependecy Error for pom.xml
  * <dependency>
			<groupId>org.clojars.automata</groupId>
			<artifactId>jsminim</artifactId>
			<version>2.1.0</version>
			
		</dependency> 
  */

public class Highway_Racer_pde extends PApplet {

AudioPlayer[] player = new AudioPlayer[1]; 
Minim minim; 
//FFT fft; 
float val; 
int val2; 
//int bufferSize = 8; 
//int fftSize = floor(bufferSize*.9)+1; 
int count=0;
PImage lambo,bugatti,wowzer,ow,greenCar;
PFont dab,daber;
roadLine a,b,c,d,e,f,g,h,i,j;
tree r,t;
carPosition[] garbage=new carPosition[3];
int[] position =new int[4];
car wow,ouch,green;
int tick,y,gameState,carType;
int place=1;
boolean boyz, woz;
boolean startNew;

public static final int delay = 10;

public void start(boolean dab)//input to build an applet
{
	
	woz=dab;
	if(woz==true)//if input is true, will build applet
	{
	String[] appletArgs = new String[] {"Highway_Racer_pde"};
    PApplet.main(appletArgs);
    
	}
}
@Override
public void setup()
{
  
  
  gameState=0;
  tick=0;
  y=-144; 
  minim = new Minim(this); 
  count=0;
  player[0] = minim.loadFile("extremeaction.mp3"); 
  player[count].setGain(-10);
  player[count].play(); 
  dab=createFont("Comic Sans MS",32);
  daber=createFont("Arial",12);
  background(0,100,0);
  
  fill(50);
  rect(100,0,400,800);
  fill(150);
  rect(80,-1,20,801);
  rect(500,-1,20,801);
  lambo=loadImage("lambo.jpg");
  bugatti=loadImage("bugatti.jpg");
  wowzer=loadImage("tree.jpg");
  ow=loadImage("redbasiccar.jpg");
  greenCar=loadImage("greenbasiccar.jpg");
  garbage[0]= new carPosition(140,600);
  garbage[1]= new carPosition(275,600);
  garbage[2]= new carPosition(415,600);
  position[0]=140;
  position[1]=275;
  position[2]=415;
  position[3]=0;
  wow=new car(garbage[1],bugatti,"main");
  ouch=new car(position[(int)random(0,3)],-147,ow,"fake");
  green=new car(position[3],-147,greenCar,"fake");
  r= new tree(0,-144,wowzer);
  t= new tree(501,-144,wowzer);  
  a=new roadLine(225,10,10,100);
  b=new roadLine(225,210,10,100);
  c=new roadLine(225,410,10,100);
  d=new roadLine(225,610,10,100);
  e=new roadLine(365,10,10,100);
  f=new roadLine(365,210,10,100);
  g=new roadLine(365,410,10,100);
  h=new roadLine(365,610,10,100);
  i=new roadLine(225,-190,10,100);
  j=new roadLine(365,-190,10,100);
  //fill(255,0,0);
  //rect(247,323,100,50);
  fill(255);
  textAlign(CENTER);
  text("Choose a car to start",300,350);
  textFont(dab);
  text("Highway Racer",300,100);
  image(bugatti,100,300);
  image(lambo,450,300);
  startNew=false;
  //noLoop();
}
class roadLine
{
  int x,y;
  int w,h;
  roadLine(int xpos, int ypos, int width, int height)
  {
    x=xpos;
    y=ypos;
    w=width;
    h=height;
  }
  public void drawLine()
  {
    fill(255,170,0);
    rect(x,y,w,h);
  }
  public void moveUp()
  {
    fill(50);
    rect(x,y,w,h);
    y=y-h;
  }
  public void moveDown()
  {
    fill(50);
    rect(x,y,w,h);
    y=y+h;
  }
}
class carPosition
{
  int xpos,ypos;
  carPosition(int x,int y)
  {
    xpos=x;
    ypos=y;
  }
  public int getX()
  {
    return xpos;
  }
  public int getY()
  {
    return ypos;
  }
}
class car
{
  int xpos,ypos,speed,go;
  carPosition z;
  String type;
  PImage i;
  car(carPosition a, PImage img,String t)
  {
    xpos=a.getX();
    ypos=a.getY();
    i=img;
    speed=(int)random(7,15);
    type=t;
    go=1;
    if(!(type.equals("main")))
    {
      go=(int)random(0,1);
    }
  }
  car(int x,int y,PImage img,String t)
  {
    xpos=x;
    ypos=y;
    i=img;
    type=t;
    speed=5;
    go=(int)random(0,1);
  }
  public int getX()
  {
    return xpos;
  }
  public int getY()
  {
    return ypos;
  }
  public PImage getImg()
  {
    return i;
  }
  public void draw()
  {
      image(i, xpos, ypos);
  }
  public void changePos(int x)
  {
    int other=x;
    int a=(int)random(1,4);
      //println(a);
      if(a==1&&(other!=140))
      {
        xpos=140;//position[0];
      }
      else if(a==2&&(other!=275))
      {
        xpos=275;//position[1];
      }
      else if(a==3&&(other!=415))
      {
        xpos=415;//position[2];
      }
  }
  public void move(int x)
  {
    int other=x;
    ypos+=speed;
    if(ypos>800)
    {     
      int a=(int)random(1,4);
      //println(a);
      if(a==1&&(other!=140))
      {
        xpos=140;//position[0];
      }
      else if(a==2&&(other!=275))
      {
        xpos=275;//position[1];
      }
      else if(a==3&&(other!=415))
      {
        xpos=415;//position[2];
      }
      ypos=-144;
      if(speed<20)
      {
        speed+=1;
      }
      go=(int)random(0,1);
    }
  }
}
class tree
{
  int xpos,ypos,speed;
  PImage i;
  tree(int x,int y,PImage img)
  {
    xpos=x;
    ypos=y;
    i=img;
    speed=5;
  }
  public int getX()
  {
    return xpos;
  }
  public int getY()
  {
    return ypos;
  }
  public void draw()
  {
    image(i,xpos,ypos);
  }
  public void move()
  {
    ypos+=speed;
    if(ypos>800)
    {
      ypos=-144;
    }
    if(speed<20)
    {
      speed++;
    }
  }
}

public void draw()
{
  if(player[count].isPlaying()==false)
  {
	  player[count].play();
  }
  if(gameState==0)
  {
    image(bugatti,100,300);
    image(lambo,450,300);
  }
  if(gameState==1)
  {
    if(y>850)
    {
      y=-144;
    }
    if(tick/60==10)
    {
      green=new car(position[(int)random(0,3)],-147,greenCar,"fake");
    }
    tick++;
    drawMap();
    wow.draw();
    //ouch.draw();
    if((green.getX()!=ouch.getX())&&tick/60>10)
    {
      green.draw();
      green.move(ouch.getX());
      ouch.draw();
      ouch.move(green.getX());
      println("lets go"+tick);
    } 
    else if((green.getX()==ouch.getX())&&tick/60>10)
    {
      green.changePos(ouch.getX());
      println("nope"+tick);
      green.draw();
      green.move(ouch.getX());
      ouch.draw();
      ouch.move(green.getX());
    } 
    if(tick/60<10)
    {
      ouch.draw();
      ouch.move(green.getX());
    }
    println("zoom"+tick);
    //ouch.move(green.getX());
    r.draw();
    if(tick/60>1)
    {
      t.draw();
      t.move();
    }
    r.move();
    a.drawLine();
    b.drawLine();
    c.drawLine();
    d.drawLine();
    e.drawLine();
    f.drawLine();
    g.drawLine();
    h.drawLine();
    i.drawLine();
    j.drawLine();
    h.drawLine();
    d.drawLine();
    fill(255);
    textAlign(CENTER);
    textFont(daber);
    //text(tick, 300, 50);
    text(tick/60,300,50);
    if(tick%15==0&&place==1)
    {
      a.moveDown();
      b.moveDown();
      c.moveDown();
      d.moveDown();
      e.moveDown();
      f.moveDown();
      g.moveDown();
      h.moveDown();
      i.moveDown();
      j.moveDown();
      place=2;
    }
    else if(tick%15==0&&place==2)
    {
      a.moveUp();
      b.moveUp();
      c.moveUp();
      d.moveUp();
      e.moveUp();
      f.moveUp();
      g.moveUp();
      h.moveUp();
      i.moveUp();
      j.moveUp();
      place=1;
    }
    if(((wow.getY()>=ouch.getY()&&wow.getY()<=ouch.getY()+97)||(wow.getY()+110>=ouch.getY()&&wow.getY()+110<=ouch.getY()+97)||(wow.getY()+55>=ouch.getY()&&wow.getY()+55<=ouch.getY()+97))&&wow.getX()==ouch.getX())
    {
      fill(50);
      rect(250,25,100,50);
      fill(255);
      text("Click to Start Over",300,50);
      text("YOU LOSE",300,100);
      text("Time: " + tick/60,300,150);
      gameState=2;
    }
    else if(((wow.getY()>=green.getY()&&wow.getY()<=green.getY()+97)||(wow.getY()+110>=green.getY()&&wow.getY()+110<=green.getY()+97)||(wow.getY()+55>=green.getY()&&wow.getY()+55<=green.getY()+97))&&wow.getX()==green.getX())
    {
      fill(50);
      rect(250,25,100,50);
      fill(255);
      text("Click to Start Over",300,50);
      text("YOU LOSE",300,100);
      text("Time: " + tick/60,300,150);
      gameState=2;
    }
  }
}
public void drawMap()
{
  background(0,100,0);
  fill(50);
  rect(100,0,400,800);
}
public void keyPressed() {
  if (key == CODED) {
    if (keyCode == RIGHT&&carType==1) 
    {
      
      if(wow.getX()==140)
      {
        //println("dab on em");
        wow= new car(garbage[1],bugatti,"main");
      }
      else if(wow.getX()==275)
      {
        //println("dab on em");
        wow= new car(garbage[2],bugatti,"main");      
      }
    } else if (keyCode == LEFT&&carType==1) 
    {
      
      if(wow.getX()==275)
      {
        //println("dab on em");
        wow= new car(garbage[0],bugatti,"main");
      }
      if(wow.getX()==415)
      {
        //println("dab on em");
        wow= new car(garbage[1],bugatti,"main");        
      }
    } 
    if (keyCode == RIGHT&&carType==2) 
    {
      
      if(wow.getX()==140)
      {
        //println("dab on em");
        wow= new car(garbage[1],lambo,"main");
      }
      else if(wow.getX()==275)
      {
        //println("dab on em");
        wow= new car(garbage[2],lambo,"main");      
      }
    } else if (keyCode == LEFT&&carType==2) 
    {
      
      if(wow.getX()==275)
      {
        //println("dab on em");
        wow= new car(garbage[0],lambo,"main");
      }
      if(wow.getX()==415)
      {
        //println("dab on em");
        wow= new car(garbage[1],lambo,"main");        
      }
    }
  } 
  else 
  {
  }
}
public void mouseClicked()
{
  /*if((mouseX>=247&&mouseX<=347)&&(mouseY>=323&&mouseY<=373)&&gameState==0)
  {
    gameState=1;
    loop();
  }*/
  if((mouseX>=250&&mouseX<=350)&&(mouseY>=25&&mouseY<=75)&&gameState==2)
  {
    player[count].pause();
    setup();
	  
	  
  }
  if((mouseX>=100&&mouseX<=150)&&(mouseY>=300&&mouseY<=400)&&gameState==0)
  { 
    gameState=1;
    loop();
    wow=new car(garbage[1],bugatti,"main");
    carType=1;
    
    /* 
     Taylor's code
     Frame frame = ( (SmoothCanvas) ((PSurfaceAWT)surface).getNative()).getFrame();
	  frame.dispose();
	  */
    
  }
  if((mouseX>=450&&mouseX<=500)&&(mouseY>=300&&mouseY<=400)&&gameState==0)
  {
    gameState=1;
    loop();
    wow=new car(garbage[1],lambo,"main");
    carType=2;
  }
}
  @Override
public void settings() {  size(600,800); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Highway_Racer_pde" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
