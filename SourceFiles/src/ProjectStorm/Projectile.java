package ProjectStorm;

public class Projectile{
    private double speedX;
    private final double initialSpeedX;
    private double speedY;
    private final double initialSpeedY;
    private double currentXPos;
    private double currentYPos;
    private boolean isExplosive;
    
    public Projectile(double speedX,double speedY,double currentPosX,double currentPosY,boolean isExplosive){
        this.speedX = speedX;
        this.initialSpeedX = speedX;
        this.speedY = speedY;
        this.initialSpeedY = speedY;
        this.currentXPos = currentXPos;
        this.currentYPos = currentYPos;
        this.isExplosive = isExplosive;
    }
    
    public double getSpeedX(){
        return this.speedX;
    }
    
    public void multiplySpeedXBy(double multiplier){
        this.speedX *= multiplier;
    }
    
    public double setSpeedX(new speed){
        this.speedX = speed;
    }
    
    public double getInitialSpeedX(){
        return this.initialSpeedX;
    }
    
    public double getSpeedY(){
        return this.speedY;
    }
    
    public void multiplySpeedYBy(double multiplier){
        this.speedY *= multiplier;
    }
    
    public double setSpeedY(new speed){
        this.speedY = speed;
    }
    
    public double getInitialSpeedY(){
        return this.initialSpeedY;
    }
    
    public double getCurrentXPos(){
        return this.currentXPos;
    }
    
    public void changeCurrentXPosBy(double speed){
        this.currentXPos += speed;
    }
    
    public void setCurrentXPos(
}
