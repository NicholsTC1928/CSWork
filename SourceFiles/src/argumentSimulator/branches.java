package argumentSimulator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class branches {
    String[][] branches = new String[13][4];
    private int totalPacks = 1; //Change this when adding extra packs.
    String[] packs = new String[totalPacks];

    public String[][] chooseBranchPack(){
        Scanner input = new Scanner(System.in);
        //You can add new branch packs here.
        packs[0] = "Argument Simulator";
        System.out.println();
        //if(totalPacks == 1) return getBranchesMain();
        boolean valueFound = false;
        int packChoice = 0;
        while(!valueFound){
            try{
                Scanner packInput = new Scanner(System.in); //This prevents an infinite loop.
                System.out.println("The following games are available to play:");
                System.out.println();
                for(int i = 0;i < totalPacks;i++){
                    System.out.println((i + 1) + " - " + packs[i]);
                }
                System.out.println();
                System.out.print("Please enter the number corresponding to your desired game. ");
                packChoice = packInput.nextInt();
                //The following statement prevents the user from choosing a branch pack that is not there. Alas, you have
                //finally discovered how to make sure that the user inputs only select values without having to explicitly
                //state which values are applicable in the condition (e.g., packChoice == 1 || packChoice == 2 || [...])!
                if(packChoice < 1 || packChoice > packs.length) throw new ArrayIndexOutOfBoundsException();
                valueFound = true;
            }
            catch(InputMismatchException | ArrayIndexOutOfBoundsException e){
                System.out.println();
                System.out.println("Invalid Input");
                System.out.println();
            }
        }
        switch(packChoice){
            case 1:
                return getBranchesMain();
            default:
                System.out.println("[Debug] Something went wrong with choosing the branch; defaulting to main branch...");
                return getBranchesMain();
        }
    }


    public String[][] getBranchesMain(){
        //Branch 0 [Intro / Branch 6, Choice 3 / Branch 8, Choice 3 / [Modified Initial] Branch 12, Choice 1]:
        branches[0][0]="What do you want?";
        branches[0][1]="To hang out...";
        branches[0][2]="May I please turn off your fan?";
        branches[0][3]="I just wanted to talk.";
        //Branch 1 [Branch 0, Choice 1]:
        branches[1][0]="And do what?";
        branches[1][1]="Play games...";
        branches[1][2]="Well... nothing, really."; //Lose - Lauren-Style Loop 1
        branches[1][3]="I am not sure. Do you have any ideas?"; //Lose - Lauren-Style Loop 2
        //Branch 2 [Branch 1, Choice 1]:
        branches[2][0]="Like?";
        branches[2][1]="I don't know...";
        branches[2][2]=branches[2][1];
        branches[2][3]=branches[2][1];
        //Branch 3 [Branch 2, Any Choice]:
        branches[3][0]="Why do you even come in here if you have nothing to do?";
        branches[3][1]="I always hope that one day, you will have an idea as to what we could do."; //Lose - Insult
        branches[3][2]="So that I may spread my attractive Communist ideals to your domain, which has been blighted by capitalism!"; //Potential Loss - Hypocrite Loop
        branches[3][3]="I'm just bored.";
        //Branch 4 [Branch 3, Choice 3]:
        branches[4][0]="Well, I am pretty busy right now, so if you have nothing to do...";
        branches[4][1]="We can talk."; //Go to Branch 10
        branches[4][2]="You and I both know that my company is better than listening to that awful country music of yours."; //Lose - Banished
        branches[4][3]="What do you mean, you're \"pretty busy right now?\" You don't even look that busy."; //Lose - Insult
        //Branch 5 [Branch 0, Choice 2]:
        branches[5][0]="No.";
        branches[5][1]="Please?";
        branches[5][2]="If that is the case, then may I please dress myself in the proper attire?";
        branches[5][3]="Do you not see that I am freezing to death?!";
        //Branch 6 [Branch 5, Choices 1 & 2]:
        branches[6][0]="No!";
        branches[6][1]="Please?"; //Lose - Banished
        branches[6][2]="Why not?";
        branches[6][3]="Fine..."; //Go to Branch 0
        //Branch 7 [Branch 6, Choice 2]:
        branches[7][0]="It's not even that cold in here; you're just over-exaggerating.";
        branches[7][1]="I am literally freezing to death in here!"; //Go to Branch 9
        branches[7][2]="Are you kidding me? This place in uninhabitable! How do you even live here?"; //Lose - Insult
        branches[7][3]="At the very least, may I at least bring a blanket in here?";
        //Branch 8 [Branch 7, Choice 3]:
        branches[8][0]="I swear to Thomas Luther Bryan, if you ask to turn off my fan or to bring something else into my room one more time...";
        branches[8][1]="Please?"; //Lose - Banished
        branches[8][2]="You're using blankets yourself, you hypocrite!"; //Potential Loss - Hypocrite Loop
        branches[8][3]="Fine..."; //Go to Branch 0
        //Branch 9 [Branch 5, Choice 3 / Branch 7, Choice 1]:
        branches[9][0]="That's your warning for the day.";
        branches[9][1]="Do you even realize how ridiculous you sound right now?"; //Lose - Lauren-Style Loop
        branches[9][2]="Why are you so cruel?"; //Lose - Lauren-Style Loop
        branches[9][3]="Honestly, I am!"; //Lose - Lauren-Style Loop
        //Branch 10 [Branch 0, Choice 3 / Branch 4, Choice 1]:
        branches[10][0]="Fine... what do you want to talk about?";
        branches[10][1]="We can talk about new games that you might like."; //Lose - Lauren-Style Loop
        branches[10][2]="I am fine with talking about whatever you want.";
        branches[10][3]="I don't know...";
        //Branch 11 [Branch 10, Choice 2]:
        branches[11][0]="How about we talk about how nice it would be if you left me alone?";
        branches[11][1]="Is that a dismissal?"; //Lose - Dismissed
        branches[11][2]=branches[11][1]; //Lose - Dismissed
        branches[11][3]=branches[11][1]; //Lose - Dismissed
        //Branch 12 [Branch 10, Choice 3]:
        branches[12][0]="If you do not have anything useful to say, then I will make you useful. Go refill my water bottle. NOW!";
        branches[12][1]="[You proceed to rush to the water machine and bring Lauren her water in time.]"; //Go to Branch 0, but with a modified initial statement
        branches[12][2]="[You remain still, refusing to get Lauren her water.]"; //Lose - Countdown
        branches[12][3]="[You proceed to do the Mario.]"; //Win/Lose - Ascension
        return branches.clone();
    }
}
