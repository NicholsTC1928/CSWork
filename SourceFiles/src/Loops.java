public class Loops
{
    public static void main(String[] args)
    {
        writeSquares();
    }

    public static void writeSquares()
    {
        //We are creating a program that will print the squares of the first five natural numbers.
        //This is one way that, although successful, is very tedious to create and unprofessional.
        System.out.println("Writing squares...");
        System.out.println(1 + " squared is " + (1 * 1));
        System.out.println(2 + " squared is " + (2 * 2));
        System.out.println(3 + " squared is " + (3 * 3));
        System.out.println(4 + " squared is " + (4 * 4));
        System.out.println(5 + " squared is " + (5 * 5));
        System.out.println();
        writeSquares2(); //You can call methods from inside of other methods.
    }

    public static void writeSquares2()
    {
        System.out.println("Writing squares more efficiently...");
        for(int i = 1; i <= 5; i++)
        {
            System.out.println(i + " squared is " + (i * i));

        }
        System.out.println();
        writeSquares3();
        //There are three parts to a for loop, and they are all optional.
        //The first part is used to initialize a variable (in this case, integer i is initialized with a value of 1).
        //The second part is the condition that will keep the loop repeating (in this case, the loop will continue until
        //i becomes 5, when it will run the loop one last time).
        //The third part is used to increment or decrement the variable by a set amount (in this case, i increases by 1).
        //It does not have to increase only by 1 each time.
    }

    public static void writeSquares3() //This one will go up to 100.
    {
        System.out.println("Writing squares up to 100...");
        for(int i = 1; i <= 100; i++)
        {
            System.out.println(i + " squared is " + (i * i));
        }
        System.out.println();
        writeSquares4(1000);
    }

    public static void writeSquares4(int stopVal)
    {
        System.out.println("Writing squares up to 1000...");
        System.out.println("Stop value is " + stopVal);
        for(int i = 1; i <= stopVal; i++)
        {
            System.out.println(i + " squared is " + (i * i));
        }
        System.out.println();
        writeSquares5();
    }

    public static void writeSquares5()
    {
        System.out.println("Writing Squares from 4 to 51...");
        for(int c = (2 * 2); c <= (17 * 3); c++)
        {
            System.out.println(c + " squared is " + (c * c));
        }
        System.out.println();
        writeSquares6();
    }

    public static void writeSquares6()
    {
        System.out.println("Writing Even Squares...");
        for(int count = 0; count <= 100; count += 2)
        {
            System.out.println(count + " squared is " + (count * count));
        }
        System.out.println();
        writeSquares7();
    }

    public static void writeSquares7()
    {
        System.out.println("Writing Squares in Inverse Order...");
        for(int n = 100; n >= 0; n--)
        {
            System.out.println(n + " squared is " + (n * n));
        }
        System.out.println();
        helloThere();
    }

    public static void helloThere() //This is an example of a loop inside of a loop.
    {
        for(int i = 1; i < 10; i++){
            for(int c = 1; c <= 4; c++){
                System.out.println("Hello There");
            }
            System.out.println("[Insert Name Here]");
        }
        System.out.println();
        nestedLoop();
    }

    public static void nestedLoop()
    {
        for(int i = 1; i <= 6; i++)
        {
            for(int j = 1; j <= 3; j++)
            {
                System.out.print(j + " ");
            }
        }
        System.out.println();
    }
}
