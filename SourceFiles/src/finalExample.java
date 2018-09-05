public class finalExample
{
    public static final int NUM_PLAYERS = 2; //Final (constant) values are typically expressed in all capitals.

    public static void startGame(){
        int numTurns = NUM_PLAYERS;
        for(;numTurns <= 100;numTurns++){
            System.out.println("Hello");
        }
    }
}
