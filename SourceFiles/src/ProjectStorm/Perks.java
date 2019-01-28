package ProjectStorm;

import java.util.Random;
import java.util.Arrays;
import ProjectStorm.Player;

public class Perks extends Player{


    public void getWunderfizzResult(){
        Random r = new Random();
        boolean isPerkAvailable = false;
        String chosenPerk;
        while(!isPerkAvailable) {
            boolean temp = true;
            chosenPerk = PERKS_LIST[r.nextInt(PERKS_LIST.length)];
            for (int i = 0; i < getCurrentPerkCount(); i++) {
                if(chosenPerk.equals(getCurrentPerkAt(i))) temp = false;
            }
            if(temp) isPerkAvailable = true;
        }

    }
}
