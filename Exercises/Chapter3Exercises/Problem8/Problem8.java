public class Problem8{
    public static void main(String[] args){
        quadratic(1,-7,12);
        System.out.println();
        quadratic(1,3,2);
    }

    public static void quadratic(int a, int b, int c){
        double first;
        double second;
        double discriminant = Math.pow(b,2) - (4 * a * c);
        first = ((b * -1) + Math.sqrt(discriminant)) / (2 * a);
        System.out.println("First root = " + first);
        second = ((b * -1) - Math.sqrt(discriminant)) / (2 * a);
        System.out.println("Second root = " + second);
    }
}