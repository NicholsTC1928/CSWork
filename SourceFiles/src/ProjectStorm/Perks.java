package ProjectStorm;

import java.util.Random;
import java.util.Arrays;
import ProjectStorm.Player;

public class Perks extends Player{


    public String getWunderfizzResult(){
        Random r = new Random();
        return (availablePerks.get(r.nextInt(availablePerks.size())));
    }
}
