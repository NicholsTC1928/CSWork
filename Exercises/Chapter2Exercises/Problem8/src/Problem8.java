//Tyler Nichols - 8/27/2018 - Problem 8

public class Problem8
{
    public static void main(String[] args){
        for(int i = 1; i <= 5; i++){
            for(int n = 4; n >= 0; n--){
                if(n >= i){
                    System.out.print(" ");
                }
                else{
                    System.out.print(i);
                }
            }
            System.out.println(" ");
        }
    }
}
