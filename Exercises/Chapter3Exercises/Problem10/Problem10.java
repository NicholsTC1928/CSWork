public class Problem10{
    public static void main(String[] args){
        System.out.println(area(2.0));
    }

    public static double area(double rad){
        double val = (Math.PI * Math.pow(rad,2));
        return val;
    }
}