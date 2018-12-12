import java.util.*;

public class Fencepost {
    /* A fencepost loop is a loop where something has to be done one extra time. The name comes from fences, where the
    number of posts is always one more than the number of sections.

    Below is an example of a fencepost loop.
     */
    public static void main(String[] args){
        //This program will print out the numbers from one to ten. The first version will not work, as it puts an extra
        //comma.
        for(int i = 1; i <= 10;i++){
            System.out.print(i + ", ");
        }
        System.out.println();

        //To make this work, we can print the first number, and then print the comma first in the loop.
        System.out.print(1);
        for(int a = 2;a <= 10;a++){
            System.out.print(", " + a);
        }
        System.out.println();

        //Another example of a fencepost loop is a sentinel loop. This will ad numbers until the value of "-1" is
        //entered.
        Scanner input = new Scanner(System.in);
        int sum = 0;
        System.out.print("Enter a number, or enter -1 to quit. ");
        //The first number has to be read before the loop.
        int num = input.nextInt();
        while(num != -1){
            sum += num;
            num = input.nextInt();
        }
        System.out.println("The final number is " + sum + ".");
    }
}
