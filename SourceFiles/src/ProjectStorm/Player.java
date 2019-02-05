package ProjectStorm;

import java.util.ArrayList;
import java.util.Arrays;

public class Player extends MovableObject{
    private int armor;
    private int perkLimit;
    private int currentPerkCount;
    
    //Stats Affected by Quick Revive
    private boolean hasQuickRevive = false;
    //Stats Affected by Double Tap
    private double fireRateMultiplier = 1.0;
    private double damageMultiplier = 1.0;
    //Stats Affected by Juggernog
    private int maxHealth;
    //Stats Affected by Speed Cola
    private double reloadSpeedMultiplier = 1.0;
    //Stats Affected by Stamin-Up
    private double speedMultiplier = 1.0;
    //Stats Affected by Ph.D. Flopper
    private boolean hasFlopper;
    //Stats Affected by Mule Kick
    private boolean hasMuleKick;
    //Stats Affected by Electric Cherry
    private boolean hasElectricCherry;
    //Stats Affected by Who's Who
    private boolean hasWhosWho; //Apostrophes are not allowed in variable names.
    //Stats Affected by Vulture's Aid
    private boolean hasVulturesAid;
    //Stats Affected by Widow's Wine
    private boolean hasWidowsWine;
    //Stats Affected by Deadshot Daiquiri
    private double criticalHitDamageMultiplier = 1.0;
    
    private final String[] PERKS_LIST = new String[]{
            "Quick Revive",
            "Double Tap 2.0 Root Beer",//Partially Finished (Needs Implementation of Multipliers)
            "Juggernog", //Finished
            "Speed Cola", //Partially Finished (Needs Implementation of Multipliers)
            "Stamin-Up", //Finished
            "Ph.D. Flopper",
            "Mule Kick",
            "Electric Cherry",
            "Who's Who",
            "Vulture's Aid Elixir",
            "Widow's Wine",
            "Deadshot Daiquiri" //Partially Finished (Needs Implementation of Multipliers)
    };
    private ArrayList<String> currentPerks = new ArrayList<String>();
    /*
    The following perks have no use in this game (with their default functionality):
    - Deadshot Daiquiri (Note: It could increase the chance of landing a critical hit.)
    - Tombstone Soda (Note: This could be used if a multiplayer game is implemented.)
    */
    public ArrayList<String> availablePerks = new ArrayList<String>();
    private String[] currentWeapons = new String[3];
    private int equippedWeaponIndex = 0;
    //For the following arrays, the element at index 0 is the ammo in the magazine, while the element at index 1 is the total reserve ammo.
    //The element at index 2 is the initial magazine size, which is used for reloading the weapon.
    //The element at index 3 is the initial reserves size, which is used for Max Ammo powerups.
    private int[] ammoForWeapon1 = new int[4];
    private int[] ammoForWeapon2 = new int[4];
    private int[] ammoForWeaponMuleKick = new int[4];
    
    public Player(){
        this.setHealth(100);
        this.maxHealth = 100;
        this.armor = 0;
        //The following two variables assume that the play space is 400 x 400 units squared.
        this.goToXPos(200.0);
        this.goToYPos(200.0);
        this.currentWeapons[0] = "M1911";
        this.ammoForWeapon1[0] = 8;
        this.ammoForWeapon1[1] = 32;
        this.ammoForWeapon1[2] = this.ammoForWeapon1[0];
        this.ammoForWeapon1[3] = this.ammoForWeapon1[1];
        this.currentWeapons[1] = null;
        this.currentWeapons[2] = null;
    }

    public String getEquippedWeapon(){
        return this.currentWeapons[this.equippedWeaponIndex];
    }

    private void initializeAvailablePerksList(){
        availablePerks.addAll(Arrays.asList(PERKS_LIST));
    }
    
    public void changeQuickReviveState(boolean activated){
        this.hasQuickRevive = activated;
    }
    
    public void changeFlopperState(boolean activated){
        this.hasFlopper = activated;
    }
    
    public void changeMuleKickState(boolean activated){
        this.hasMuleKick = activated;
    }
    
    public void changeElectricCherryState(boolean activated){
        this.hasElectricCherry = activated;
    }
    
    public void changeWhosWhoState(boolean activated){
        this.hasWhosWho = activated;
    }
    
    public void changeVulturesAidState(boolean activated){
        this.hasVulturesAid = activated;
    }
    
