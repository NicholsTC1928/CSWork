import java.util.*;
public class IFElse
{
    public static void main(String[] args){
        //Grade Check Program
        Scanner input = new Scanner(System.in);
        System.out.println("This program will display your achieved letter grade.");
        System.out.print("Enter your grade as a percentage: ");
        int score = input.nextInt();

        if(score >= 90){
            System.out.println("Your letter grade is an \"A.\"");
        }
        else if(score >= 80){
            System.out.println("Your letter grade is a \"B.\"");
        }
        else if(score >= 70){
            System.out.println("Your letter grade is a \"C.\"");
        }
        else if(score >= 60){
            System.out.println("Your letter grade is a \"D.\"");
        }
        else{
            System.out.println("Your letter grade is an \"F.\"");
        }
    }
}
