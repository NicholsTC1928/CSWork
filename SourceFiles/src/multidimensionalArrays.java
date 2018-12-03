public class multidimensionalArrays {
    public static void main(String[] args){
        String[][] myArray = new String[3][4]; ///This creates a String array with 3 rows and 4 columns.
        String temp; //This will be used to build the string.
        //This for loop will write to the array.
        for(int row = 0;row < 3;row++){ //Notice that when writing to the array, the row for loop comes first.
            for(int col = 0;col < 4;col++){
                temp = "Row: " + row + " / Column: " + col;
                myArray[row][col] = temp;
            }
        }
        //This for loop will print out the different elements of the array.
        for(int row = 0;row < 3;row++){
            for(int col = 0;col < 4;col++){
                System.out.print(myArray[row][col] + " | ");
            }
            System.out.println();
        }

        //We will now work with jagged arrays.
        int[][] jagged = new int[3][];
        jagged[0] = new int[2]; //This gives row 0 two columns.
        jagged[1] = new int[4]; //This gives row 1 four columns.
        jagged[2] = new int[3]; //This gives row 2 three columns.
        for(int[] col: jagged){ //This is a for-each loop for the row of a multidimensional array.
            for(int val: col){
                System.out.print(val + " | ");
            }
            System.out.println();
        }
    }
}
