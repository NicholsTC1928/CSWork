public class Problem12{
    public static void main(String[] args){
        System.out.println(scientific(6.23,5.0));
        System.out.println(scientific(1.9,-2.0));
    }

    public static double scientific(double base, double exp){
        return (base * Math.pow(10,exp));
    }
}