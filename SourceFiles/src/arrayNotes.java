import java.util.*;
public class arrayNotes {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("How many days' temperatures are going to be reported? ");
        int days = input.nextInt();
        double[] temps = new double[days]; //This creates a double array with [days] elements.
        double sum = 0.0;

        for(int i = 0;i < days;i++){
            System.out.print("Enter the temperature for Day " + (i + 1) + ": ");
            double tempAdd = input.nextDouble();
            temps[i] = tempAdd;
            sum += tempAdd;
        }
        double average = sum / days;
        System.out.println("The average temperature is " + average + ".");

        //We will now begin a check to see which temperatures were above the average.
        int aboveCount = 0;
        for(int i = 0;i < days;i++){
            if(temps[i] > average) aboveCount++;
        }
        System.out.println("There were " + aboveCount + " days with temperatures above the average.");
    }
}
