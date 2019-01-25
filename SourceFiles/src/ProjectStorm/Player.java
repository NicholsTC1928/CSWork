package ProjectStorm;

public class Player extends MovableObject{
    private int armor;
    
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
            double damageToHealth = ((double) damageTaken * (2/5));
            int calcHD = (int) damageToHealth;
            int damageToArmor = (damageTaken - (calcHD + calcND));
            if(this.armor <= damageToArmor){
                int calcHD += (damageToArmor - this.armor);
                this.armor = 0;
                if(this.health <= calcHD) this.health = 0;
                else this.health -= calcHD;
            }
            else{
                
            }
        }
    }
}
