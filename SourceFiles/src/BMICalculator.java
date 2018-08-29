import java.util.Scanner;

public class BMICalculator {

    public static void main(String[] args)
    {
        //Declaring Variables
        double height;
        double weight;
        double bmi;
        Scanner reader = new Scanner(System.in);

        //Computing BMI
        for(;;) { //The double semicolons create an infinite loop.
            System.out.println("Input Your Height (in Inches): ");
            height = reader.nextDouble();
            System.out.println("Input Your Weight (in Pounds): ");
            weight = reader.nextDouble();
            //height = 70;
            //weight = 195;
            bmi = weight / (height + height) * 703;

            //Print Results
            System.out.print("BMI (Body Mass Index) Calculation: ");
            System.out.println(bmi);
            System.out.println("Do you wish to make another calculation? (Y/N) ");
            boolean checkStop = true;
            if (checkStop){
                String input = reader.next().toLowerCase();
                if(input.equals("n")) break;
                else if(!input.equals("y")){
                    System.out.println("Please enter either a \"Y\" or an \"N.\"");
                }
            }
        }
    }
}