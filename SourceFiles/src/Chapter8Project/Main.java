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

        RationalNumber rN5 = new RationalNumber(4,-16);
        System.out.println("Rational Number 5: " + rN5.toString());

        RationalNumber sum1 = rN2.add(rN3);
        System.out.println("(" + rN2.toString() + ") + (" + rN3.toString() + ") = " + sum1.toString());

        RationalNumber difference1 = rN5.subtract(rN4);
        System.out.println("(" + rN5.toString() + ") - (" + rN4.toString() + ") = " + difference1.toString());

        RationalNumber product1 = rN1.multiply(rN3);
        System.out.println("(" + rN1.toString() + ") * (" + rN3.toString() + ") = " + product1.toString());

        RationalNumber quotient1 = rN4.divide(rN2);
        System.out.println("(" + rN4.toString() + ") / (" + rN2.toString() + ") = " + quotient1.toString());
        /*
        The following object instance does correctly throw an IllegalArgumentException error.
        RationalNumber rN6 = new RationalNumber(13,0);
        System.out.println("Rational Number 6: " + rN6.toString());
        */
    }
}
