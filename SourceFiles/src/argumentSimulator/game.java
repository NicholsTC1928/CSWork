package argumentSimulator;

import java.util.Scanner;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

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
        section();
        System.out.println();
        System.out.println("You arrive at Lauren's Domain, a hostile territory that reflects the cold-hearted nature of its ruler. As soon as you enter, you feel an awful breeze, cold enough to kill even the most resilient of creatures. The first thought that comes to your mind is how anybody could live here.");
        System.out.println();
        System.out.println("Upon entering, Lauren barely glances in your direction; she obviously does not care about your discomfort caused by the cool breeze. With a loud sigh, she finally acknowledges your existence.");
        branches b = new branches();
        String[][] branchArr = b.getBranches();
        int cBranch = 0;
        int cDecision;
        boolean gameGo = true;
        int timerFreeze = 0;
        while(gameGo){
            if(timerFreeze >= 10){
                exitGameDead();
                gameGo = false;
            }
            if(cBranch <= 12){
                cDecision = displayChoices(branchArr,cBranch);
                if(cDecision == 4){
                    exitGameChoice();
                    gameGo = false;
                }
                //Make sure that none of the branch numbers in the comments have brackets, since that means that the branch is unfinished.
                switch(cBranch){
                    case 0: //Choice 1: Branch 1 / Choice 2: Branch 5 / Choice 3: [Branch 10]
                        cBranch = bSwitch(0,cDecision,1,5,10);
                        break;
                    case 1: //Choice 1: Branch 2 / Choice 2: Branch 13 / Choice 3: Branch 14
                        cBranch = bSwitch(1,cDecision,2,13,14);
                        break;
                    case 2: //All Choices: Branch 3
                        cBranch = bSwitch(2,cDecision,3,3,3);
                        break;
                    case 3: //Choice 1: Branch 15 / Choice 2: Branch 16 / Choice 3: Branch 4
                        cBranch = bSwitch(3,cDecision,15,16,4);
                        break;
                    case 4: //Choice 1: [Branch 10] / Choice 2: Branch 17 / Choice 3: Branch 18
                        cBranch = bSwitch(4,cDecision,10,17,18);
                        break;
                    case 5: //Choices 1 & 2: Branch 6 / Choice 3: Branch 0
                        cBranch = bSwitch(5,cDecision,6,6,0);
                        break;
                    case 6: //Choice 1: Branch 17 / Choice 2: Branch 7 / Choice 3: Branch 0
                        cBranch = bSwitch(6,cDecision,17,7,0);
                        break;
                    case 7: //Choice 1: [Branch 9] / Choice 2: Branch 19 / Choice 3: Branch 8
                        cBranch = bSwitch(7,cDecision,9,19,8);
                        break;
                    case 8: //Choice 1: Branch 17 / Choice 2: Branch 20 / Choice 3: Branch 0
                        cBranch = bSwitch(8,cDecision,17,20,0);
                        break;
                    case 9: //Choice 1: Branch 21 / Choice 2: Branch 22 / Choice 3: Branch 23
                        cBranch = bSwitch(9,cDecision,21,22,23);
                        break;
                    case 10: //Choice 1: Branch 24 / Choice 2: Branch 11 / Choice 3: [Branch 12]
                        cBranch = bSwitch(10,cDecision,24,11,12);
                        break;
                    case 11: //All Choices: [Dismissal]
                        cBranch = bSwitch(11,cDecision,25,25,25);
                        break;
                    case 12: //Choice 1: [Modified] Branch 0 / Choice 2: [Death by Countdown] / Choice 3: [Ascension]
                    default:
                        System.out.println("[Debug] Not finished yet"); //Debug
                        gameGo = false; //Debug
                        break;
                }
            }
            else{
                switch(cBranch){ //This switch must be placed here in order to prevent an ArrayIndexOutOfBoundsException error. Also, all of these cases lead to the game ending.
                    case 13: //Lauren-Style Loop 1 [Branch 1, Choice 2]
                        trapLaurenStyle(timerFreeze,"You never have anything to do.","That's not true!","Yes, it is.","No, it's not!","Yes, it is");
                        exitGameDead();
                        break;
                    case 14: //Lauren-Style Loop 2 [Branch 1, Choice 3]
                        trapLaurenStyle(timerFreeze,"Why should I even try? It's not like you will ever do anything that I want.","Sure, I will!","No, you won't.","Yes, I will!","No, you won't");
                        exitGameDead();
                        break;
                    case 15: //Insult 1 [Branch 3, Choice 1]
                        exitGameInsult("That's pretty funny, considering that you never have any good ideas yourself.");
                        break;
                    case 16://Hypocrite Loop 1 [Branch 3, Choice 2]
                        trapHypocrite("I did not allow you to be in my presence just so you could spread those Communist lies of yours, you hypocrite!");
                        exitGameDead();
                        break;
                    case 17: //Banished [Branch 4, Choice 2 / Branch 6, Choice 1 / Branch 8, Choice 1]
                        exitGameBanished();
                        break;
                    case 18: //Insult 2 [Branch 4, Choice 3]
                        exitGameInsult("Well, I'm busier right now than you'll ever be.");
                        break;
                    case 19: //Insult 3 [Branch 7, Choice 2]
                        exitGameInsult("It's easy for any human being to live here. The problem that you have is that you aren't human; you're more like a monkey.");
                        break;
                    case 20: //Hypocrite Loop 2 [Branch 8, Choice 2]
                        trapHypocrite("Hypocrite!");
                        exitGameDead();
                        break;
                    case 21: //Lauren-Style Loop 3 [Branch 9, Choice 1]
                        trapLaurenStyle(timerFreeze,"I am only being realistic.","Realistic?! I'm freezing to death right now!","No, you aren't.","Yes, I am!","No, you aren't");
                        exitGameDead();
                        break;
                    case 22: //Lauren-Style Loop 4 [Branch 9, Choice 2]
                        trapLaurenStyle(timerFreeze,"Well, maybe if you weren't so ridiculous, I would treat you more kindly.","So, it's my fault that you treat me so poorly?","Yes, it is.","No, it isn't!","Yes, it is");
                        exitGameDead();
                        break;
                    case 23: //Lauren-Style Loop 5 [Branch 9, Choice 3]
                        trapLaurenStyle(timerFreeze,"You're just being overdramatic.","I'm telling the truth!","No, you aren't.","Yes, I am!","No, you aren't");
                        exitGameDead();
                        break;
                    case 24: //Lauren-Style Loop 6 [Branch 10, Choice 1]
                        trapLaurenStyle(timerFreeze,"You and I both know that we won't find anything.","You don't know that!","Yes, I do.","No, you don't!","Yes, I do");
                        exitGameDead();
                        break;
                    case 25: //Dismissal [Branch 11, All Choices]
                        exitGameDismissal();
                        break;
                    default:
                        System.out.println("[Debug]: Not finished yet"); //Debug
                        break;
                }
                gameGo = false;
            }
            timerFreeze++;
        }
    }

    public static void section(){
        System.out.println();
        for(int i = 0; i < 20; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public static int bSwitch(int cBranch,int cDecision,int d1Result,int d2Result,int d3Result){
        switch(cDecision){
            case 1:
                cBranch = d1Result;
                break;
            case 2:
                cBranch = d2Result;
                break;
            case 3:
                cBranch = d3Result;
                break;
            default:
                break;
        }
        return cBranch;
    }

    public static int displayChoices(String[][] branchArr,int cBranch,boolean useCountdown){
        Scanner input = new Scanner(System.in);
        Timer t = new Timer();
        TimerTask task = new TimerTask(){
            @Override public void run(){
                t.cancel();
            }
        };
        System.out.println();
        System.out.println("Lauren: " + branchArr[cBranch][0]);
        System.out.println();
        System.out.println("[Below is a list of possible responses for your rebuttal.]");
        System.out.println();
        System.out.println("1: " + branchArr[cBranch][1]);
        System.out.println("2: " + branchArr[cBranch][2]);
        System.out.println("3: " + branchArr[cBranch][3]);
        System.out.println("4: [Choosing this will end the game with a loss.]");
        System.out.println();
        String decision;
        for(;;){
            System.out.print("Please enter the number corresponding to your desired response. (Enter only an integer between 1 and 4.) ");
            decision = input.next();
            if(decision.equals("1") || decision.equals("2") || decision.equals("3") || decision.equals("4")){
                section();
                return Integer.parseInt(decision);
            }
            else{
                System.out.println("Invalid Input");
                System.out.println();
            }
        }
    }

    public static void trapLaurenStyle(int timerFreeze,String initial,String choice,String initial2,String choice2,String last){
        Scanner input = new Scanner(System.in);
        Random r = new Random();
        int limit = r.nextInt(4) + 1; //Range is from 1 to 5
        for(int i = 0;i < limit;i++){
            System.out.println();
            System.out.println("Lauren: " + initial);
            System.out.println();
            System.out.println("[Below is a list of possible responses for your rebuttal.]");
            System.out.println();
            System.out.println("1: " + choice);
            System.out.println("2: " + choice);
            System.out.println("3: " + choice);
            System.out.println("4: [Choosing this will end the game with a loss.]");
            System.out.println();
            String decision;
            for(;;){
                System.out.print("Please enter the number corresponding to your desired response. (Enter only an integer between 1 and 4.) ");
                decision = input.next();
                if(decision.equals("1") || decision.equals("2") || decision.equals("3") || decision.equals("4")){
                    section();
                    break;
                }
                else{
                    System.out.println("Invalid Input");
                    System.out.println();
                }
            }
            initial = initial2;
            choice = choice2;
        }
        System.out.println();
        System.out.println("Lauren: " + last + "; end of discussion, Lauren-style!");
    }

    public static void trapHypocrite(String lInitial){
        Scanner input = new Scanner(System.in);
        String[] lDialogue = {"Communist!","Thank you!","*disgruntled mocking noise*"};
        String[] pDialogue = {"Hypocrite!","Capitalist!","You're welcome!","*disgruntled mocking noise"};
        System.out.println();
        System.out.println("Lauren: " + lInitial);
        System.out.println();
        for(int i = 0; i < 4;i++){
            if(i > 0){
                System.out.println();
                System.out.println("Lauren: " + lDialogue[i - 1]);
                System.out.println();
            }
            System.out.println("[Below is a list of possible responses for your rebuttal.]");
            System.out.println();
            System.out.println("1: " + pDialogue[i]);
            System.out.println("2: " + pDialogue[i]);
            System.out.println("3: " + pDialogue[i]);
            System.out.println("4: [Choosing this will end the game with a loss.]");
            System.out.println();
            String decision;
            for(;;){
                System.out.print("Please enter the number corresponding to your desired response. (Enter only an integer between 1 and 4.) ");
                decision = input.next();
                if(decision.equals("1") || decision.equals("2") || decision.equals("3") || decision.equals("4")){
                    section();
                    break;
                }
                else{
                    System.out.println("Invalid Input");
                    System.out.println();
                }
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
  
    public static void exitGameInsult(String insult){
        System.out.println();
        System.out.println("Lauren: " + insult);
        System.out.println();
        System.out.println("With that last roast, your self-esteem was finally demolished. You quickly rush out of Lauren's Domain in order to spare the rest of your dignity; its heartless ruler laughs as you retreat. As you rush to safer territory, you realize that your life will never be the same again.");
        System.out.println();
        System.out.println("Game Over");
        System.out.println("You fled from Lauren's Domain in order to protect your feeling of self-worth.");
    }

    public static void exitGameDismissal(){
        System.out.println();
        System.out.println("Lauren: Yes.");
        System.out.println();
        System.out.println("As you begin to exit Lauren's Domain, you feel a strange sensation: hope. Realizing that you were not banished, you quickly begin to plan your next venture into that hostile territory. By the time you are ready to enter once more, another sensation overwhelms you: fear. Worried that your next trip might be your last, you never return to Lauren's Domain.");
        System.out.println();
        System.out.println("Game Over");
        System.out.println("You were dismissed from Lauren's Domain.");
    }

    public static void exitGameBanished(){
        System.out.println("BANISHED!");
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
