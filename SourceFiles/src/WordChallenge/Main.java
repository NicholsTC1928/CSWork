package WordChallenge;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        System.out.println("This program serves as a Scrabble dictionary.");
        //A sorted dictionary file must be put into a list.
        Scanner in = new Scanner(new File("words.txt"));
        List<String> words = new ArrayList<String>();
        while(in.hasNext()){
            String word = in.next();
            words.add(word.toLowerCase());
        }

        //The list of words will then be searched via a binary search method.
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.print("Enter the word to challenge here: ");
            String word = input.nextLine();
            if(word.trim().length() == 0) break;
            int index = Collections.binarySearch(words, word);
            if(index >= 0) System.out.println("\"" + word + "\" is word number " + (index + 1) + " of " + words.size() + ".");
            else System.out.println(word + " is not found.");
        }
    }
}
