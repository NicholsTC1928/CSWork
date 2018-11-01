import java.util.*;

public class PigGame {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Random r = new Random();
        System.out.print("What is the name of Player 1? ");
        String p1 = input.next();
        System.out.print("What is the name of Player 2? ");
        String p2 = input.next();
        int current = r.nextInt(2) + 1;
        boolean gameIsRunning = true;
        int score1 = 0;
        int score2 = 0;
        while(gameIsRunning){
            if(current == 1){
                score1 += turn(p1);
                System.out.println("Your total score is now " + score1 + ".");
                if(score1 >= 100){
                    System.out.println(p1 + " is the winner of this round.");
                    gameIsRunning = false;
                }
                current = 2;
            }
            else{
                score2 += turn(p2);
                System.out.println("Your total score is now " + score2 + ".");
                if(score2 >= 100){
                    System.out.println(p2 + " is the winner of this round.");
                    gameIsRunning = false;
                }
                current = 1;
            }
        }
    }

    public static int turn(String name){
        Scanner input = new Scanner(System.in);
        Random r = new Random();
        boolean valid = true;
        int score = 0;
        System.out.println("It is now " + name + "'s turn.");
        while(valid){
            int roll = r.nextInt(6) + 1;
            System.out.println("The current roll was a " + roll + ".");
            if(roll == 1){
                System.out.println("Your turn is now over, and all points accumulated during this round are now forfeit.");
                score = 0;
                return score;
            }
            else{
                score += roll;
                System.out.println("You have earned " + score + " points this round.");
                System.out.print("Do you wish to continue rolling? (Enter a \"y\" to continue rolling, or any other key to exit.) ");
                String cont = input.next();
                if(!cont.equals("y")) return score;
            }
        }
        return score;
    }
}
