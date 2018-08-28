//Tyler Nichols - 8/27/2018 - Problem 7

public class Problem7
{
    public static void main(String[] args){
        for(int i = 1; i <= 5; i++){
            for(int n = 4; n >= i; n--){
                System.out.print(" ");
            }
            System.out.println(i);
        }
    }
}
