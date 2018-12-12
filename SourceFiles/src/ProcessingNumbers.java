import java.util.Scanner;
public class ProcessingNumbers
{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("How many numbers do you wish to enter? ");
        int length = input.nextInt();
        int[] values = new int[length];
        for(int i = 0;i <= (length - 1);i++){
            System.out.print("Enter a number to be processed. ");
            values[i] = input.nextInt();
        }
        int min = values[0];
        int max = values[0];
        for(int j = 0;j <= (length - 1);j++){
            if(values[j] < min) min = values[j];
            if(values[j] > max) max = values[j];
        }
        System.out.println("The smallest number was " + min + ".");
        System.out.println("The largest number was " + max + ".");
        int evenCount = 0;
        int maxEven = 0;
        int evenSum = 0;
        for(int k = 0;k <= (length - 1);k++){
            if(values[k] % 2 == 0){
                if(evenCount == 0) maxEven = values[k];
                else if(values[k] > maxEven) maxEven = values[k];
                evenSum+= values[k];
                evenCount++;
            }
        }
        if(evenCount == 0){
            System.out.println("There were no even integers.");
        }
        else{
            System.out.println("The sum of all even numbers typed is " + evenSum + ".");
            System.out.println("The largest even number typed was " + maxEven + ".");
        }
    }
}
