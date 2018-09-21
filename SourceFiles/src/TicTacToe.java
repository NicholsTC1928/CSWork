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
        //int move = 1; //Declares whose move it is - Update as moves are completed.
        //int useX;
        //int useO;
        System.out.print("Enter the Name of Player 1 (X): ");
        String name1 = reader.next(); //Winner declared as "winP1"
        String name1Sign = name1 + " (X)";
        System.out.print("Enter the Name of Player 2 (O): ");
        String name2 = reader.next(); //Winner declared as "winP2"
        String name2Sign = name2 + " (O)";
        if(startP == 1){
            currentP = 1;
            //move = 1;
            //useX = 1;
            //useO = 2;
            System.out.println(name1 + " will make the first move.");
        }
        else {
            currentP = 2;
            //move = 2;
            //useX = 2;
            //useO = 1;
            System.out.println(name2 + " will make the first move.");
        }
        System.out.println("To quit the game, type in \"quit\" on your turn.");
        System.out.println();
        System.out.println("   A  B  C");
        System.out.println("1  -  -  -");
        System.out.println("2  -  -  -");
        System.out.println("3  -  -  -");
        System.out.println();
        boolean gameIsRunning = true;
        int result;
        String[] displayA = new String[]{"-","-","-"};
        String[] displayB = new String[]{"-","-","-"};
        String[] displayC = new String[]{"-","-","-"};
        int[] slotsA = new int[]{0,0,0};
        int[] slotsB = new int[]{0,0,0};
        int[] slotsC = new int[]{0,0,0};
        while(gameIsRunning){
            if(currentP == 1){
                result = updateBoard(displayA,displayB,displayC,slotsA,slotsB,slotsC,currentP,name1,name1Sign);
                if(result == 0) currentP = 2;
                else{
                    checkWin2(result,name1);
                    gameIsRunning = false;
                }
            }

            else{
                result = updateBoard(displayA,displayB,displayC,slotsA,slotsB,slotsC,currentP,name2,name2Sign);
                if(result == 0) currentP = 1;
                else{
                    checkWin2(result,name2);
                    gameIsRunning = false;
                }
            }
        }


    }
    public static int updateBoard(String[] displayA,String[] displayB,String[] displayC,int[] slotsA,int[] slotsB,int[] slotsC,int pNum, String name, String nameDisplay){
        //String[] displayA = new String[]{"-","-","-"};
        //String[] displayB = new String[]{"-","-","-"};
        //String[] displayC = new String[]{"-","-","-"};
        //int[] slotsA = new int[]{0,0,0};
        //int[] slotsB = new int[]{0,0,0};
        //int[] slotsC = new int[]{0,0,0};
        //boolean checkText = true;
        Scanner input = new Scanner(System.in);
        String choice;
        char letterCheck;
        int numberChoice;
        for(;;){
            System.out.print(nameDisplay + " - Enter the name of the space that you wish to claim. ");
            choice = input.next();
            int inputLength = choice.length();
            letterCheck = choice.charAt(0);
            letterCheck = Character.toUpperCase(letterCheck);
            //String slotChoice = "slots" + Character.toString(letterCheck);
            char numberChar = choice.charAt(1);
            numberChoice = Character.getNumericValue(numberChar);
            String choiceQuit = choice.toLowerCase();
            String invalidInput = "Please enter only two characters: a letter (A, B, or C) and a number (1, 2, or 3).";
            if(inputLength == 2) {
                if(numberChoice == 1 || numberChoice == 2 || numberChoice == 3){
                    boolean vacant = false;
                    switch (letterCheck){
                        case 'A':
                            if(slotsA[numberChoice - 1] == 0) vacant = true;
                            break;
                        case 'B':
                            if(slotsB[numberChoice - 1] == 0) vacant = true;
                            break;
                        case 'C':
                            if(slotsC[numberChoice - 1] == 0) vacant = true;
                            break;
                        default:
                            System.out.println(invalidInput);
                            break;
                    }
                    if(!vacant){
                        System.out.println("This slot has already been occupied; please choose another slot.");
                        displayArray(displayA,displayB,displayC);
                    }
                    else break;
                }
                else System.out.println(invalidInput);
            }
            else if(choiceQuit.equals("quit")){

            }
            else System.out.println(invalidInput);
        }

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
        System.out.println();
        return checkWin(slotsA,slotsB,slotsC,pNum);
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

    public static int checkWin(int[] slotsA,int[] slotsB,int[] slotsC,int pNum){
        if(slotsA[0] == slotsA[1] && slotsA[0] == slotsA[2] && slotsA[0] != 0){ //Vertical A Check
            if(pNum == 1) return 1;
            else return 2;
        }
        else if(slotsB[0] == slotsB[1] && slotsB[0] == slotsB[2] && slotsB[0] != 0){ //Vertical B Check
            if(pNum == 1) return 1;
            else return 2;
        }
        else if(slotsC[0] == slotsC[1] && slotsC[0] == slotsC[2] && slotsC[0] != 0){ //Vertical C Check
            if(pNum == 1) return 1;
            else return 2;
        }
        else if(slotsA[0] == slotsB[0] && slotsA[0] == slotsC[0] && slotsA[0] != 0){ //Horizontal 1 Check
            if(pNum == 1) return 1;
            else return 2;
        }
        else if(slotsA[1] == slotsB[1] && slotsA[1] == slotsC[1] && slotsA[1] != 0){ //Horizontal 2 Check
            if(pNum == 1) return 1;
            else return 2;
        }
        else if(slotsA[2] == slotsB[2] && slotsA[2] == slotsC[2] && slotsA[2] != 0){ //Horizontal 3 Check
            if(pNum == 1) return 1;
            else return 2;
        }
        else if(slotsA[0] == slotsB[1] && slotsA[0] == slotsC[2] && slotsA[0] != 0){ //Diagonal \ Check
            if(pNum == 1) return 1;
            else return 2;
        }
        else if(slotsA[2] == slotsB[1] && slotsA[2] == slotsC[0] && slotsA[2] != 0){ //Diagonal / Check
            if(pNum == 1) return 1;
            else return 2;
        }
        else{
            int count = 0;
            for(int i = 0;i <= 2;i++){
                if(slotsA[i] != 0 && slotsB[i] != 0 && slotsC[i] != 0){
                    count++;
                }
            }
            if(count == 3) return 3;
            else return 0;
        }
    }

    public static void checkWin2(int result,String name){
        if(result != 3){
            System.out.println(name + " is the winner! Congratulations!");
            //gameIsRunning = false;
        }
        else{
            System.out.println("All of the slots have been filled, but there is no winning combination. This game is a draw.");
            //gameIsRunning = false;
        }
    }
}
