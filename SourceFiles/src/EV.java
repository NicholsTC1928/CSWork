import java.util.*;
//Remember that using the "*" imports everything, and can lead to degraded performance.

public class EV
{
    /*
    We are going to write a program that calculates some values in Pokemon; specifically, we are calculating
    EV (Effort Value), which is gained through combat. When one Pokemon wins against another, they earn EV to raise
    their stats.

    -These stats are private, as the other trainer cannot see them.

    -If you want to know what the EV value is, then you need to calculate it yourself, given the values that you
    can see.

    -The formula for calculating HP is available online, and we can do some algebra in order to find the EV.
    */
    public static void main(String[] args){
        /*
        When constructing the Scanner,...
            -Always capitalize Scanner.
            -Name the Scanner something appropriate (scanner, console, input, etc.).
            -Construct with the "new" keyword and "System.in" as a parameter.
        */
        Scanner input = new Scanner(System.in);

        //This part outputs a message to the console, explaining the program to the user.
        System.out.println("This program will calculate the EV (Effort Value) of a specified Pokemon.");
        System.out.println("Input the stats of your Pokemon below.");

        //This part pairs a user prompt with different integer variables, which hold the information that the user
        //inputs.
        System.out.print("Hit Points (HP): ");
        int hp = input.nextInt();
        System.out.print("Level: ");
        int level = input.nextInt();
        System.out.print("Base Hit Points (HP): ");
        int base = input.nextInt();
        System.out.print("IV: ");
        int iv = input.nextInt();

        //Formula: EV = ((HP - 10) * 100) / level - 2 * base - IV - 100) * 4
        int ev = (((hp - 10) * 100) / level - 2 * base - iv - 100) * 4;
        System.out.println("The EV of your Pokemon is " + ev + " points.");
    }
}