    public void changeWidowsWineState(boolean activated){
        this.hasWidowsWine = activated;
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
    
    public double getFireRateMultiplier(){
        return this.fireRateMultiplier;
    }
    
    public double getDamageMultiplier(){
        return this.damageMultiplier;
    }
    
    public double getReloadSpeedMultiplier(){
        return this.reloadSpeedMultiplier;
    }
    
    public double getSpeedMultiplier(){
        return this.speedMultiplier;
    }
    
    public double getCriticalHitDamageMultiplier(){
        return this.criticalHitDamageMultiplier;
    }

    public int getCurrentPerkCount(){
        return this.currentPerkCount;
    }

    public String getCurrentPerkAt(int index){
        return currentPerks.get(index);
    }

    public void addPerk(String perk){
        availablePerks.remove(perk);
        currentPerks.add(perk); //Use the index of the perk in the list in order to print the perk icons on screen
        //in the order in which they are received.
        this.currentPerkCount++;
    }

    public void setMaxHealth(int newMaxHealth){
        this.maxHealth = newMaxHealth;
    }
    
    public void setFireRateMultiplier(double newMultiplier){
        this.fireRateMultiplier = newMultiplier;
    }
    
    public void setDamageMultiplier(double newMultiplier){
        this.damageMultiplier = newMultiplier;
    }
    
    public void setReloadSpeedMultiplier(double newMultiplier){
        this.reloadSpeedMultiplier = newMultiplier;
    }
    
    public void setSpeedMultiplier(double newMultiplier){
        this.speedMultiplier = newMultiplier;
    }
    
    public void setCriticalHitDamageMultiplier(double newMultiplier){
        this.criticalHitDamageMultiplier = newMultiplier;
    }
    
    public void increasePerkLimit(){
        this.perkLimit++;
    }
    
    public void checkIfDead(){
        //Who's Who needs to override Quick Revive.
        if(hasWhosWho){
            
        }
        else if(hasQuickRevive){
            
        }
        else{
            
        }
    }
    
    public void damageByAmount(int damageTaken){
        if(this.getInvincibilityState()) return;
        if(this.armor == 0){
            if(this.getHealth() <= damageTaken){
                this.setHealth(0);
                checkIfDead();
            }
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
            if(this.getHealth() <= calcHD){
                this.setHealth(0);
                checkIfDead();
            }
            else this.setHealth(this.getHealth() - calcHD);
        }
    }
    
    public void printCurrentPositionInWorld(){
        System.out.println("Current Position: (" + this.getCurrentXPos() + ", " + this.getCurrentYPos() + ")");
    }

    public void addWeaponToInventory(String newWeapon,int slotIndex){
        if(this.currentWeapons[1] == null) this.currentWeapons[1] = newWeapon;
        else if(this.currentWeapons[2] == null && this.hasMuleKick) this.currentWeapons[2] = newWeapon;
        else this.currentWeapons[slotIndex] = newWeapon;
    }

    public void swapEquippedWeapon(int newIndex){
        if((newIndex == 2 && !this.hasMuleKick) || this.currentWeapons[newIndex] == null || newIndex == this.equippedWeaponIndex) return;
        this.equippedWeaponIndex = newIndex;
        System.out.println("Equipped Weapon: " + this.currentWeapons[this.equippedWeaponIndex]);
    }
    
    public void reloadEquippedWeapon(){
        switch(this.equippedWeaponIndex){
            case 0:
                if(this.ammoForWeapon1[1] == 0){
                    break;
                }
                if(this.ammoForWeapon1[1] >= (this.ammoForWeapon1[2] - this.ammoForWeapon1[0])){
                    this.ammoForWeapon1[1] -= (this.ammoForWeapon1[2] - this.ammoForWeapon1[0]);
                    this.ammoForWeapon1[0] = this.ammoForWeapon1[2];
                }
                else{
                    this.ammoForWeapon1[0] += this.ammoForWeapon1[1];
                    this.ammoForWeapon1[1] = 0;
                }
                break;
            case 1:
                if(this.ammoForWeapon2[1] == 0){
                    break;
                }
                if(this.ammoForWeapon2[1] >= (this.ammoForWeapon2[2] - this.ammoForWeapon2[0])){
                    this.ammoForWeapon2[1] -= (this.ammoForWeapon2[2] - this.ammoForWeapon2[0]);
                    this.ammoForWeapon2[0] = this.ammoForWeapon2[2];
                }
                else{
                    this.ammoForWeapon2[0] += this.ammoForWeapon2[1];
                    this.ammoForWeapon2[1] = 0;
                }
                break;
            case 2:
                if(this.ammoForWeaponMuleKick[1] == 0){
                    break;
                }
                if(this.ammoForWeaponMuleKick[1] >= (this.ammoForWeaponMuleKick[2] - this.ammoForWeaponMuleKick[0])){
                    this.ammoForWeaponMuleKick[1] -= (this.ammoForWeaponMuleKick[2] - this.ammoForWeaponMuleKick[0]);
                    this.ammoForWeaponMuleKick[0] = this.ammoForWeaponMuleKick[2];
                }
                else{
                    this.ammoForWeaponMuleKick[0] += this.ammoForWeaponMuleKick[1];
                    this.ammoForWeaponMuleKick[1] = 0;
                }
                break;
            default:
                break;
        }
    }
}
