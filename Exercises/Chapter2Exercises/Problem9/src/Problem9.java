//Tyler Nichols - 8/27/2018 - Problem 9

public class Problem9
{
    public static void main(String[] args){
        for(int lines = 1; lines <= 4; lines++){
            if(lines == 1){
                for(int i = 1; i <= 40; i++){
                    System.out.print("-");
                }
                System.out.println(" ");
            }
            else if(lines == 2){
                for(int n = 1; n <= 10; n++){
                    System.out.print("_-^-");
                }
                System.out.println(" ");
            }
            else if(lines == 3){
                int num = 1;
                for(int j = 1;j <= 20; j++){
                    if(num % 10 == 0){
                        System.out.print("00");
                        num = 1;
                    }
                    else{
                        System.out.print(num + "" + num);
                        num++;
                    }
                }
                System.out.println(" ");
            }
            else{
                for(int k = 1; k <= 40; k++){
                    System.out.print("-");
                }
                System.out.println(" ");
            }
        }
    }
}
