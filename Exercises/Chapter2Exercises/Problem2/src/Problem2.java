//Tyler Nichols - 8/24/18 - Problem 2

public class Problem2
{
    public static void main(String[] args){
        int valueAdd = 3;
        int valueOriginal = 1;
        int newValue = valueAdd + valueOriginal;
        for(int i = 1;i <= 10;i += 1){
            if(i == 1){
                System.out.print(valueOriginal + " ");
            }
            else{
                System.out.print(newValue + " ");
                valueAdd = valueAdd + 2;
                newValue = newValue + valueAdd;
            }
        }
    }
}
