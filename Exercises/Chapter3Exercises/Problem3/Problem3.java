public class Problem3{
    public static void main(String[] args){
        printPowersOfN(4,3);
        printPowersOfN(5,6);
        printPowersOfN(-2,8);
    }

    public static void printPowersOfN(int base,int power){
        int printedValue = 1;
        for(int i = 1; i <= power + 1;i++){
            System.out.print(printedValue + " ");
            printedValue *= base;
        }
        System.out.println();
    }
}