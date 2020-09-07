import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball extends Actor
{
    private int speed = 30;
    private int direction;
    private Player leftPlayer;
    private Player rightPlayer;
    
    public Ball(Player leftPlayer, Player rightPlayer) {
        this.leftPlayer = leftPlayer;
        this.rightPlayer = rightPlayer;
        this.direction = (int) (Math.random() * 360);
    }
    
    public void act() {
        move();
    }
    
    private void move() {
        
    }
    
    private void checkLeftRightBound() {
    
    }
    
    private void checkRebound() {
    
    }
    
    private void resetBall() {
        setLocation(300, 200);
    }
}
