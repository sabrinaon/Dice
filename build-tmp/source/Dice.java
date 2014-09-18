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

int sum = 0;
Die one;
public void setup()
{
	size(500,500);
	noLoop();
}
public void draw()
{
	background(200,75,60);
	for(int y = 10; y <= 400; y = y + 60)
	{
		for(int x = 10; x <= 460; x = x + 60)
		{
			one = new Die(x,y);
			one.roll();
			one.show();
			sum = sum + one.numDots;
		}
	}
	textSize(15);
	fill(0);
	text("Total:" + sum,10,470);
}
public void mousePressed()
{
	redraw();
	sum = 0;
}
class Die //models one single dice cube
{
	//variable declarations here
	int myX, myY, numDots;
	Die(int x, int y) //constructor
	{
		myX = x;
		myY = y;
	}
	public void roll()
	{
		numDots = (int)(Math.random()*6+1);
	}
	public void show()
	{
		//your code here
		fill(255);
		rect(myX,myY,50,50);
		fill(0);
		if (numDots == 1)
		{
			ellipse(myX + 25, myY + 25, 10, 10);
		}
		if (numDots == 2)
		{
			ellipse(myX + 15, myY + 15, 10, 10);
			ellipse(myX + 35, myY + 35, 10, 10);
		}
		if (numDots == 3)
		{
			ellipse(myX + 12, myY + 12, 10, 10);
			ellipse(myX + 24, myY + 24, 10, 10);
			ellipse(myX + 36, myY + 36, 10, 10);
		}
		if (numDots == 4)
		{
			ellipse(myX + 15, myY + 15, 10, 10);
			ellipse(myX + 35, myY + 15, 10, 10);
			ellipse(myX + 15, myY + 35, 10, 10);
			ellipse(myX + 35, myY + 35, 10, 10);
		}
		if (numDots == 5)
		{
			ellipse(myX + 12, myY + 12, 10, 10);
			ellipse(myX + 25, myY + 25, 10, 10);
			ellipse(myX + 37, myY + 39, 10, 10);
			ellipse(myX + 37, myY + 12, 10, 10);
			ellipse(myX + 12, myY + 39, 10, 10);
		}
		if (numDots == 6)
		{
			ellipse(myX + 14, myY + 10, 10, 10);
			ellipse(myX + 36, myY + 40, 10, 10);
			ellipse(myX + 14, myY + 25, 10, 10);
			ellipse(myX + 36, myY + 25, 10, 10);
			ellipse(myX + 36, myY + 10, 10, 10);
			ellipse(myX + 14, myY + 40, 10, 10);
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
