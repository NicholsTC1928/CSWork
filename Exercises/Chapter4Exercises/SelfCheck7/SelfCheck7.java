import java.util.Scanner;
public class SelfCheck7{
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        System.out.print("Type a number: ");
        int input = reader.nextInt();

        if(input % 2 == 0) System.out.println("even");
        else System.out.println("odd");
    }
}