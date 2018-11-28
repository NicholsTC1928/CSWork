package argumentSimulator;

public class branches {
    public static void main(String[] args){
        int cDecision = 1;
        String initial = "";
        String[] choices = new String[3];
        boolean gameGo = true;
        while(gameGo){
            switch(cDecision){
                case 1:
                    initial = "What do you want?";
                    choices[0] = "To hang out...";
                    choices[1] = "May I please turn off your fan?";
                    choices[2] = "I just wanted to talk.";
                    break;
                default:
                    break;
            }
            cDecision = game.displayChoices(initial,choices);
            if(cDecision == 4){
                game.exitGameChoice();
                gameGo = false;
            }
            else{
                System.out.println("[Debug] End Program");
                gameGo = false;
            }
        }

    }
}
