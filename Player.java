import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private String up = "";
    private String down = "";
    private int speed = 6;
    private int score = 0;
    
    public Player(String up, String down) {
        this.up = up;
        this.down = down;
    }
    
    public int getScore() {
        return this.score;
    }
    
    public void incrementScore() {
        this.score++;
    }
    
    public void act() {
        if (Greenfoot.isKeyDown(this.up)) {
            move("up");
        } else if (Greenfoot.isKeyDown(this.down)) {
            move("down");
        }
    }
    
    public int getYCoord() {return getY();}
    
    private void move(String direction) {
        setLocation(getX(), ((direction.equals("up")) ? getY()-this.speed : getY()+this.speed));
    }
}






