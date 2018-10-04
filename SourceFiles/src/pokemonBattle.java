import java.util.Scanner; //Allows for user input

public class pokemonBattle
{
    public static void main(String[] args){
        String choice = battleStart(); //Stores the Pokemon choice into a variable that can be accessed elsewhere
        int[] stats = damage(choice); //Stores the stats array into an array that can be accessed elsewhere
        Scanner input = new Scanner(System.in); //Allows for user input
        System.out.println("What is the first move that " + choice + " knows?"); //Asks for a Pokemon's move
        String first = input.next(); //Saves the move as a string
        System.out.println("What is the second move that " + choice + " knows?"); //Asks for a Pokemon's move
        String second = input.next(); //Saves the move as a string
        System.out.println("What is the third move that " + choice + " knows?"); //Asks for a Pokemon's move
        String third = input.next(); //Saves the move as a string
        System.out.println("What is the fourth move that " + choice + " knows?"); //Asks for a Pokemon's move
        String fourth = input.next(); //Saves the move as a string
        String[] moves = new String[]{first,second,third,fourth}; //Stores the specified moves into a string array
        statsTable(choice,stats,moves); //Calls the statsTable() method with the Pokemon choice, stats, and moves
        //as parameters
    }

    public static String battleStart(){
        Scanner input = new Scanner(System.in); //Allows for user input
        System.out.println("Another trainer is issuing a challenge!"); //Prints the quote and creates a new line
        System.out.println(); //Creates a new line
        System.out.print("Which Pokemon do you choose? "); //Prints the quote and allows input on the same line
        String choice = input.next(); //Stores user input as Pokemon choice
        System.out.println(); //Creates a new line
        System.out.println("You chose " + choice + "!"); //Prints "You chose [Pokemon choice]!" and creates a new line
        System.out.println(); //Creates a new line
        System.out.println("It's a Pokemon battle between " + choice + " and Zebstrika! Go!"); /*
        Prints "It's a Pokemon battle between [Pokemon choice] and Zebstrika! Go!" and creates a new line
        */
        return choice; //Returns the Pokemon choice
    }

    public static int[] damage(String choice){
        Scanner input = new Scanner(System.in); //Allows for user input
        System.out.println("Zebstrika used Thunderbolt!"); //Prints the quote and creates a new line
        System.out.println(); //Creates a new line
        System.out.println("Trainer, what are your " + choice + "'s stats?"); /*
        Prints "Trainer, what are your [Pokemon choice]'s stats?" and creates a new line
        */
        System.out.print("Level: "); //Prints the quote and allows input on the same line
        int level = input.nextInt(); //Stores user input as level integer
        System.out.print("Attack: "); //Prints the quote and allows input on the same line
        int attack = input.nextInt(); //Stores user input as attack integer
        System.out.print("Defense: "); //Prints the quote and allows input on the same line
        int defense = input.nextInt(); //Stores user input as defense integer
        System.out.print("Base: "); //Prints the quote and allows input on the same line
        int base = input.nextInt(); //Stores user input as base integer
        System.out.print("Same Type Attack Bonus (STAB): "); //Prints the quote and allows input on the same line
        int stab = input.nextInt(); //Stores user input as stab integer
        System.out.print("Hit Points (HP): "); //Prints the quote and allows input on the same line
        int hp = input.nextInt(); //Stores user input as hp integer
        System.out.println(); //Creates a new line
        double random = Math.random() * (1 - 0.85) + 0.85; //Creates a random double value between 0.85 and 1
        double modifier = stab * random; //Creates a double value by multiplying stab by random
        double damage = (((2 * level + 10) / 250.0) + ((attack * 1.0) / (defense * 1.0)) * (base * 1.0) + 2.0) * modifier; /*
        Creates a double value called damage by using the integer variables specified multiplied by 1.0 (this makes them
        double values) */
        int damageTaken = (int) damage; //Converts damage into an integer value
        System.out.println(choice + " sustained " + damageTaken + " points of damage."); //Prints "[Pokemon choice]
        //sustained [damage taken] points of damage." and creates a new line
        System.out.println("The current HP of " + choice + " is " + (hp - damageTaken) + "."); //Displays the amount of
        //HP remaining after the damage
        int[] stats = new int[]{level,attack,defense,base,stab,hp,(hp - damageTaken)}; //Creates a list of stats in an
        //integer array, which will be used in the statsTable() method
        return stats; //Returns the stats array
    }

    public static void statsTable(String choice,int[] stats,String[] moves){
        System.out.println("Name: " + choice); //Prints "Name: [Pokemon choice]" and creates a new line
        System.out.println("Level: " + stats[0]); //Prints "Level: [Level stat]" and creates a new line
        System.out.println("---------------"); //Prints a series of dashes and creates a new line
        System.out.println("HP: " + stats[6] + "/" + stats[5]); //Prints "HP: [Current HP]/[Maximum HP]" and creates a
        //new line
        System.out.println("Attack: " + stats[1]); //Prints "Attack: [Attack stat]" and creates a new line
        System.out.println("Defense: " + stats[2]); //Prints "Defense: [Defense stat]" and creates a new line
        System.out.println("Sp. Attack: 121"); //Prints "Sp.Attack: 121" and creates a new line
        System.out.println("Sp. Defense: 81"); //Prints "Sp. Defense: 81" and creates a new line
        System.out.println("Speed: 107"); //Prints "Speed: 107" and creates a new line
        System.out.println("---------------");//Prints a series of dashes and creates a new line
        System.out.println("Moves Learned: " + moves[0] + ", " + moves[1] + ", " + moves[2] + ", and " + moves[3]);
        //Prints "Moves Learned: [1st move], [2nd move], [3rd move], and [4th move]"//Prints a series of dashes and
        //creates a new line
        System.out.println(); //Creates a new line
    }
}
