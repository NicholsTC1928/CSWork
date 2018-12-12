import java.util.*; //Please note that adding every method and class can lead to slow loading times. For easy
//optimization, only import the methods that you will use within the program.

public class objectsMethods
{
    //In this program, we will use methods from classes that are not static. To use methods from non-static classes,
    //it is necessary to create an instance or object of the class. This is generally done by using the "new" keyword
    //and calling a special method, called the constructor. The definition of an object is a programming entity that
    //contains state (data) and behavior (methods). We will start with one of the most used classes: the String class.
    //This is the only class which does not require the "new" keyword to create and instance of it, but one may use it,
    //anyways.

    public static void main(String[] args){
        //There are two ways to create a string in Java, and they are described below.
        String a = "String1";
        String b = new String("OtherString"); //This is considered redundant, but it still works.
        System.out.println(a);
        System.out.println(b);

        //The String class has many methods to work with strings. However, they are not static methods, so they need
        //to be called on an instance of a string. For example, look up the Java documentation for the length method.

        //We will now compare the lengths of the strings a and b.
        System.out.println("The length of the first string is " + a.length() + ".");
        System.out.println("The length of the second string is " + b.length() + ".");

        //Some examples of useful String method are as follows:
        //charAt()
        //indexOf()
        //substring()
        //toLowerCase()
        //toUpperCase()
        //trim() - This one is especially useful, as it gets rid of leading and ending whitespace in a string.

        //Strings are immutable objects, meaning that their value cannot be changed.
        String hi = "Hello, world!";
        hi.toUpperCase(); //This has no effect, as the value of hi is not changed.
        System.out.println(hi);
        hi = hi.toUpperCase(); //This effectively changes the value of hi. You can also declare another variable as
        //being equal to hi.toUpperCase(), and this will not change the value of hi.
        System.out.println(hi);

        //We will now look at another class called Scanner, which lets us take input from the user. Objects of this
        //class can only be made by using the "new" keyword and the constructor.

        //In order to use Scanner methods, you must import the corresponding java.util package (in this case, type
        //"import java.util.Scanner;") at the top of the program, but you may also add all java.util packages by
        //typing "import java.util.*;" at the top of the program. The * is a placeholder, and it means importing
        //everything, including the Scanner class.

        Scanner console = new Scanner(System.in); //This allows you to take input and save it into different variables.
        System.out.print("Please enter your name: ");
        String name = console.next(); //The next() method takes the input as a string value.
        System.out.println("Hello, " + name.toUpperCase() + "!");

        //You can use the Scanner method to save numbers, but make sure to use the correct value type.
        System.out.print("Enter a number: ");
        int num = console.nextInt(); //The nextInt() method takes the input as an integer value.
        System.out.println(num + " squared is " + (num * num) + ".");
    }
}
