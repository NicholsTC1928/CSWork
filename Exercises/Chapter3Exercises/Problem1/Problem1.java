public class Problem1
{
    public static void main(String[] args)
    {
        printNumbers(15);
        printNumbers(5);
    }
    public static void printNumbers(int i){
        for (int j = 1; j <= i; j++)
        {
            System.out.print("[" + j + "] ");
        }
        System.out.println();
    }
}

