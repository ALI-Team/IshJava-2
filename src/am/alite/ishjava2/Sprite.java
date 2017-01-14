/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package am.alite.ishjava2;

import java.awt.Image;
import java.awt.Paint;
import java.awt.Stroke;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author luka
 */
public class Sprite {

    public int xPos;
    public int yPos;
    public int speed;
    public int direction;
    
    public String imageName;
    public Image image;
    public String name;

    public boolean running;
    public boolean visible;
    public boolean penDown;
    public boolean gravity;

    public Paint penColor;
    public Stroke penStroke;
    
    public IshGame game;

    public Sprite(String name, String imgPath, int xPos, int yPos) throws IOException, Exception {
        this.xPos = xPos;
        this.yPos = yPos;

        this.name = name;

        try {
            this.imageName = imgPath;
            this.image = ImageIO.read(new File(imageName));
        } catch (IOException e) {
            throw new Exception("Unable to read file for sprite "+name);
        }
    }

    public void pointTowardsSprite(String name) {
        Sprite pointTowards = game.getSpriteWithName(name);
        
        this.direction = (int) Math.toDegrees(Math.atan2(pointTowards.yPos - yPos, pointTowards.xPos - xPos));
    }
    
    public Sprite getLastTouchedSprite() throws IOException, Exception {
        //TO BE IMPLEMENTED
        return new Sprite("", "", 0, 0);
    }

    public void playAudio(String path) {

    }

    public void loop() {
        //To be overwritten
    }
}
