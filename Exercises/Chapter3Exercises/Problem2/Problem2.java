public class Problem2{
    public static void main(String[] args){
        printPowersOf2(3);
        printPowersOf2(10);
    }

    public static void printPowersOf2(int i){
        int printedValue = 1;
        for(int j = 1;j <= i + 1;j++){
            System.out.print(printedValue + " ");
            printedValue *= 2;
        }
        System.out.println();
    }
}