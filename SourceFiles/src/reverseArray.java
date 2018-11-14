import java.util.*;

public class reverseArray {
    public static void main(String[] args){
        int[] array1 = {1,2,3,4,5};
        System.out.println("Original Array: " + Arrays.toString(array1));
        for(int i = 0;i < (array1.length / 2);i++){
            int temp = array1[i];
            array1[i] = array1[array1.length - i - 1];
            array1[array1.length - 1 - i] = temp;
        }
        System.out.println("Reversed Array: " + Arrays.toString(array1));
    }
}
