package recursiveMath;

public class Main {
    public static void main(String[] args){
        System.out.println("3 to the 4th power (3^4) is " + pow(3,4) + ".");
        System.out.println("The greatest common denominator of 4 and 2 is " + gcd(4,2) + ".");
        System.out.println("The greatest common denominator of 80 and 125 is " + gcd(80,125) + ".");
    }

    public static int pow(int x,int y){
        if(y < 0) throw new IllegalArgumentException();
        else if(y == 0) return 1; //This is the base case.
        else if (y % 2 == 0) { //This means that the exponent is even.
            return pow(x * x,y / 2);
        }
        else{
            return (x * pow(x,y - 1));
        }
    }

    public static int gcd(int x,int y){
        if(x < 0 || y < 0) return gcd(Math.abs(x),Math.abs(y));
        else if(y == 0) return x; //This is the base case.
        else return gcd(y, (x % y)); //This is the recursive case, which activates only when y > 0.
    }
}
