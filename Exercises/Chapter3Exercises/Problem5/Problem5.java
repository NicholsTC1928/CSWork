public class Problem5{
    public static void main(String[] args){
        printGrid(3,6);
        System.out.println();
        printGrid(5,3);
        System.out.println();
        printGrid(4,1);
        System.out.println();
        printGrid(1,3);
    }

    public static void printGrid(int rows,int cols){
        int j = 1;
        int print = 1;
        while(j <= rows){
            for(int i = 1;i <= cols;i++){
                if(i != cols) System.out.print(print + ", ");
                else System.out.print(print);
                print += rows;
            }
            System.out.println();
            print = j + 1;
            j += 1;
        }
    }
}