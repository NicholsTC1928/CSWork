package christmasGift;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class hangman {
    String[] words = {"MERRY CHRISTMAS","BIG TASTY WAS HERE","THAT COSTS MONEY","CANYON VIEW SUCKS","MILLENNIUM IS TRASH","SOPHIE IS A GIRL","ARIZONA IS BORING","I LOVE YOU GUYS","THANK YOU FOR EVERYTHING","DO NOT FEED GATORADE TO ANIMALS"};
    ArrayList<String> guessedChars = new ArrayList<>();
    public void hangmanGame() {
        Scanner input = new Scanner(System.in);
        Random r = new Random();
        String wordChoice = words[r.nextInt(10)];
        String wordChoiceDisplay = "";
        for(int i = 0;i < wordChoice.length();i++){
            if(!(wordChoice.substring(i,i+1).equals(" "))) wordChoiceDisplay += "*";
            else wordChoiceDisplay += " ";
        }
        System.out.println("Welcome to Hangman! This was programmed by Tyler Nichols.");
        System.out.println();
        System.out.println("When playing the game, the asterisks represent characters that can be guessed. Each incorrect guess will be counted against you; five incorrect guesses will end the game with a loss.");
        System.out.println();
        boolean gameContinues = true;
        int guesses = 5;
        while(gameContinues){
            //System.out.println();
            System.out.println(wordChoiceDisplay);
            System.out.println("Number of Incorrect Guesses Remaining: " + guesses);
            System.out.println();
            String temp = wordChoiceDisplay;
            int tempSize = this.guessedChars.size();
            if(this.guessedChars.size() != 0){
                System.out.print("You have guessed the following character(s): ");
                for(int i = 0;i < (this.guessedChars.size() - 1);i++){
                    System.out.print(this.guessedChars.get(i) + ", ");
                }
                System.out.println(this.guessedChars.get(this.guessedChars.size() - 1));
            }
            wordChoiceDisplay = printWord(wordChoice,wordChoiceDisplay);
            if(wordChoiceDisplay.equals(wordChoice)){
                System.out.println("You have won the game! Congratulations!");
                gameContinues = false;
            }
            if(wordChoiceDisplay.equals(temp) && tempSize != this.guessedChars.size()){
                guesses--;
            }
            if(guesses == 0){
                System.out.println("You have exhausted all of your available incorrect guesses, and thus you have lost. Here is the actual answer: ");
                System.out.println(wordChoice);
                gameContinues = false;
            }
        }
    }

    public String printWord(String word,String displayed){
        Scanner input = new Scanner(System.in);
        String guessWord = "";
        while(guessWord.length() != 1){
            System.out.print("Enter the character that you wish to guess: ");
            guessWord = input.next().toUpperCase();
            if(guessWord.length() != 1){
                System.out.println();
                System.out.println("Invalid Input - Please enter only one alphanumeric character into the field.");
                System.out.println();
            }
        }
        boolean isPresent = false;
        for(int i = 0;i < this.guessedChars.size();i++){
            if(guessWord.equals(this.guessedChars.get(i))) isPresent = true;
        }
        if(!isPresent) this.guessedChars.add(guessWord);
        else{
            System.out.println();
            System.out.println("You have already guessed this character.");
            return displayed;
        }
        try{
            int debugNum = Integer.parseInt(guessWord);
            System.out.println();
            System.out.println("Did you actually guess a number? Why would you even do that? Who guesses a number in Hangman?");
            System.out.println();
            return displayed;
        }
        catch(NumberFormatException e){

        }
        //boolean isCorrect = false;
        String newDisplayed = "";
        int numCorrect = 0;
        for(int i = 0;i < displayed.length();i++){
            if(guessWord.equals(word.substring(i,i + 1))){
                newDisplayed += guessWord;
                numCorrect++;
            }
            else if(word.substring(i,i + 1).equals(" ")) newDisplayed += " ";
            else newDisplayed += displayed.substring(i,i + 1);
        }
        if(newDisplayed.equals(displayed)){
            System.out.println();
            System.out.println("There are no \"" + guessWord + "s\" in the answer.");
            System.out.println();
        }
        else{
            System.out.println();
            if(numCorrect == 1) System.out.println("There is 1 \"" + guessWord + "\" in the answer.");
            else System.out.println("There are " + numCorrect + " \"" + guessWord + "s\" in the answer.");
            System.out.println();
        }
        return newDisplayed;
    }
}
