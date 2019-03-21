import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        int[] input = new int[]{7,91,32,54,-356,1,98,76,5};
        System.out.println("Input Array: " + Arrays.toString(input));

        mergeSort(input,0,(input.length - 1));

        System.out.println("Output Array: " + Arrays.toString(input));
    }

    public static void mergeSort(int[] arr,int start,int end){
        if(start < end){
            //Two arrays need to be created each time in order to complete the sorting.
            int middle = ((start + end) / 2);
            mergeSort(arr,start,middle);
            mergeSort(arr,(middle + 1),(arr.length - 1));

            merge(arr,start,middle,end);
        }
    }

    public static void merge(int[] arr,int start,int middle,int end){
        //The method will assume that the arrays are already sorted.
        //2 arrays must be created to house the values.
        int[] a1 = new int[(middle + 1) - start];
        int[] a2 = new int[end - middle];

        //The values now need to be stored inside of the arrays.
        for(int i = 0;i < a1.length;i++){
            a1[i] = arr[start + i];
        }
        for(int i = 0;i < a2.length;i++){
            a2[i] = arr[(i + middle + 1)];
        }

        //Next, the original array must be sorted.
        int i = start;
        int j = 0;
        int k = 0;
        while(j < a1.length && k < a2.length){
            if(a1[j] < a2[k]){
                arr[i] = a1[j];
                j++;
            }
            else{
                arr[i] = a2[k];
                k++;
            }
            i++;
        }

        //Any remaining elements must be added.
        while(j < a1.length){
            arr[i] = a1[j];
            i++;
            j++;
        }

        while(k < a2.length){
            arr[i] = a2[k];
            i++;
            k++;
        }
    }
}
