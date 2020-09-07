import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.HashMap;
import java.util.Map;

/**
 * Write a description of class PongWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PongWorld extends World
{

    private int screenHeight = 400;
    private int screenWidth = 600;
    /**
     * Constructor for objects of class PongWorld.
     * 
     */
    public PongWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        populate();
    }
    
    private void populate() {
        Player leftPlayer = new Player("up", "down");
        addObject(leftPlayer, 40, this.screenHeight/2);
        
        Player rightPlayer = new Player("a", "b");
        addObject(rightPlayer, this.screenWidth-40, this.screenHeight/2);
        
        Ball ball = new Ball(leftPlayer, rightPlayer);
        addObject(ball, this.screenWidth/2, this.screenHeight/2);
    }
}








