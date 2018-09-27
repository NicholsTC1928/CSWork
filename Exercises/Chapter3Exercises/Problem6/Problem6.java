public class Problem6{
    public static int largerAbsVal(int a,int b){
        if(a < 0) a *= -1;
        if(b < 0) b *= -1;
        if(a > b) return a;
        else return b;
    }

    public static void main(String[] args){
        System.out.println(largerAbsVal(11,2));
        System.out.println(largerAbsVal(4,-5));
    }
}