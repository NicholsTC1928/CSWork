import java.util.*;
public class forEachLoops {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of names: ");
        int numNames = input.nextInt(); //Holds the number of names in the list
        String[] names = new String[numNames]; //Creates the array for the names
        for(int i = 0;i < numNames;i++){
            System.out.print("Enter a name: ");
            names[i] = input.next();
        }
        System.out.println("Here is a list of the names:");
        for(String n : names){ //For each n in array names...
            System.out.println(n);
        }
    }
}
