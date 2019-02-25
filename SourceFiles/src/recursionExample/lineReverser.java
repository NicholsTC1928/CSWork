import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class lineReverser {
    public static void main(String[] args){
        //This example will also demonstrate how to read text files!
        File f = new File("Example"); //Notice how the file extension is NOT included here.
        try{
            Scanner input = new Scanner(f);
            reverse(input);
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void reverse(Scanner input){
        //Every recursive method must have a base case.
        if(!input.hasNextLine()){
            //This is the base case, so it will do nothing in this scenario. In methods that return a value, the if-
            //statement should return a value that does not rely on the recursive method.
        }
        else{
            //This is the recursive case.
            String line = input.nextLine();
            reverse(input);
            System.out.println(line);
        }
    }
}
