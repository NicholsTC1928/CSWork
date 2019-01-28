package ProjectStorm;

import java.util.ArrayList;

public class Player extends MovableObject{
    private int armor;
    private int perkLimit;
    private int currentPerkCount;
    private int maxHealth;
    private ArrayList<String> currentPerks = new ArrayList<String>();
    /*
    The following boolean values will save whether or not the player has the respective perk-a-colas.
    The actual perks should be programmed in a separate class file.
    
    The following perks have no use in this game (with their default functionality):
    - Deadshot Daiquiri (Note: It could increase the chance of landing a critical hit.
    - Tombstone Soda (Note: This could be used if a multiplayer game is implemented.)
    */
    private boolean hasQuickRevive;
    private boolean hasDoubleTap;
    private boolean hasJuggernog;
    private boolean hasSpeedCola;
    private boolean hasStaminUp;
    private boolean hasFlopper;
    private boolean hasMuleKick;
    private boolean hasElectricCherry;
    private boolean hasWhosWho; //Apostrophes are not allowed in variable names.
    private boolean hasVulturesAid;
    private boolean hasWidowsWine;
    private boolean hasDeadshot;
    
    public Player(){
        this.setHealth(100);
        this.armor = 0;
        //The following two variables assume that the play space is 400 x 400 units squared.
        this.goToXPos(200.0);
        this.goToYPos(200.0);
    }
    
    public int getArmor(){
        return this.armor;
    }
    
    public int getPerkLimit(){
        return this.perkLimit;
    }

    public int getMaxHealth(){
        return this.maxHealth;
    }

    public int getCurrentPerkCount(){
        return this.currentPerkCount;
    }

    public String getPerkAt(int index){
        return currentPerks.get(index);
    }

    public void increaseCurrentPerkCount(){
        this.currentPerkCount++;
    }

    public void setMaxHealth(int newMaxHealth){
        this.maxHealth = newMaxHealth;
    }
    
    public void increasePerkLimit(){
        this.perkLimit++;
    }
    
    public void damageByAmount(int damageTaken){
        if(this.getInvincibilityState()) return;
        if(this.armor == 0){
            if(this.getHealth() <= damageTaken) this.setHealth(0);
            else this.setHealth(this.getHealth() - damageTaken);
        }
        else{
            /*
            Damage taken with armor should be calculated as such:
            - 2/5 is done to armor
            - 2/5 is done to health
            - 1/5 is completely negated
            Damage that cannot be absorbed by armor should deal remaining damage to health.
            */
            double negatedDamage = ((double) damageTaken * (0.2));
            int calcND = (int) negatedDamage;
            double damageToHealth = ((double) damageTaken * (0.4));
            int calcHD = (int) damageToHealth;
            int damageToArmor = (damageTaken - (calcHD + calcND));
            if(this.armor <= damageToArmor){
                calcHD += (damageToArmor - this.armor);
                this.armor = 0;
            }
            else{
                this.armor -= damageToArmor;
                
            }
            if(this.getHealth() <= calcHD) this.setHealth(0);
            else this.setHealth(this.getHealth() - calcHD);
        }
    }
}
