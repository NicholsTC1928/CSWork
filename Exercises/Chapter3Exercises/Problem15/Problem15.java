public class Problem15{
    public static void main(String[] args){
        System.out.println(sphereVolume(2.0));
    }

    public static double sphereVolume(double r){
        double vol = (4.0 / 3.0) * Math.PI * Math.pow(r,3);
        return vol;
    }
}