package ProjectStorm;

import java.util.Random;

public class Serpent extends MovableObject{
    private int level;
    private int damage;
    private boolean isAIActivated;
    private boolean isCurrentlyInWorld;
    private boolean hasDesiredPath = false;
    private final double actualFullSpeed;
    private double initialSpeedX;
    private double initialSpeedY;
    private double angleForOrientation;
    
    public Serpent(int level){
        super((2.5 + (0.5 * level)),(2.5 + (0.5 * level)),(60 + (30 * level)),false);
        switch(level){
            case 0:
                this.damage = 30;
                this.actualFullSpeed = 2.5;
                break;
            case 1:
                this.damage = 60;
                this.actualFullSpeed = 3.0;
                break;
            case 2:
                this.damage = 90;
                this.actualFullSpeed = 3.5;
                break;
            default:
                this.damage = 30;
                this.actualFullSpeed = 2.5;
                break;
        }
        this.isCurrentlyInWorld = false;
        this.isAIActivated = false;
    }

    public double getInitialSpeedX(){
        return this.initialSpeedX;
    }

    public double getInitialSpeedY(){
        return this.initialSpeedY;
    }

    public double getAngleForOrientation(){
        return this.angleForOrientation;
    }
    
    public double getLevel(){
        return this.level;
    }
    
    public void setLevel(int newLevel){
        this.level = newLevel;
    }
    
    public boolean getIsCurrentlyInWorld(){
        return this.isCurrentlyInWorld;
    }
    
    public void activateEnemy(double playerCurrentYPos,double playerCurrentXPos){
        this.isAIActivated = true;
        Random r = new Random();
        while(this.getHealth() > 0){
            int sideChoice = r.nextInt(4) + 1;
            if(!this.isCurrentlyInWorld){
                switch(sideChoice){
                    case 1: //Top Border
                        this.goToYPos(0.0);
                        this.goToXPos(400.0 * (r.nextDouble()));
                        break;
                    case 2: //Bottom Border
                        this.goToYPos(400.0);
                        this.goToXPos(400.0 * (r.nextDouble()));
                        break;
                    case 3: //Left Border
                        this.goToXPos(0.0);
                        this.goToYPos(400.0 * (r.nextDouble()));
                        break;
                    case 4: //Right Border
                        this.goToXPos(400.0);
                        this.goToYPos(400.0 * (r.nextDouble()));
                        break;
                    default:
                        break;
                }
                this.isCurrentlyInWorld = true;
            }
            if(!this.hasDesiredPath){
                double neededChangeInX = playerCurrentXPos - this.getCurrentXPos();
                double neededChangeInY = playerCurrentYPos - this.getCurrentYPos();
                //The total speed of the enemy should be 2.5 units/second (3.5 units/second if the type is Omega).
                double angle = Math.atan(neededChangeInY / neededChangeInX);
                this.angleForOrientation = angle;
                this.setSpeedX(this.actualFullSpeed * Math.cos(angle));
                this.initialSpeedX = this.getSpeedX();
                this.setSpeedY(this.actualFullSpeed * Math.sin(angle));
                this.initialSpeedY = this.getSpeedY();
                this.hasDesiredPath = true;
            }
            else{
                if(this.getCurrentXPos() <= 0.0 || this.getCurrentXPos() >= 400.0 || this.getCurrentYPos() <= 0.0
                        || this.getCurrentYPos() >= 400.0){
                    this.isCurrentlyInWorld = false;
                    this.hasDesiredPath = false;
                }
            }
        }
    }
}
