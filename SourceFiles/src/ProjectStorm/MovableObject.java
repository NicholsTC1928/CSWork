package ProjectStorm;

public class MovableObject{
    private double currentXPos;
    private double currentYPos;
    private double speedX;
    private double speedY;
    private int health;
    private boolean isInvincible;
    
    public MovableObject(double speedX,double speedY,int health,boolean isInvincible){
        this.speedX = speedX;
        this.speedY = speedY;
        this.health = health;
        this.isInvincible = isInvincible;
    }
    
    public MovableObject(){
        this(4.0,4.0,100,false);
        /*
        If no parameters are provided, then a new movable object is created with...
        - 4.0 speed in the x- and y-directions
        - 100 HP
        - No invincibility
        */
    }
    
    public double getCurrentXPos(){
        return this.currentXPos;
    }
    
    public void changeCurrentXPosBy(double speedX){
        this.currentXPos += speedX;
    }
    
    public void goToXPos(double newX){
        this.currentXPos = newX;
    }
    
    public double getCurrentYPos(){
        return this.currentYPos;
    }
    
    public void changeCurrentYPosBy(double speedY){
        this.currentYPos += speedY;
    }
    
    public void goToYPos(double newY){
        this.currentYPos = newY;
    }
    
    public double getSpeedX(){
        return this.speedX;
    }
    
    public void setSpeedX(double newSpeedX){
        this.speedX = newSpeedX;
    }
    
    public double getSpeedY(){
        return this.speedY;
    }
    
    public void setSpeedY(double newSpeedY){
        this.speedY = newSpeedY;
    }
    
    public int getHealth(){
        return this.health;
    }
    
    public void setHealth(int newHealth){
        this.health = newHealth;
    }
    
    public void healByAmount(int healthGained){
        this.health += healthGained;
    }
    
    public void damageByAmount(int damageTaken){
        if(this.isInvincible) return;
        this.health -= damageTaken;
    }
    
    public boolean getInvincibilityState(){
        return this.isInvincible;
    }
    
    public void changeInvincibilityState(){
        if(this.isInvincible) this.isInvincible = false;
        else this.isInvincible = true;
    }
}
