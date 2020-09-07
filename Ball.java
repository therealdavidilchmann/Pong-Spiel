import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball extends Actor
{
    private int speedX;
    private int speedY;
    private Player leftPlayer;
    private Player rightPlayer;
    
    public Ball(Player leftPlayer, Player rightPlayer) {
        this.leftPlayer = leftPlayer;
        this.rightPlayer = rightPlayer;
        this.speedX = (int) (new Random().nextInt(3 + 3) - 3);
        this.speedY = (int) (new Random().nextInt(3 + 3) - 3);
    }
    
    public void act() {
        if (canMove()) {
            move();
        }
        
        getWorld().showText("Player 1:  " + this.leftPlayer.getScore(), 100, 40);
        getWorld().showText("Player 2:  " + this.rightPlayer.getScore(), 480, 40);
    }
    
    private void move() {
        setLocation(getX() + this.speedX, getY() + this.speedY);
    }
    
    private boolean canMove() {
        if (this.speedX == 0) {
            this.speedX = 1;
        }
        if (getX() <= 50 || getX() >= 550) {
            if (Math.abs(getY() - this.leftPlayer.getYCoord()) < 30 || Math.abs(getY() - this.rightPlayer.getYCoord()) < 30) {
                this.speedX = -this.speedX;
            } else {
                if (getX() < 100) {
                    this.rightPlayer.incrementScore();
                } else {
                    this.leftPlayer.incrementScore();
                }
                resetBall();
            }
        }
        if (getY() <= 0 || getY() >= 595) {
            this.speedY = -this.speedY;
        }
        
        return true;
    }
    
    private void resetBall() {
        this.speedX = (int) (new Random().nextInt(3 + 3) - 3);
        this.speedY = (int) (new Random().nextInt(3 + 3) - 3);
        setLocation(300, 200);
    }
}
