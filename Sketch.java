import processing.core.PApplet;
import processing.core.PImage;
import java.util.Random;

public class Sketch extends PApplet {
  
  PImage imgBaseball;
	PImage imgClouds;
  PImage imgPika;
  PImage imgUfo;
  PImage imgFish;
  PImage imgOhtani;
  PImage imgSoda;

  float ufoX = 380;
  float ufoY = 300;

  Random myRandom = new Random();
  int intRed = 255;
  int intGreen = 255;
  int intBlue = 255;
  int intSodaX = 20;

  boolean blnUpPressed = false;
  boolean blnDownPressed = false;
  boolean blnLeftPressed = false;
  boolean blnRightPressed = false;

  String strWord = "";

  public void settings() {
    size(400, 400);
    imgBaseball = loadImage("baseball.png");  
    imgClouds = loadImage("clouds.png"); 
    imgPika = loadImage("pika.png");
    imgUfo = loadImage("ufo.png");
    imgFish = loadImage("fish.png");
    imgOhtani = loadImage("ohtani.png");
    imgSoda = loadImage("soda.png");
  }

  public void setup() {
    background(intRed, intGreen, intBlue);
    textSize(16);
  }

  public void draw() {
	  
	 imageMode(CENTER);
    
    if (keyPressed) {
      if (key == 'c') {
        background(255);
      }
    }
    
    noStroke();
    fill(intRed, intGreen, intBlue);
    rect(0, 0, 400, 150);

    noStroke();
    fill(0);
    text(strWord, 20, 50);

    if (keyCode == BACKSPACE) {
      noStroke();
      fill(intRed, intGreen, intBlue);
      rect(0, 0, 400, 150);
    }

    image(imgFish, ufoX, ufoY, 30, 30);
    image(imgUfo, ufoX, ufoY, 40, 40);
    
    if (keyPressed) {
      int intRandomSodaX = myRandom.nextInt(20, 380 + 1);
      intSodaX = intRandomSodaX;
      image(imgSoda, intSodaX, 380, 20, 20);
    }

    if (keyPressed) {
      if (keyCode == SHIFT) {
        image(imgOhtani, 200, 275, 250, 250);
      }
    }

    if (blnUpPressed) {
      ufoY--;
    }
    if (blnDownPressed) {
      ufoY++;
    }
    if (blnLeftPressed) {
      
      ufoX--;
    }
    if (blnRightPressed) {
      ufoX++;
    }   
} 

  public void mouseClicked(){
    image(imgBaseball, mouseX, mouseY, 25, 25);
    
  }
  public void mouseDragged(){
    image(imgClouds, mouseX, mouseY, 25, 25);
  }
  
  public void mouseWheel(){
    image(imgPika, mouseX, mouseY, 25, 25);
  }

  public void mousePressed(){
    int intRandomRed = myRandom.nextInt(111, 255 + 1);
    int intRandomGreen = myRandom.nextInt(215, 255 + 1);
    
    intRed = intRandomRed;
    intGreen = intRandomGreen;
  }

  public void keyTyped(){
     strWord += key;
  }

  public void keyPressed() {
    if (keyCode == UP) {
      blnUpPressed = true;
    }
    else if (keyCode == DOWN) {
      blnDownPressed = true;
    }
    else if (keyCode == LEFT) {
      blnLeftPressed = true;
    }
    else if (keyCode == RIGHT) {
      blnRightPressed = true;
    }    
  }

  public void keyReleased() {
    if (keyCode == UP) {
      blnUpPressed = false;
    }
    else if (keyCode == DOWN) {
      blnDownPressed = false;
    }
    else if (keyCode == LEFT) {
      blnLeftPressed = false;
    }
    else if (keyCode == RIGHT) {
      blnRightPressed = false;
    }
  }
}