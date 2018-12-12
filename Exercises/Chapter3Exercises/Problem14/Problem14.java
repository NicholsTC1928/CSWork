public class Problem14{
    public static void main(String[] args){
        System.out.println(cylinderSurfaceArea(3.0,4.5));
    }

    public static double cylinderSurfaceArea(double r, double h){
        double area = (2 * Math.PI * Math.pow(r,2)) + (2 * Math.PI * r * h);
        return area;
    }
}