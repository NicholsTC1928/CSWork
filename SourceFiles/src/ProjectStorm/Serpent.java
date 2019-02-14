package ProjectStorm;

import java.util.Random;

public class Serpent extends MovableObject{
    private int level;
    private int damage;
    private boolean isAIActivated;
    private boolean isCurrentlyInWorld;
    private double desiredXPos = -1.0;
    private double desiredYPos = -1.0;
    private final double actualFullSpeed;
    private double initialSpeedX;
    private double initialSpeedY;
    
    public Serpent(int level){
        switch(level){
            case 0:
                super(2.5,2.5,60,false);
                this.damage = 30;
                this.actualFullSpeed = 2.5;
                break;
            case 1:
                super(2.5,2.5,90,false);
                this.damage = 60;
                this.actualFullSpeed = 2.5;
                break;
            case 2:
                super(3.5,3.5,120,false);
                this.damage = 90;
                this.actualFullSpeed = 3.5
                break;
            default:
                break;
        }
        this.isCurrentlyInWorld = false;
        this.isAIActivated = false;
    }
    
    public void activateEnemy(double playerCurrentYPos,double playerCurrentXPos){
        this.isAIActivated = true;
        Random r = new Random();
        while(this.health > 0){
            int sideChoice = r.nextInt(4) + 1;
            if(!this.isCurrentlyInWorld){
                switch(sideChoice){
                    case 1: //Top Border
                        this.currentYPos = 0.0;
                        this.currentXPos = 400.0 * (r.nextDouble());
                        break;
                    case 2: //Bottom Border
                        this.currentYPos = 400.0;
                        this.currentXPos = 400.0 * (r.nextDouble());
                        break;
                    case 3: //Left Border
                        this.currentXPos = 0.0;
                        this.currentYPos = 400.0 * (r.nextDouble());
                        break;
                    case 4: //Right Border
                        this.currentXPos = 400.0;
                        this.currentYPos = 400.0 * (r.nextDouble());
                        break;
                    default:
                        break;
                }
                this.isCurrentlyInWorld = true;
            }
            if(desiredXPos == -1.0 && desiredYPos == -1.0){
                double neededChangeInX = playerCurrentXPos - this.currentXPos;
                double neededChangeInY = playerCurrentYPos - this.currentYPos;
                //The total speed of the enemy should be 2.5 units/second (3.5 units/second if the type is Omega).
                double angle = Math.atan(neededChangeInY / neededChangeInX);
                this.speedX = this.actualFullSpeed * Math.cos(angle);
                this.initialSpeedX = this.speedX;
                this.speedY = this.actualFullSpeed * Math.sin(angle);
                this.initialSpeedY = this.speedY;
            }
        }
    }
}
