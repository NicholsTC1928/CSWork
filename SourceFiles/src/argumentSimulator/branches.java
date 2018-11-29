package argumentSimulator;

public class branches {
    String[][] branches = new String[10][4];
    public void main(String[] args){
        //Branch 0:
        branches[0][0] = "What do you want?";
        branches[0][1] = "To hang out...";
        branches[0][2] = "May I please turn off your fan?";
        branches[0][3] = "I just wanted to talk.";
        //Branch 1:
        branches[1][0] = "And do what?";
    }

    public String[][] getBranches(){
        return branches.clone();
    }
}
