package Chapter8Project;

public class Main {
    public static void main(String[] args){
        RationalNumber rN1 = new RationalNumber(-7,5);
        System.out.println("Rational Number 1: " + rN1.toString());

        RationalNumber rN2 = new RationalNumber(-2,-6);
        System.out.println("Rational Number 2: " + rN2.toString());

        RationalNumber rN3 = new RationalNumber(4,2);
        System.out.println("Rational Number 3: " + rN3.toString());

        RationalNumber rN4 = new RationalNumber(17,1);
        System.out.println("Rational Number 4: " + rN4.toString());

        RationalNumber rN5 = new RationalNumber(13,0);
        System.out.println("Rational Number 5: " + rN5.toString());
    }
}
