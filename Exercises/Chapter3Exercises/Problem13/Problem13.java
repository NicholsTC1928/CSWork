public class Problem13{
    public static void main(String[] args){
        System.out.println(pay(5.50,6));
        System.out.println(pay(4.00,11));
    }

    public static double pay(double salary,int hours){
        double overPay = salary * 1.5;
        if(hours > 8){
            double overHours = hours - 8;
            return ((salary * 8) + (overPay * overHours));
        }
        else return(salary * hours);
    }
}