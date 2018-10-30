/*
Things to Do:
    -Finish offensive tactics for the AI.
    -Make the graphics (specifically the spacing between the lines) look cleaner.
 */

import java.util.Scanner;
import java.util.Random;

public class TicTacToe
{
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        boolean useAI = false;
        System.out.println("Welcome to Tic-Tac-Toe! This was programmed by Tyler Nichols.");
        System.out.println();
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
        System.out.println();
        if(pCount == 1){
            gameAI();
        }
        else{
            game();
        }
    }

    public static void gameAI(){ //Make 2-Player Game First
        Scanner reader = new Scanner(System.in);
        Random rand = new Random();
        final int startP = rand.nextInt(2) + 1; //2 is the maximum random integer, and 1 is the minimum.
        int currentP;
        System.out.print("Enter Your Name (X): ");
        String pName = reader.next(); //Winner declared as "winP1"
        String pNameSign = pName + " (X)";
        System.out.println();
        String cName = "CPU";
        String cNameSign = cName + " (O)";
        boolean gameIsRunning = true;
        int result;
        currentP = initializeGame(startP,pName,cName,true);
        String[] displayA = new String[]{"-","-","-"};
        String[] displayB = new String[]{"-","-","-"};
        String[] displayC = new String[]{"-","-","-"};
        int[] slotsA = new int[]{0,0,0};
        int[] slotsB = new int[]{0,0,0};
        int[] slotsC = new int[]{0,0,0};
        while(gameIsRunning){
            if(currentP == 1){
                result = updateBoard(displayA,displayB,displayC,slotsA,slotsB,slotsC,currentP,pName,pNameSign,false);
                if(result == 0) currentP = 2;
                else if(result == 5){
                    gameIsRunning = quitGame();
                }
                else{
                    checkWin2AI(result,pName,1);
                    gameIsRunning = false;
                }
            }
            else{
                result = moveAI(displayA,displayB,displayC,slotsA,slotsB,slotsC);
                if(result == 0) currentP = 1;
                else{
                    checkWin2AI(result,pName,2);
                    gameIsRunning = false;
                }
                //System.out.println(slotsA[0] + " " + slotsA[1] + " " + slotsA[2]);
                //gameIsRunning = false;
            }
        }
    }

    public static int finishAI(String[] displayA,String[] displayB,String[] displayC,int[] slotsA,int[] slotsB,int[] slotsC){
        System.out.println();
        displayArray(displayA,displayB,displayC);
        System.out.println();
        return checkWin(slotsA,slotsB,slotsC,2);
    }

    public static int moveAI(String[] displayA,String[] displayB,String[] displayC,int[] slotsA,int[] slotsB,int[] slotsC){ //Defense Finished - Create Offense
        boolean dA = checkSlotsDefense(displayA,slotsA);
        if(dA) return finishAI(displayA,displayB,displayC,slotsA,slotsB,slotsC);
        boolean dB = checkSlotsDefense(displayB,slotsB);
        if(dB) return finishAI(displayA,displayB,displayC,slotsA,slotsB,slotsC);
        boolean dC = checkSlotsDefense(displayC,slotsC);
        if(dC) return finishAI(displayA,displayB,displayC,slotsA,slotsB,slotsC);
        boolean d1 = checkSlotsDefenseHorizontal(slotsA,slotsB,slotsC,displayA,displayB,displayC,0);
        if(d1) return finishAI(displayA,displayB,displayC,slotsA,slotsB,slotsC);
        boolean d2 = checkSlotsDefenseHorizontal(slotsA,slotsB,slotsC,displayA,displayB,displayC,1);
        if(d2) return finishAI(displayA,displayB,displayC,slotsA,slotsB,slotsC);
        boolean d3 = checkSlotsDefenseHorizontal(slotsA,slotsB,slotsC,displayA,displayB,displayC,2);
        if(d3) return finishAI(displayA,displayB,displayC,slotsA,slotsB,slotsC);
        boolean dHorizontal = checkSlotsDefenseDiagonal(slotsA,slotsB,slotsC,displayA,displayB,displayC);
        if(dHorizontal) return finishAI(displayA,displayB,displayC,slotsA,slotsB,slotsC);
        //Only occurs if all are false:
        checkSlotsOffense(slotsA,slotsB,slotsC,displayA,displayB,displayC);
        //System.out.println("[Debug] AI has not made a move.");
        return finishAI(displayA,displayB,displayC,slotsA,slotsB,slotsC);
    }

    public static boolean checkSlotsDefense(String[] display,int[] slots){ //Finished
        int slotsOccupied = 0;
        for(int i = 0;i <= 2; i++){
            if(slots[i] == 1){
                slotsOccupied += 1;
            }
        }
        if(slotsOccupied == 2){
            boolean didMove = false;
            for(int j = 0;j <= 2;j++){
                if(slots[j] == 0){
                    slots[j] = 2;
                    display[j] = "O";
                    didMove = true;
                }
            }
            if(didMove) return true;
            else return false;
        }
        else return false;
    }

    public static boolean checkSlotsDefenseHorizontal(int[] slotsA,int[] slotsB,int[] slotsC,String[] displayA,String[] displayB,String[] displayC,int index){ //Finished
        int slotsOccupied = 0;
        int[] row = new int[]{slotsA[index],slotsB[index],slotsC[index]};
        for(int i = 0;i <= 2;i++){
            if(row[i] == 1){
                slotsOccupied += 1;
            }
        }
        if(slotsOccupied == 2){
            boolean didMove = false;
            for(int j = 0;j <= 2;j++){
                switch(row[j]){
                    case 0:
                        switch(j){
                            case 0:
                                slotsA[index] = 2;
                                displayA[index] = "O";
                                didMove = true;
                                break;
                            case 1:
                                slotsB[index] = 2;
                                displayB[index] = "O";
                                didMove = true;
                                break;
                            case 2:
                                slotsC[index] = 2;
                                displayC[index] = "O";
                                didMove = true;
                                break;
                            default:
                                break;
                        }
                        break;
                    default:
                        break;
                }
            }
            if(didMove) return true;
            else return false;
        }
        else return false;
    }

    public static boolean checkSlotsDefenseDiagonal(int[] slotsA,int[] slotsB,int[] slotsC,String[] displayA,String[] displayB,String[] displayC){ //Finished
        int slotsOccupied1 = 0;
        int slotsOccupied2 = 0;
        int[] diag1 = new int[]{slotsA[0],slotsB[1],slotsC[2]};
        int[] diag2 = new int[]{slotsA[2],slotsB[1],slotsC[0]};
        for(int i = 0;i <=2;i++){
            if(diag1[i] == 1) slotsOccupied1++;
            if(diag2[i] == 1) slotsOccupied2++;
        }
        if(slotsOccupied1 == 2){
            //boolean didMove = false;
            for(int k = 0;k <= 2;k++){
                if(diag1[k] == 0) {
                    switch (k){
                        case 0:
                            slotsA[0] = 2;
                            displayA[0] = "O";
                            return true;
                            //break;
                        case 1:
                            slotsB[1] = 2;
                            displayB[1] = "O";
                            return true;
                            //break;
                        case 2:
                            slotsC[2] = 2;
                            displayC[2] = "O";
                            return true;
                            //break;
                        default:
                            break;
                    }
                }
            }
        }
        else if(slotsOccupied2 == 2){
            //boolean didMove = false;
            for(int k = 0;k <= 2;k++){
                if(diag2[k] == 0) {
                    switch (k){
                        case 0:
                            slotsA[2] = 2;
                            displayA[2] = "O";
                            return true;
                            //break;
                        case 1:
                            slotsB[1] = 2;
                            displayB[1] = "O";
                            return true;
                            //break;
                        case 2:
                            slotsC[0] = 2;
                            displayC[0] = "O";
                            return true;
                            //break;
                        default:
                            break;
                    }
                }
            }
        }
        return false;
    }

    public static void checkSlotsOffense(int[] slotsA,int[] slotsB,int[] slotsC,String[] displayA,String[] displayB,String[] displayC){
        //Make finishing rows, columns, and diagonals a priority for the CPU.
        if (slotsB[1] == 0){ //Give CPU B2 if they start first, because that is the best spot.
            slotsB[1] = 2;
            displayB[1] = "O";
            return;
        }
        int[] row1 = new int[]{slotsA[0],slotsB[0],slotsC[0]};
        int[] row2 = new int[]{slotsA[1],slotsB[1],slotsC[1]};
        int[] row3 = new int[]{slotsA[2],slotsB[2],slotsC[2]};
        int[] d1 = new int[]{slotsA[0],slotsB[1],slotsC[2]};
        int[] d2 = new int[]{slotsA[2],slotsB[1],slotsC[0]};
        int aOccupied = 0;
        int bOccupied = 0;
        int cOccupied = 0;
        int r1Occupied = 0;
        int r2Occupied = 0;
        int r3Occupied = 0;
        int d1Occupied = 0;
        int d2Occupied = 0;
        for (int i = 0; i <= 2; i++){
            if (slotsA[i] == 2) aOccupied++;
            if (slotsB[i] == 2) bOccupied++;
            if (slotsC[i] == 2) cOccupied++;
            if(row1[i] == 2) r1Occupied++;
            if(row2[i] == 2) r2Occupied++;
            if(row3[i] == 2) r3Occupied++;
            if(d1[i] == 2) d1Occupied++;
            if(d2[i] == 2) d2Occupied++;
        }
        if (aOccupied == 2){ //Begin the vertical A check here.
            for (int a = 0; a <= 2; a++){
                switch (slotsA[a]){
                    case 0:
                        slotsA[a] = 2;
                        displayA[a] = "O";
                        return;
                    default:
                        break;
                }
            }
        }
        if (bOccupied == 2){ //Begin the vertical B check here.
            for (int b = 0; b <= 2; b++){
                switch (slotsB[b]){
                    case 0:
                        slotsB[b] = 2;
                        displayB[b] = "0";
                        return;
                    default:
                        break;
                }
            }
        }
        if(cOccupied == 2){ //Begin the vertical C check here.
            for(int c = 0;c <= 2;c++){
                switch(slotsC[c]){
                    case 0:
                        slotsC[c] = 2;
                        displayC[c] = "0";
                        return;
                    default:
                        break;
                }
            }
        }
        if(r1Occupied == 2){ //Begin the horizontal 1 check here.
            for(int i = 0;i <= 2;i++){
                switch(row1[i]){
                    case 0:
                        switch(i){
                            case 0:
                                slotsA[0] = 2;
                                displayA[0] = "O";
                                return;
                            case 1:
                                slotsB[0] = 2;
                                displayB[0] = "O";
                                return;
                            case 2:
                                slotsC[0] = 2;
                                displayC[0] = "O";
                                return;
                            default:
                                break;
                        }
                    default:
                        break;
                }
            }
        }
        if(r2Occupied == 2){ //Begin the horizontal 2 check here.
            for(int i = 0;i <= 2;i++){
                switch(row2[i]){
                    case 0:
                        switch(i){
                            case 0:
                                slotsA[1] = 2;
                                displayA[1] = "O";
                                return;
                            case 1:
                                slotsB[1] = 2;
                                displayB[1] = "O";
                                return;
                            case 2:
                                slotsC[1] = 2;
                                displayC[1] = "O";
                                return;
                        }
                    default:
                        break;
                }
            }
        }
        if(r3Occupied == 2){ //Begin the horizontal 3 check here.
            for(int i = 0;i <= 2;i++){
                switch(row3[i]){
                    case 0:
                        switch(i){
                            case 0:
                                slotsA[2] = 2;
                                displayA[2] = "O";
                                return;
                            case 1:
                                slotsB[2] = 2;
                                displayB[2] = "O";
                                return;
                            case 2:
                                slotsC[2] = 2;
                                displayC[2] = "O";
                                return;
                        }
                    default:
                        break;
                }
            }
        }
        if(d1Occupied == 2){ //Begin the diagonal A1/B2/C3 check here.
            for(int i = 0;i <= 2;i++){
                switch(d1[i]){
                    case 0:
                        switch(i){
                            case 0:
                                slotsA[0] = 2;
                                displayA[0] = "O";
                                return;
                            case 1:
                                slotsB[1] = 2;
                                displayB[1] = "O";
                                return;
                            case 2:
                                slotsC[2] = 2;
                                displayC[2] = "O";
                                return;
                            default:
                                break;
                        }
                    default:
                        break;
                }
            }
        }
        if(d2Occupied == 2){ //Begin the diagonal A3/B2/C1 check here.
            for(int i = 0;i <= 2;i++){
                switch(d2[i]){
                    case 0:
                        switch(i){
                            case 0:
                                slotsA[2] = 2;
                                displayA[2] = "O";
                                return;
                            case 1:
                                slotsB[1] = 2;
                                displayB[1] = "O";
                                return;
                            case 2:
                                slotsC[0] = 2;
                                displayC[0] = "O";
                                return;
                            default:
                                break;
                        }
                    default:
                        break;
                }
            }
        }
        //Pick a random spot to move if no other qualifications are met.
        Random rand = new Random();
        int randomChoice = rand.nextInt(9); //Understand that rand.nextInt(9) would choose a number from 0 to 8,
        //inclusive. Adding 1 changes the range of numbers to 1 to 9.
        switch(randomChoice){
            case 0:
                slotsA[0] = 2;
                displayA[0] = "O";
            case 1:
                slotsA[1] = 2;
                displayA[1] = "O";
            case 2:
                slotsA[2] = 2;
                displayA[2] = "O";
            case 3:
                slotsB[0] = 2;
                displayB[0] = "O";
            case 4:
                slotsB[1] = 2;
                displayB[1] = "O";
            case 5:
                slotsB[2] = 2;
                displayB[2] = "O";
            case 6:
                slotsC[0] = 2;
                displayC[0] = "O";
            case 7:
                slotsC[1] = 2;
                displayC[1] = "O";
            case 8:
                slotsC[2] = 2;
                displayC[2] = "O";
            default:
                break;
        }
    }

    public static void game(){
        Scanner reader = new Scanner(System.in);
        Random rand = new Random();
        final int startP = rand.nextInt(2) + 1; //2 is the maximum random integer, and 1 is the minimum.
        int currentP;
        System.out.print("Enter the Name of Player 1 (X): ");
        String name1 = reader.next(); //Winner declared as "winP1"
        String name1Sign = name1 + " (X)";
        System.out.println();
        System.out.print("Enter the Name of Player 2 (O): ");
        String name2 = reader.next(); //Winner declared as "winP2"
        String name2Sign = name2 + " (O)";
        boolean gameIsRunning = true;
        int result;
        currentP = initializeGame(startP,name1,name2,false);
        String[] displayA = new String[]{"-","-","-"};
        String[] displayB = new String[]{"-","-","-"};
        String[] displayC = new String[]{"-","-","-"};
        int[] slotsA = new int[]{0,0,0};
        int[] slotsB = new int[]{0,0,0};
        int[] slotsC = new int[]{0,0,0};
        while(gameIsRunning){
            if(currentP == 1){
                result = updateBoard(displayA,displayB,displayC,slotsA,slotsB,slotsC,currentP,name1,name1Sign,true);
                if(result == 0) currentP = 2;
                else if(result == 5){
                    gameIsRunning = quitGame();
                }
                else{
                    checkWin2(result,name1);
                    gameIsRunning = false;
                }
            }
            else{
                result = updateBoard(displayA,displayB,displayC,slotsA,slotsB,slotsC,currentP,name2,name2Sign,true);
                if(result == 0) currentP = 1;
                else if(result == 5){
                    gameIsRunning = quitGame();
                }
                else{
                    checkWin2(result,name2);
                    gameIsRunning = false;
                }
            }
        }
    }
    public static int updateBoard(String[] displayA,String[] displayB,String[] displayC,int[] slotsA,int[] slotsB,int[] slotsC,int pNum, String name, String nameDisplay,boolean displayBoard){
        Scanner input = new Scanner(System.in);
        String choice;
        char letterCheck;
        int numberChoice;
        boolean didQuit = false;
        for(;;){
            System.out.print(nameDisplay + " - Enter the name of the space that you wish to claim. ");
            choice = input.next();
            int inputLength = choice.length();
            letterCheck = choice.charAt(0);
            letterCheck = Character.toUpperCase(letterCheck);
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
                didQuit = true;
                break;
            }
            else System.out.println(invalidInput);
        }
        if(didQuit) return 5;
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
        else{
            if(pNum == 1){
                editArray(displayC,slotsC,"X",1,numberChoice);
            }
            else{
                editArray(displayC,slotsC,"O",2,numberChoice);
            }
        }
        System.out.println();
        if (displayBoard) displayArray(displayA,displayB,displayC);
        System.out.println();
        return checkWin(slotsA,slotsB,slotsC,pNum);
    }

    public static void editArray(String[] display,int[] slots,String sym,int check,int choice){
        display[choice - 1] = sym;
        slots[choice - 1] = check;
    }

    public static void displayArray(String[] displayA, String[] displayB, String[] displayC){
        System.out.println("   A  B  C");
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
        }
        else{
            System.out.println("All of the slots have been filled, but there is no winning combination. This game is a draw.");
        }
    }

    public static void checkWin2AI(int result,String pName,int currentP){
        if(result != 3){
            if(currentP == 1) System.out.println(pName + " is the winner! Congratulations!");
            else System.out.println("The CPU has won the game. Better luck next time!");
        }
        else{
            System.out.println("All of the slots have been filled, but there is no winning combination. This game is a draw.");
        }
    }

    public static boolean quitGame(){
        System.out.println();
        System.out.println("The game has preemptively ended, and thus there is no winner. This game is a draw.");
        return false;
    }

    public static int initializeGame(int startP,String name1,String name2,boolean isAIGame){
        int currentP;
        if(startP == 1){
            currentP = 1;
            System.out.println();
            System.out.println(name1 + " will make the first move.");
        }
        else {
            currentP = 2;
            System.out.println();
            System.out.println(name2 + " will make the first move.");
        }
        System.out.println("To quit the game, type in \"quit\" on your turn.");
        System.out.println();
        if(!isAIGame || currentP == 1){
            System.out.println("   A  B  C");
            System.out.println("1  -  -  -");
            System.out.println("2  -  -  -");
            System.out.println("3  -  -  -");
            System.out.println();
        }
        return currentP;
    }

    public static boolean checkResult(int result,int currentP,int nextP,boolean gameIsRunning,String name){
        if(result == 0){
            currentP = nextP;
            return true;
        }
        else if(result == 5){
            return quitGame();
        }
        else{
            checkWin2(result,name);
            return false;
        }
    }
}