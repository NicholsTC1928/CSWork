//Tyler Nichols - 8/27/18 - Problem 3

public class Problem3
{
    public static void main(String[] args){
        int valueAddFirst = 0;
        int valueAddSecond = 0;
        for(int i = 1; i <= 12; i++){
            if(i == 1 || i == 2){
                System.out.print("1 ");
                valueAddFirst = 1;
                valueAddSecond = 1;
            }
            else{
                int valueDisplay = valueAddFirst + valueAddSecond;
                System.out.print(valueDisplay + " ");
                valueAddSecond = valueAddFirst;
                valueAddFirst = valueDisplay;
            }
        }
    }
}
