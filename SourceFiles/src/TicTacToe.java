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
        String name1Sign = name1 + " (X)";
        System.out.print("Enter the Name of Player 2 (O): ");
        String name2 = reader.next(); //Winner declared as "winP2"
        String name2Sign = name2 + " (O)";
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
                gameIsRunning = false; //Used for testing
            }

            else{
                updateBoard(currentP,name2,name2Sign);
                gameIsRunning = false; //Used for testing
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
        char letterCheck;
        for(;;){
            System.out.print(nameDisplay + " - Enter the name of the space that you wish to claim. ");
            choice = input.next();
            int inputLength = choice.length();
            letterCheck = choice.charAt(0);
            letterCheck = Character.toUpperCase(letterCheck);
            if(inputLength == 2) {
                if(letterCheck == 'A' || letterCheck == 'B' || letterCheck == 'C'){
                    if(choice.charAt(1) == '1' || choice.charAt(1) == '2' || choice.charAt(1) == '3'){
                        break;
                    }
                    else System.out.println("Please enter only two characters: a letter (A, B, or C) and a number (1, 2, or 3).");
                }
                else System.out.println("Please enter only two characters: a letter (A, B, or C) and a number (1, 2, or 3).");
            }
            else System.out.println("Please enter only two characters: a letter (A, B, or C) and a number (1, 2, or 3).");
        }
        char letterChoice = choice.charAt(0);
        char numberChar = choice.charAt(1);
        int numberChoice = Character.getNumericValue(numberChar);
        if(letterCheck == 'A'){
            if(pNum == 1){
                editArray(displayA,slotsA,"X",1,numberChoice);
            }
            else{
                editArray(displayA,slotsA,"O",2,numberChoice);
            }
        }
        else if(letterCheck == 'B'){
            if(pNum == 1){
                editArray(displayB,slotsB,"X",1,numberChoice);
            }
            else{
                editArray(displayB,slotsB,"O",2,numberChoice);
            }
        }
        else {
            if(pNum == 1){
                editArray(displayC,slotsC,"X",1,numberChoice);
            }
            else{
                editArray(displayC,slotsC,"O",2,numberChoice);
            }
        }
        System.out.println();
        System.out.println("   A  B  C");
        displayArray(displayA,displayB,displayC);
    }

    public static void editArray(String[] display,int[] slots,String sym,int check,int choice){
        display[choice - 1] = sym;
        slots[choice - 1] = check;
    }

    public static void displayArray(String[] displayA, String[] displayB, String[] displayC){
        System.out.println("1  " + displayA[0] + "  " + displayB[0] + "  " + displayC[0]);
        System.out.println("2  " + displayA[1] + "  " + displayB[1] + "  " + displayC[1]);
        System.out.println("3  " + displayA[2] + "  " + displayB[2] + "  " + displayC[2]);
    }

    public static void checkWin(int[] slotsA,int[] slotsB,int[] slotsC,int pNum){
        if(slotsA[0] == slotsA[1] && slotsA[0] == slotsA[2]){ //Vertical A Check

        }
        else if(slotsB[0] == slotsB[1] && slotsB[0] == slotsB[2]){ //Vertical B Check

        }
        else if(slotsC[0] == slotsC[1] && slotsC[0] == slotsC[2]){ //Vertical C Check

        }
        else if(slotsA[0] == slotsB[0] && slotsA[0] == slotsC[0]){ //Horizontal 1 Check

        }
        else if(slotsA[1] == slotsB[1] && slotsA[1] == slotsC[1]){ //Horizontal 2 Check

        }
        else if(slotsA[2] == slotsB[2] && slotsA[2] == slotsC[2]){ //Horizontal 3 Check

        }
    }
}
