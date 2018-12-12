public class whileLoops {
    //This program will introduce the while loop.
    public static void main(String[] args){
        //We will start with a for loop.
        for(int i = 0;i < 10;i++){
            System.out.println(i);
        }

        //Here is the same process with a while loop.
        int i = 0;
        while(i < 10){ //The while loop continues the code inside while the condition provided is true. You can
            System.out.println(i);
            i++;
        }

        int n = 91;
        int factor = 2;
        while((n % factor) != 0){
            factor++;
        }
        System.out.println("The answer is " + factor + ".");

        for(int j = 91;(n % factor) != 0;){ //Here is the for loop equivalent of the above while loop.
            factor++;
        }
        System.out.println("The answer is " + factor + ".");

        //As can be seen in both instances above, for loops can be much more convenient than while loops are.
    }
}
