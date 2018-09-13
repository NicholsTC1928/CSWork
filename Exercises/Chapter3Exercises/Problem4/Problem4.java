public class Problem4{
    public static void main(String[] args){
        printSquare(1,5);
        System.out.println();
        printSquare(3,9);
        System.out.println();
        printSquare(0,3);
        System.out.println();
        printSquare(5,5);
    }

    public static void printSquare(int start, int end){
        int printed = start;
        for(int j = 1; j <= (end - start + 1);j++){
            for(int i = 1;i <= (end - start + 1);i++){
                if(printed != end){
                    System.out.print(printed);
                    printed++;
                }
                else{
                    System.out.print(printed);
                    printed = start;
                }
            }
            System.out.println();
            printed += 1;
        }
    }
}