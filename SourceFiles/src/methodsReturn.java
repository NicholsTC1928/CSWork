public class methodsReturn
{
    //Methods can return values, but there are rules that must be followed. You must specify the type of value that will
    //be returned, and then you must return said type. Failure to do so will give an error.

    //In the main method, the return type is void, so that no value is returned or expected to be returned.

    //The methods in the Math class are static, so that it is not necessary to create an instance. You can call the
    //methods by referencing the name of the class (Math), followed by a . and the name of the method.

    //The method that we will use is sqrt, which, based off of the method documentation, shows that the method has one
    //double parameter and returns a double value.

    public static void main(String[] args){
        for(int i = 1;i <= 100;i++){
            double root = Math.sqrt(i);
            System.out.println("The square root of " + i + " is " + root + ".");
        }
        //For this part, we will find the sum of the first 100 integers using the sum method specified below. We will
        //save the answer in a variable, and then print the value of said variable.
        int answer = sum(100);
        System.out.println("The sum of the first 100 integers is " + answer + ".");

        //This next part will find the hypotenuse of two triangles by using the pow method.
        double hyp = hypotenuse(3,4);
        System.out.println("The hypotenuse is: " + hyp + ".");
        hyp = hypotenuse(7,11);
        System.out.println("The hypotenuse is: " + hyp + ".");
        System.out.println("The hypotenuse is: " + hypotenuse(12,19) + "."); //It is not necessary to store the value
        //returned by a method in a variable.

        double vol = volume(3,4,5);
        System.out.println("The volume of a rectangular prism with sides of lengths 3, 4, and 5 is " + vol + ".");
    }

    //We can also have our own methods that return values, but you have to use the return statement within the method.
    //The method below uses Gauss' formula to find the sum of a series of integers.

    public static int sum(int n){ //Notice the use of int instead of void. This shows that the method returns an integer.
        return (n + 1) * n / 2; //This returns the specified integer value as the result of the method.
    }

    //This method will find the length of the hypotenuse by using Pythagorean's Theorem. It returns a double value
    //representing the length of the hypotenuse. It has two double parameters representing the other two sides of the
    //triangle, and uses two of the Math class methods: sqrt and pow. The sqrt method is one that you are familiar with;
    //the pow method takes two

    public static double hypotenuse(double a,double b){
        double c = Math.sqrt(Math.pow(a,2) + Math.pow(b,2));
        return c;
        //It should be noted that anything past the return value will not be processed.
    }

    public static double volume(double l,double w, double h){
        double v = l * w * h;
        return v;
    }
}
