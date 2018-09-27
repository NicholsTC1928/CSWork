public class Problem7{
    public static void main(String[] args){
        System.out.println(largestAbsVal(7,-2,-11));
        System.out.println(largestAbsVal(-4,5,2));
    }

    public static int largestAbsVal(int a,int b,int c){
        if(a < 0) a *= -1;
        if(b < 0) b *= -1;
        if(c < 0) c *= -1;
        int[] checkValues = new int[]{a,b,c};
        int value = 0;
        for(int i = 0;i <= 2; i++){
            if(checkValues[i] > value) value = checkValues[i];
        }
        return value;

    }
}