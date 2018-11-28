package argumentSimulator;

import java.util.Scanner;

public class game {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Argument Simulator!");
        System.out.println("In this game, your goal is to outsmart the impossibly clever debater, Lauren.");
        System.out.println();
        System.out.print("Enter Your Name: ");
        String pName = input.next();
        System.out.println();
        System.out.println("Good luck, " + pName + "! (You are going to need a lot of it.)");
        System.out.println();
        System.out.println("You arrive at Lauren's Domain, a hostile territory that reflects the cold-hearted nature of its ruler. As soon as you enter, you feel an awful breeze, cold enough to kill even the most resilient of creatures. The first thought that comes to your mind is how anybody could live here.");
        System.out.println();
        System.out.println("Upon entering, Lauren barely glances in your direction; she obviously does not care about your discomfort caused by the cool breeze. With a loud sigh, she finally acknowledges your existence.");


    }

    public static int displayChoices(String initial,String[] choices){
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("Lauren: " + initial);
        System.out.println();
        System.out.println("[Below is a list of possible responses for your rebuttal.]");
        System.out.println();
        System.out.println("1: " + choices[0]);
        System.out.println("2: " + choices[1]);
        System.out.println("3: " + choices[2]);
        System.out.println("4: [Choosing this will end the game with a loss.]");
        System.out.println();
        String decision;
        for(;;){
            System.out.print("Please enter the number corresponding to your desired response. (Enter only an integer between 1 and 4.) ");
            decision = input.next();
            if(decision.equals("1") || decision.equals("2") || decision.equals("3") || decision.equals("4")) return Integer.parseInt(decision);
            else{
                System.out.println("Invalid Input");
                System.out.println();
            }
        }
    }

    public static void exitGameChoice(){
        System.out.println();
        System.out.println("Realizing the futility in arguing with such a skilled debater, you promptly exit Lauren's Domain with your head held low. The only thing that you hear as you leave is the sound of her music. At the very least, you take solace in knowing that you did not freeze to death.");
        System.out.println();
        System.out.println("Game Over");
        System.out.println("You left Lauren's Domain on your own free will.");
    }

    public static void exitGameDead(){
        System.out.println();
        System.out.println("The futile efforts that you have made in arguing with Lauren in her freezing domain have finally taken their toll. Before you know it, you can no longer feel any part of your body. Soon after, you cannot feel anything at all...");
        System.out.println();
        System.out.println("Game Over");
        System.out.println("You froze to death within Lauren's Domain.");
    }
  
    public static void exitGameInsult(){
        System.out.println();
        System.out.println("With that last roast, your self-esteem was finally demolished. You quickly rush out of Lauren's Domain in order to spare the rest of your dignity; its heartless ruler laughs as you retreat. As you rush to safer territory, you realize that your life will never be the same again.");
        System.out.println();
        System.out.println("Game Over");
        System.out.println("You fled from Lauren's Domain in order to protect your feeling of self-worth.");
    }

    public static void exitGameDismissal(){
        System.out.println();
        System.out.println("As you begin to exit Lauren's Domain, you feel a strange sensation: hope. Realizing that you were not banished, you quickly begin to plan your next venture into that hostile territory. By the time you are ready to enter once more, another sensation overwhelms you: fear. Worried that your next trip might be your last, you never return to Lauren's Domain.");
        System.out.println();
        System.out.println("Game Over");
        System.out.println("You were dismissed from Lauren's Domain.");
    }

    public static void exitGameBanished(){
        System.out.println();
        System.out.println("By the time you understood the consequences of your actions, it was too late. Exiled from Lauren's Domain, you leave knowing that you will never be able to enter again. However, there is a bright side: you will never have to subject yourself to such shame and ridicule ever again.");
        System.out.println();
        System.out.println("Game Over");
        System.out.println("You were banished from Lauren's Domain.");
    }

    public static void exitGameCountdown(){
        System.out.println();
        System.out.println("As soon as Lauren had reached the end of her countdown, something awful happened to you. Nobody quite knows what she did, and theories of your unfortunate fate spread like wildfire. However, one thing is for certain: whatever happened to you must certainly have been unpleasant.");
        System.out.println();
        System.out.println("Game Over");
        System.out.println("You faced the consequences of neglecting Lauren's countdown.");
    }

    public static void exitGameAscension(){
        System.out.println();
        System.out.println("While performing the sacred ritual, you feel yourself gradually fading away. The end of Lauren's countdown did not matter, since you had already ascended into godhood. As a human, you could never win an argument against Lauren; as a deity, you will never need to.");
        System.out.println();
        System.out.println("Game Over");
        System.out.println("You have achieved ascension by doing the Mario.");
    }
}
