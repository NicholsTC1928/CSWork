public class MovableObject{
    private int speedX;
    private int speedY;
    private int health;
    private boolean isInvincible;
    
    public MovableObject(int speedX,int speedY,int health,boolean isInvincible){
        this.speedX = speedX;
        this.speedY = speedY;
        this.health = health;
        this.isInvincible = isInvincible;
    }
    
    public MovableObject(){
        this(0,0,100,false);
        /*
        If no parameters are provided, then a new movable object is created with...
        - 0 speed in the x- and y-directions
        - 100 HP
        - No invincibility
        */
    }
    
    public int getSpeedX(){
        return this.speedX;
    }
    
    public void setSpeedX(int newSpeedX){
        this.speedX = newSpeedX;
    }
    
    public int getSpeedY(){
        return this.speedY;
    }
    
    public void setSpeedY(int newSpeedY){
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
        this.health -= damageTaken;
    }
    
    public boolean getInvincibilityState(){
        return this.isInvincible;
    }
    
    public void changeInvincibilityStateTo(boolean newState){
        this.isInvincible = newState;
    }
}
