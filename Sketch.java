import processing.core.PApplet;
import processing.core.PFont;

import java.util.Random;

public class Sketch extends PApplet {

  Random myRandom = new Random();

  public void settings() {
    size(500, 500);
  }
  
  public void draw() {
    
    //Declares the time variables:
    int hour = hour();
    int minutes = minute();
    int seconds = second();
    int year = year();
    int month = month();
    int day = day();

    boolean isDay;
    //Determines whether it is day or not. If the seconds is under 30, it is day, if it is over then it is night.
    if(seconds >= 30){
      isDay = false;
    }
    else{
      isDay = true;
    }

    //Finds the sun X position based on the seconds value
    int sunLocationX = (int)((double)seconds / 30 * width);
    //Finds the sun Y position based on the location of X using a parabola function
    int sunLocationY = (int)(0.008 * Math.pow(sunLocationX - 250, 2));
    //Calculates the colour of the sun based on the sun location(The higher it is means more yellowish, the lower it is means more reddish)
    int sunColourG = (int)(200 - (((double)sunLocationY / 500) * 100));

    //Calculates the background colour
    if(isDay){
      background((int)(255 - (double)(seconds / 30) * 184), (int)(171 + (double)(seconds / 30) * 20), (int)(255 - (double)(seconds / 30) * 158));
    }
    if(isDay == false){
      background((int)(255 - (double)(sunLocationX)));
    }

    //Draws the sun
    fill(255, sunColourG, 0);
    stroke(255, sunColourG, 0);
    ellipse(sunLocationX, sunLocationY, (float)(width * 0.25), (float)(height * 0.25));

    //Clouds
    fill(255, 255, 255);
    stroke(255, 255, 255);
    ellipse((float)(width / 4), (float)(height / 4), (float)(width / 8), (float)(height / 8));
    ellipse((float)(width / 4) + (float)(width / 10), (float)(height / 4), (float)(width / 8), (float)(height / 8));
    ellipse((float)(width / 4) + (float)(width / 10) * 2, (float)(height / 4), (float)(width / 8), (float)(height / 8));

    //Draws the ground
    fill(29, 201, 2);
    strokeWeight(0);
    rect(0, (float)(height / 1.14), width, (float)(height / 8));
    
    //Draws base of the house
    fill(255, 222, 59);
    strokeWeight(0);
    rect((float)(width / 1.6), (float)(height / 1.6), (float)(width / 4), (float)(height / 4));

    //Draws door of the house
    fill(122, 81, 58);
    stroke(185, 122, 87);
    strokeWeight((float)(width / 80));
    rect((float)(width / 1.5), (float)(height / 1.33), (float)(width / 20), (float)(height / 8));

    //Draws window of the house
    fill(255, 255, 255);
    stroke(0, 0, 0);
    strokeWeight(2);
    rect((float)(width / 1.33), (float)(height / 1.33), (float)(width / 10), (float)(height / 10));

    //Draws the roof of the house
    fill(166, 0, 0);
    strokeWeight(0);
    triangle((float)(width / 1.6), (float)(height / 1.6), (float)(width / 1.33), (float)(height / 2), (float)(width / 1.14), (float)(height / 1.6));

    //Draws a tree
    //Stem:
    stroke(122, 81, 58);
    strokeWeight((float)(width/16));
    line((float)(width / 4), (float)(height / 1.14), (float)(width / 4), (float)(height / 1.6));
    //Leaves:
    strokeWeight(0);
    fill(4, 122, 0);
    ellipse((float)(width / 4), (float)(height / 2), (float)(width / 4), (float)(height / 4));

    //Declares the font:
    PFont timeFont = createFont("Roboto", 20);
    textFont(timeFont, 20);
    fill(0, 0, 0);

    //Prints the time
    text(hour + " : " + minutes + " : " + seconds, (float)(width * 0.8), (float)(height * 0.93));
    text(year + " / " + month + " / " + day, (float)(width * 0.74), (float)(height * 0.98));
  }
}