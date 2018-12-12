public class parametersExamples
{
    public static void main(String[] args){
        System.out.print("*");
        writeSpaces(10); //This (10) is an actual parameter.
        System.out.println("*");
        writeChars('=',20);
        System.out.println();
        for(int i = 1; i <= 10; i++){
            writeChars('>',i);
            writeChars(' ',20 - 2 * i);
            writeChars('<',i);
            System.out.println();
        }
        int x = 17;
        System.out.println("Value before Call: " + x);
        doubleNumber(x);
        System.out.println("Value after Call: " + x); //When tested, it is shown that x does not change outside of the
        //method.
    }

    //The following method has one parameter: an integer called "number."
    public static void writeSpaces(int number){ //This (number) is a formal parameter.
        for(int i = 1; i <= number; i++){
            System.out.print(" ");
        }
    }

    //The following method will write a defined number of characters. There is no limit to the number of parameters
    //allowed in a method.
    public static void writeChars(char ch, int number){
        for(int i = 1; i <= number; i ++){
            System.out.print(ch);
        }
    }

    public static void doubleNumber(int number){
        System.out.println("Initial Value = " + number);
        number *= 2;
        System.out.println("Final Value = " + number);
    }
}
