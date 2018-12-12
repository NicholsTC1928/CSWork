// The ArrayList class in Java provides a more flexible way to store data
// Arrays are limited because they cannot change size once created.
// ArrayList object can add or remove elements

import java.util.ArrayList;  // import for the ArrayList class
public class arrayLists{
    public static void main (String[] args){
        //The first thing that should be done is to create the array list.
        ArrayList<String> listNames = new ArrayList<String>(); //This creates an array list of String values.
        //NOTE: Array lists do not support primitive data types (int, double, boolean, etc.).
        listNames.add("A");
        listNames.add("B");
        listNames.add("C");
        System.out.println(listNames);
        listNames.add(0,"Z"); //The add() method also allows you to add a specified element at a given index.
        System.out.println(listNames);
        listNames.remove(0); //This will remove the element located at index 0. Since element 0 is Z, you can also type
        //listNames.remove("Z"), which will remove ONLY the first occurrence of the specified element.
        //It should be noted that going out of bounds for an array list will return an IndexOutOfBoundsException error.
        System.out.println(listNames);

        //As can be seen, array lists can be easily printed, added to, or modified.

        ArrayList<Integer> listNums = new ArrayList<Integer>();
        listNums.add(5);
        //In order to support primitive data types, the compiler changes the primitive int type into the Integer type.
        //This is known as boxing, and changing it back to the primitive int type is known as unboxing.

        //There is a problem with using wrappers and boxing/unboxing, as can be seen below.
        int a = 500;
        ArrayList<Integer> listNums2 = new ArrayList<Integer>();
        listNums2.add(a);
        listNums2.add(a);
        if(listNums2.get(0) == listNums2.get(1)) System.out.println("The values are equal.");
        else System.out.println("The values are NOT equal.");
        //This problem will be fixed "soon."

        /*
        Here is a list of methods for an array list:
        - clear() - removes all elements from the array list
        - get(index) - uses the element at index 0 as data (This can be useful for comparing values with the equals() method.)
        - set(index, value) - changes the element at the specified index to the specified value
        - size() - returns the number of elements in an array list
        - indexOf(object) - returns the index number of ONLY the first instance of the specified element
        - lastIndexOf(object) - returns the index number of ONLY the last instance of the specified element
         */

    }
}

