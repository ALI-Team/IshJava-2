/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package am.alite.ishjava2;

import java.awt.Paint;
import java.awt.Stroke;

/**
 *
 * @author luka
 */
public class Sprite  {
    
    public int xPos;
    public int yPos;
    public int speed;
    public int direction;
    
    public String imageName;
    public String name;
    
    public boolean running;
    public boolean visible;
    public boolean penDown;
    public boolean gravity;
    
    public Paint penColor;
    public Stroke penStroke;
    
    public Sprite(String imgPath, int xPos, int yPos)  {
        this.xPos = xPos;
        this.yPos = yPos;
        this.imageName = imgPath;
    }
    
    public Sprite getLastTouchedSprite() {
        //TO BE IMPLEMENTED
        return new Sprite("",0,0);
    }
    
    public void playAudio(String path) {
        
    }
    
    public void loop() {
        //To be overwritten
    }
}
