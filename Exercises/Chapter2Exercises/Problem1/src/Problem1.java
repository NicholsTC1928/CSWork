//Tyler Nichols - 8/24/18 - Problem 1

public class Problem1
{
    public static void main(String[] args){
        double sO = 2.5;
        double vO = 25.0;
        double a = 1.8;
        double t = 10.0;
        double sF = (sO + (vO * t) + 0.5 * a * (t * t));
        System.out.println("The final speed is: " + sF);
    }
}

