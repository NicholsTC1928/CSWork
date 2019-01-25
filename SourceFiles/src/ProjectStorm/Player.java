package ProjectStorm;

public class Player extends MovableObject{
    private int armor;
    private int perkLimit;
    /*
    The following boolean values will save whether or not the player has the respective perk-a-colas.
    The actual perks should be programmed in a separate class file.
    
    The following perks have no use in this game:
    - Deadshot Daiquiri
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
    
    public Player(){
        this.health = 100;
        this.armor = 0;
        //The following two variables assume that the play space is 400 x 400 units squared.
        this.currentX = 200;
        this.currentY = 200;
    }
    
    public int getArmor(){
        return this.armor;
    }
    
    public int getPerkLimit(){
        return this.perkLimit;
    }
    
    public void increasePerkLimit(){
        this.perkLimit++;
    }
    
    public void damageByAmount(int damageTaken){
        if(this.isInvincible) return;
        if(this.armor == 0){
            if(this.health <= damageTaken) this.health = 0;
            else this.health -= damageTaken;
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
            double damageToHealth = ((double) damageTaken * (0.4.));
            int calcHD = (int) damageToHealth;
            int damageToArmor = (damageTaken - (calcHD + calcND));
            if(this.armor <= damageToArmor){
                calcHD += (damageToArmor - this.armor);
                this.armor = 0;
            }
            else{
                this.armor -= damageToArmor;
                
            }
            if(this.health <= calcHD) this.health = 0;
            else this.health -= calcHD;
        }
    }
}
