public class Problem2{
    public static void main(String[] args){
        System.out.println(repl("hello",3));
    }
    public static String repl(String input,int n){
        String display = input;
        if(n > 0){
            for(int i = 1; i <= (n - 1); i++){
                display = display + input;
            }
            return display;
        }
        else return "";
    }
}