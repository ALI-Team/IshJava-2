/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SampleGame;

import am.alite.ishjava2.IshGame;
import am.alite.ishjava2.Sprite;
import am.alite.ishjava2.box;
import am.alite.ishjava2.pointer;
import java.io.IOException;

/**
 *
 * @author luka
 */
public class main {

    public static void main(String[] args) throws IOException, Exception {
        IshGame game = new IshGame(1280, 720, "Arrow Example");
        
        pointer arrow = new pointer("arrow", "/Users/luka/Documents/Java/IshJava-2/src/images/arrow.png", 200, 200);
        game.addSpriteToScene(arrow);
        
        box box = new box("box", "/Users/luka/Documents/Java/IshJava-2/src/images/square.png", 100, 100);
        game.addSpriteToScene(box);
    }
    
    public static int randomWithRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }
}
