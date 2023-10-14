import processing.core.PApplet;

/**
 * Draws a house, tree, clouds and sun. There is a day-night cycle and the cloud and tree location are randomized. 
 * 
 * @JoshuaYin
 */
class Main {
  public static void main(String[] args) {
    
    String[] processingArgs = {"MySketch"};
	  Sketch mySketch = new Sketch();
	  PApplet.runSketch(processingArgs, mySketch);
  }
  
}