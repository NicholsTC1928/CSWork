import java.util.Arrays;
import java.util.ArrayList;

public class searchingAlgorithmsProblem4 {
    //For reference, Problem 4 on the website is titled "Two elements whose sum is closest to zero."

    //This assignment will use the Binary Search method. (Link: www.geeksforgeeks.org/binary-search/)

    public static void main(String[] args){
        int[] input = new int[]{7,91,32,54,-356,1,98,76,5};
        //The goal is to find the two elements with a sum closest to zero. The program should print the sum of the
        //elements, and not the elements themselves.
        System.out.println("Input Array: " + Arrays.toString(input));
        //The Merge Sort algorithm will be reused from the last assignment.
        mergeSort(input,0,(input.length - 1));
        System.out.println("Sorted Array: " + Arrays.toString(input));
        System.out.println("Test: Searching Index for 32...");
        int num = binarySearch(32,input,0,(input.length - 1));
        System.out.println("Number Found: " + num + " (Element Number: " + (num + 1) + ")");
    }

    public static int sumClosestToZero(int[] arr){
        //The sum closest to zero will be the sum of the two lowest absolute values in the given array.
        //A temporary array will be created, and it will contain the absolute values of the elements in the given array.
        int[] arrAbs = new int[arr.length];
        for(int i = 0;i < arr.length;i++){
            arrAbs[i] = arr[i];
        }
        boolean needsSorting = false; //This is used to prevent redundant sorting.
        ArrayList<Integer> indexToCorrect = new ArrayList<>();
        //The ArrayList will be used to keep track of converted numbers, so that their sums may still be added correctly.
        for(int i = 0;i < arrAbs.length;i++){
            if(arrAbs[i] < 0){
                indexToCorrect.add(i);
                arrAbs[i] = Math.abs(arrAbs[i]);
                needsSorting = true;
            }
        }
        if(needsSorting) mergeSort(arrAbs,0,(arrAbs.length - 1));
        try{
            return (arr[binarySearch(arrAbs[0],arr,0,(arr.length - 1))] + arr[binarySearch(arrAbs[1],arr,0,(arr.length - 1))]);
        }
    }

    public static int binarySearch(int num,int[] arr,int start,int end){
        if((end - start) > 2){
            int middle = ((start + end) - 1);
            if(arr[middle] == num) return middle;
            else if(arr[middle] > num){
                //Go to the 1st half.
                return binarySearch(num,arr,start,(middle - 1));
            }
            else{
                //Go to the 2nd half.
                return binarySearch(num,arr,(middle + 1),end);
            }
        }
        else{
            if(arr[start] == num) return start;
            else return end;
        }
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
