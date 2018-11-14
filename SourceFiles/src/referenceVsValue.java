import java.util.*;
public class referenceVsValue {
    public static void main(String[] args){
        int myInt = 4;
        passByValue(myInt);
        System.out.println("After calling passByValue: " + myInt);

        int[] myArray = {2,3,4,5};
        passByReference(myArray);
        System.out.println("After calling passByReference: " + Arrays.toString(myArray));
        int[] arr2 = myArray;
        System.out.println("arr2: " + Arrays.toString(arr2));
        passByReference(myArray);
        System.out.println("arr2 after passByReference on myArray: " + Arrays.toString(arr2));
    }

    public static void passByReference(int[] myArray){
        for(int n = 0;n < myArray.length;n++){ //Do NOT use a for-each loop when changing values in an array.
            myArray[n] *= 2;
        }
        System.out.println("Inside of the passByReference method: " + Arrays.toString(myArray));
    }

    public static void passByValue(int myInt){
        myInt *= myInt;
        System.out.println("Inside of the passByValue method: " + myInt);
    }
}
