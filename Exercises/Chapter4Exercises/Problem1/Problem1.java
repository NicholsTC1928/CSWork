public class Problem1{
    public static void main(String[] args){
        System.out.println(fractionSum(5));
    }
    public static double fractionSum(int n){
        //Scanner input = new Scanner(System.in);
        double sum = 0;
        for(int j = 1;j <= n;j++){
            double val = j / 1.0;
            sum += (1 / val);
        }
        return sum;
    }
}