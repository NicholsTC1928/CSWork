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
        while((Math.abs(newNum) % Math.abs(newDen)) == 0){
            int greatestNum;
            if(Math.abs(numerator) >= Math.abs(denominator)) greatestNum = Math.abs(numerator);
            else greatestNum = Math.abs(denominator);
            int gcf = 1; //All values have a gcf of 1.
            for(int i = 1; i <= greatestNum; i++){
                if((Math.abs(numerator) % i) == 0 && (Math.abs(denominator) % i == 0)) gcf = i;
            }
            newNum /= gcf;
            newDen /= gcf;
        }
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
}
