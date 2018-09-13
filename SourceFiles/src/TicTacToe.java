import java.util.Scanner;
import java.util.Random;

public class TicTacToe
{
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        boolean useAI = false;
        System.out.println("Welcome to Tic-Tac-Toe! This was programmed by Tyler Nichols.");
        System.out.print("How many players will be participating? (Enter either a \"1\" or a \"2.\") ");
        boolean numCheck = true;
        int pCount = reader.nextInt();
        while(numCheck){
            if(pCount != 1 && pCount != 2){
                System.out.println("Invalid Input");
                System.out.print("How many players will be participating? (Enter either a \"1\" or a \"2.\") ");
                int pCountEdit = reader.nextInt();
                pCount = pCountEdit;
            }
            else numCheck = false;
        }
        //String winner;
        if(pCount == 1){
            gameAI();
        }
        else{
            game();
        }


    }

    public static void gameAI(){ //Make 2-Player Game First
        System.out.println("This mode has not been implemented yet. Sorry for the inconvenience! :)");
    }

    public static void game(){
        Scanner reader = new Scanner(System.in);
        Random rand = new Random();
        final int startP = rand.nextInt(2) + 1; //2 is the maximum random integer, and 1 is the minimum.
        int currentP;
        int move = 1; //Declares whose move it is - Update as moves are completed.
        int useX;
        int useO;
        System.out.print("Enter the Name of Player 1 (X): ");
        String name1 = reader.next(); //Winner declared as "winP1"
        String name1Sign = name1 + "(X)";
        System.out.print("Enter the Name of Player 2 (O): ");
        String name2 = reader.next(); //Winner declared as "winP2"
        String name2Sign = name2 + "(O)";
        if(startP == 1){
            currentP = 1;
            //move = 1;
            useX = 1;
            //useO = 2;
            System.out.println(name1 + " will make the first move.");
        }
        else {
            currentP = 2;
            //move = 2;
            useX = 2;
            //useO = 1;
            System.out.println(name2 + " will make the first move.");
        }
        System.out.println("To access the help information, type in \"help\" during a move.");
        System.out.println();
        System.out.println("   A  B  C");
        System.out.println("1  -  -  -");
        System.out.println("2  -  -  -");
        System.out.println("3  -  -  -");
        System.out.println();
        boolean gameIsRunning = true;
        while(gameIsRunning){
            if(currentP == 1){
                updateBoard(currentP,name1,name1Sign);
            }

            else{
                updateBoard(currentP,name2,name2Sign);
            }
        }


    }
    public static void updateBoard(int pNum, String name, String nameDisplay){
        String[] displayA = new String[]{"-","-","-"};
        String[] displayB = new String[]{"-","-","-"};
        String[] displayC = new String[]{"-","-","-"};
        int[] slotsA = new int[]{0,0,0};
        int[] slotsB = new int[]{0,0,0};
        int[] slotsC = new int[]{0,0,0};
        //boolean checkText = true;
        Scanner input = new Scanner(System.in);
        String choice;
        for(;;){
            System.out.print(nameDisplay + " - Enter the name of the space that you wish to claim. ");
            choice = input.next();
            int inputLength = choice.length();
            if(inputLength == 2) break;
            else System.out.println("Please enter only two characters: a letter (A, B, or C) and a number (1, 2, or 3).");
        }
        if (pNum == 1){
            char letterChoice = choice.charAt(0);
            char numberChar = choice.charAt(1);
            int numberChoice = Character.
            if(letterChoice == 'A'){

            }
        }
        else{

        }
    }
}
