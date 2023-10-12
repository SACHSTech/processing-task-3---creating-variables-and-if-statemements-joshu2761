import processing.core.PApplet;
import processing.core.PFont;

import java.util.Random;

public class Sketch extends PApplet {

  Random myRandom = new Random();
  //Randomizes cloud location
  //Cloud 1:
  int cloud1LocationX = myRandom.nextInt(500);
  int cloud1LocationY = myRandom.nextInt(250);
  //Cloud 2: 
  int cloud2LocationX = myRandom.nextInt(500);
  int cloud2LocationY = myRandom.nextInt(250);


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
    //When it is day it shifts between a gradiant of orange at sunrise/sunset and blueish colour at midday
    if(isDay){
      background((int)(82 + (double)sunLocationY / 500 * 173), 154, (int)(255 - (double)sunLocationY / 500 * 173));
    }
    //When it is night time, it shifts between a gradiant of dark blue at dawn/dusk and pitch black at midnight
    else{
      background(0, (int)(0.12 * Math.pow(seconds - 45, 2)), (int)(0.27 * Math.pow(seconds - 45, 2)));
    }

    //Draws the sun
    fill(255, sunColourG, 0);
    stroke(255, sunColourG, 0);
    ellipse(sunLocationX, sunLocationY, (float)(width * 0.25), (float)(height * 0.25));


    //Clouds
    //Calculates color of clouds based on time of day
    //At night time it shifts from white to a dark gray
    if(!isDay){
      fill((int)(Math.pow(seconds - 45, 2)) + 20, (int)(Math.pow(seconds - 45, 2) + 20), (int)(Math.pow(seconds - 45, 2) + 20));
      stroke((int)(Math.pow(seconds - 45, 2) + 20), (int)(Math.pow(seconds - 45, 2) + 20), (int)(Math.pow(seconds - 45, 2) + 20));
    }
    //at day time it is white
    else{
      fill(255, 255, 255);
      stroke(255, 255, 255);
    }
    //Cloud 1:
    ellipse(cloud1LocationX, cloud1LocationY, (float)(width / 8), (float)(height / 8));
    ellipse(cloud1LocationX + (float)(width / 10), cloud1LocationY, (float)(width / 8), (float)(height / 8));
    ellipse(cloud1LocationX + (float)(width / 10) * 2, cloud1LocationY, (float)(width / 8), (float)(height / 8));
    //Cloud 2: 
    ellipse(cloud2LocationX, cloud2LocationY, (float)(width / 8), (float)(height / 8));
    ellipse(cloud2LocationX + (float)(width / 10), cloud2LocationY, (float)(width / 8), (float)(height / 8));
    ellipse(cloud2LocationX + (float)(width / 10) * 2, cloud2LocationY, (float)(width / 8), (float)(height / 8));


    //Draws the ground
    //Calculates ground colour based on time of day
    //At night time it shifts to a dark green
    if(!isDay){
      fill((int)(0.11 * Math.pow(seconds - 45, 2)), (int)(0.79 * Math.pow(seconds - 45, 2) + 10), 0);
      stroke((int)(0.11 * Math.pow(seconds - 45, 2)), (int)(0.79 * Math.pow(seconds - 45, 2) + 10), 0);
    }
    //At day time it stays green
    else{
      fill(29, 201, 0);
      stroke(29, 201, 0);
    }
    rect(0, (float)(height / 1.14), width, (float)(height / 8));
  

    //Draws base of the house
    //Calculates house colour based on time of day
    //Night time it shifts to a dark yellow
    if(!isDay){
      fill((int)(Math.pow(seconds - 45, 2) + 20), (int)(0.87 * Math.pow(seconds - 45, 2) + 20), 0);
      stroke((int)(Math.pow(seconds - 45, 2) + 20), (int)(0.87 * Math.pow(seconds - 45, 2) + 20), 0);
    }
    //At day time it stays yellow
    else{
      fill(255, 222, 59);
      stroke(255, 222, 59);
    }
    rect((float)(width / 1.6), (float)(height / 1.6), (float)(width / 4), (float)(height / 4));


    //Draws door of the house
    //At night time it turns a dark brown
    if(!isDay){
      fill((int)(0.48 * Math.pow(seconds - 45, 2) + 20), (int)(0.31 * Math.pow(seconds - 45, 2) + 15), (int)(0.23 * Math.pow(seconds - 45, 2) + 10));
      stroke((int)(0.73 * Math.pow(seconds - 45, 2) + 20), (int)(0.48 * Math.pow(seconds - 45, 2) + 15), (int)(0.34 * Math.pow(seconds - 45, 2) + 10));
    }
    //At day time it is brown
    else{
      fill(122, 81, 58);
      stroke(185, 122, 87);
    }
    strokeWeight((float)(width / 80));
    rect((float)(width / 1.5), (float)(height / 1.33), (float)(width / 20), (float)(height / 8));


    //Draws window of the house
    //At night time it turns yellow to simulate the light turning on
    if(!isDay){
      fill(255, 179, 0);
    }
    //At day time it is a light blue
    else{
      fill(138, 235, 255);
    }
    stroke(0, 0, 0);
    strokeWeight(2);
    rect((float)(width / 1.33), (float)(height / 1.33), (float)(width / 10), (float)(height / 10));


    //Draws the roof of the house
    //Night time it fades to a dark red
    if(!isDay){
      fill((int)(0.65 * Math.pow(seconds - 45, 2) + 20), 0, 0);
      stroke((int)(0.65 * Math.pow(seconds - 45, 2) + 20), 0, 0);
    }
    //Day time it stays a light right
    else{
      fill(166, 0, 0);
      stroke(166, 0, 0);
    }
    triangle((float)(width / 1.6), (float)(height / 1.6), (float)(width / 1.33), (float)(height / 2), (float)(width / 1.14), (float)(height / 1.6));


    //Draws a tree
    //Stem:
    //At night time it turns a dark brown
    if(!isDay){
      stroke((int)(0.48 * Math.pow(seconds - 45, 2) + 20), (int)(0.31 * Math.pow(seconds - 45, 2) + 15), (int)(0.23 * Math.pow(seconds - 45, 2) + 10));
    }
    //At day time it is brown
    else{
      stroke(122, 81, 58);
    }    
    strokeWeight((float)(width/16));
    line((float)(width / 4), (float)(height / 1.14), (float)(width / 4), (float)(height / 1.6));
    //Leaves:
    //Calculates leaves colour based on time of day
    //At night time it shifts to a dark green
    if(!isDay){
      fill((int)(0.11 * Math.pow(seconds - 45, 2)), (int)(0.79 * Math.pow(seconds - 45, 2) + 10), 0);
      stroke((int)(0.11 * Math.pow(seconds - 45, 2)), (int)(0.79 * Math.pow(seconds - 45, 2) + 10), 0);
    }
    //At day time it stays green
    else{
      fill(4, 122, 0);
      stroke(4, 122, 0);
    }
    strokeWeight(0);
    ellipse((float)(width / 4), (float)(height / 2), (float)(width / 4), (float)(height / 4));


    //Declares the font:
    PFont timeFont = createFont("Roboto", 20);
    textFont(timeFont, 20);
    //At night time the font turns white to make it easier to read
    if(!isDay){
      fill(255, 255, 255);
    }
    //At day time it is black
    else{
      fill(0, 0, 0);
    }
    //Prints the time
    text(hour + " : " + minutes + " : " + seconds, (float)(width * 0.8), (float)(height * 0.93));
    text(year + " / " + month + " / " + day, (float)(width * 0.74), (float)(height * 0.98));
  }
}