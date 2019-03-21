import java.util.Arrays;

public class mergeSortAssignment {
    public static void main(String[] args){
        int[] input = new int[]{7,91,32,54,-356,1,98,76,5};
        System.out.println("Input Array: " + Arrays.toString(input));

        mergeSort(input,0,(input.length - 1));
    }

    public static void mergeSort(int[] arr,int start,int end){
        if(1 < end){
            //Two arrays need to be created each time in order to complete the sorting.
            int middle = ((start + end) / 2);
            mergeSort(arr,0,middle);
            mergeSort(arr,(middle + 1),(arr.length - 1));

            merge(arr,start,middle,end);
        }
    }

    public static void merge(int[] arr,int start,int middle,int end){
        //The length of this array will start at 2.
        //The method will assume that the arrays are already sorted.
        if(arr[start] > arr[end]){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
    }
}
