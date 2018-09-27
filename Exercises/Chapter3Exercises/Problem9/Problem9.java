public class Problem9{
    public static void main(String[] args){
        System.out.println(lastDigit(-947));
        System.out.println(lastDigit(3572));
        System.out.println(lastDigit(6));
        System.out.println(lastDigit(35));
        System.out.println(lastDigit(123456));
    }

    public static int lastDigit(int a){
        if(a >= 0) return (a % 10);
        else{
            a *= -1;
            return (a % 10);
        }
    }
}