public class Operators {
    public static void main(String[] args)
    {
        //In addition to, well, addition, the + operator can also be used for string concatenation. For example,...
        String num1 = "1";
        String num2 = "2";
        System.out.println(num1 + num2); //This will print out "12" as a string.
        //If using numbers, enter...
        System.out.println(1 + 2); //This will print out "3" as an integer value.
        //If not using variables for the strings, enter...
        System.out.println("1" + "2");

        //Incrementing - increase a value of a variable by a certain amount
        //Decrementing - decrease a value of a variable by a certain amount
        //Java has special operators for incrementing and decrementing values.
        int num3 = 1;
        num3 += 7; //This will add 7 to the value of the integer "num3."
        System.out.println(num3);
        num3 -= 7; //This will subtract 7 from the value of the integer "num3."
        System.out.println(num3);
        //This can also be used for both multiplying and dividing.
        num3 *= 7; //This will multiply the value of the integer "num3" by 7.
        System.out.println(num3);
        //Getting lazy already? Indolence is never the answer. Nevertheless, there is a solution.
        num3 /= 7; //This will divide the value of the integer "num3" by 7.
        print(num3); //This will call the method "print()" with the value of "num3."  This would return an error if the
        //second version of "print()," which takes integer values, did not exist.
        //If one makes the same method for different data types, he or she is "overloading" the method.
        //In C++, one can overload operators (e.g., make a + sign subtract). This does not apply to Java.
        double num4 = 5.67;
        print(num4); //This requires a third version of "print()" which accepts double values.

        //There are still more operators to remember: ++, which adds 1 to a variable, and --, which subtracts 1 from a
        // variable.
        int num5 = 154;
        num5++; //One could also type "++num5" for the same effect.
        print(num5);
        num5--;
        print(num5);
        print(++num5); //This will increase the value of "num5," and then print the updated value.
        print(num5++); //This will print the original value of "num5," and then increase the value of "num5." It does
        //NOT print the updated value, unless one were to print the value in a new command (e.g., "print(num5").
        print(num5);
    }

    //This is going to be a public method (meaning that it can be used out side of this class), and it will be static (so that
    //it does not have to be attached to an instance of a class object). This method is also considered void (meaning that it
    //returns nothing).
    public static void print(String value)
    {
        System.out.println(value);
    }

    public static void print(int value) //Using two methods with the same name is called "overloading."
    {
        System.out.println(value);
    }

    public static void print(double value)
    {
        System.out.println(value);
    }
}