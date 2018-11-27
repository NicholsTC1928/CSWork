import java.util.Scanner;

public class argumentSimulator {
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
        System.out.println("You arrive in Lauren's domain, a hostile territory that reflects the cold-hearted nature of its ruler. As soon as you enter, you feel an awful breeze, cold enough to kill even the most resilient of creatures. The first thought that comes to your mind is how anybody could live here.");
        System.out.println();
        System.out.println("Upon entering, Lauren barely glances in your direction; she obviously does not care about your discomfort caused by the cool breeze. With a loud sigh, she finally acknowledges your existence.");
        //Branch 1:
        String initial1 = "What do you want?";
        String[] choices1 = {"To hang out...","May I please turn off your fan?","I just wanted to talk."};
        int decision1 = displayChoices(initial1,choices1,1);
        if(decision1 == -1) quitGameChoice();
    }

    public static int displayChoices(String initial,String[] choices,int branch){
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
        String decision = "";
        for(;;){
            System.out.print("Please enter the number corresponding to your desired response. (Enter only an integer between 1 and 4.) ");
            decision = input.next();
            if(decision.equals("1") || decision.equals("2") || decision.equals("3")) return Integer.parseInt(decision);
            else if(decision.equals("4")) return -1;
            else{
                System.out.println("Invalid Input");
                System.out.println();
            }
        }

    }

    public static void quitGameChoice(){
        System.out.println();
        System.out.println("Realizing the futility in arguing with such a skilled debater, you promptly exit Lauren's domain with your head held low. The only thing that you hear as you leave is the sound of her music. At the very least, you take solace in knowing that you did not freeze to death.");
        System.out.println();
        System.out.println("Game Over");
        System.out.println("You left Lauren's domain on your own free will.");
    }

    public static void quitGameDead(){
        System.out.println();
        System.out.println("The futile efforts that you have made in arguing with Lauren in her freezing domain have finally taken their toll. Before you know it, you can no longer feel any part of your body. Soon after, you cannot feel anything at all...");
        System.out.println();
        System.out.println("Game Over");
        System.out.println("You froze to death within Lauren's domain.");
    }
}
