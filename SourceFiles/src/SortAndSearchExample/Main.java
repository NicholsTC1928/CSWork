package SortAndSearchExample;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        System.out.print("Enter the desired word here: ");
        Scanner input = new Scanner(System.in);
        String word = input.nextLine();
        //The file must be loaded into a list.
        List<String> words = readBook("mobydick.txt");
        int index = words.indexOf(word);
        if(index >= 0) System.out.println(word + " is word number " + index + ".");
        else System.out.println(word + "is not found.");
    }

    //This method reads the text of the given file into a list.
    public static List<String> readBook(String fileName) throws FileNotFoundException{
        List<String> words = new ArrayList<String>();
        Scanner fInput = new Scanner(new File(fileName));
        while(fInput.hasNext()){
            words.add(fInput.next());
        }
        return words;
    }
}
