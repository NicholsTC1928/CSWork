package Chapter8Project;

public class RationalNumber {
    private int numerator;
    private int denominator;

    public RationalNumber(int numerator, int denominator){
        if(denominator == 0) throw new IllegalArgumentException();
        //The while loop is meant to simplify the fraction. If the following expression is true, then the fraction can
        //be reduced (?).
        int newNum = numerator;
        int newDen = denominator;
        int greatestNum;
        if(Math.abs(numerator) >= Math.abs(denominator)) greatestNum = Math.abs(numerator);
        else greatestNum = Math.abs(denominator);
        int gcf = 1; //All values have a gcf of 1.
        for(int i = 1; i <= greatestNum; i++){
            if((Math.abs(numerator) % i) == 0 && (Math.abs(denominator) % i == 0)) gcf = i;
        }
        newNum /= gcf;
        newDen /= gcf;
        if((newDen < 0 && newNum > 0) || (newDen < 0 && newNum < 0)){
            newNum *= -1;
            newDen *= -1;
        }
        this.numerator = newNum;
        this.denominator = newDen;
    }

    public RationalNumber(){
        this(0,1);
    }

    public int getDenominator(){
        return this.denominator;
    }

    public int getNumerator(){
        return this.numerator;
    }

    public String toString(){
        if(this.denominator == 1) return Integer.toString(this.numerator);
        if(this.numerator == 0) return Integer.toString(0);
        return (this.numerator + " / " + this.denominator);
    }

    public RationalNumber add(RationalNumber r){
        int newNumThis = this.numerator;
        int newDenThis = this.denominator;
        int newNumR = r.numerator;
        int newDenR = r.denominator;
        if(this.denominator != r.denominator){
           int temp = this.denominator;
           newNumThis = this.numerator * r.denominator;
           newDenThis = this.denominator * r.denominator;
           newNumR = r.numerator * temp;
           newDenR = r.denominator * temp;
        }
        return (new RationalNumber((newNumThis + newNumR),newDenThis));
    }

    public RationalNumber subtract(RationalNumber r){
        RationalNumber rTemp = new RationalNumber((r.numerator * -1),r.denominator);
        return this.add(rTemp);
    }

    public RationalNumber multiply(RationalNumber r){
        return (new RationalNumber((this.numerator * r.numerator),(this.denominator * r.denominator)));
    }

    public RationalNumber divide(RationalNumber r){
        return (new RationalNumber((this.numerator * r.denominator),(this.denominator * r.numerator)));
    }
}
