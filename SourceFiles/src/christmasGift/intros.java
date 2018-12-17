package christmasGift;

public class intros {
    String[] allIntros = new String[3];
    public String chooseIntro(int pChoice){
        //Mom
        allIntros[0] = "I am so appreciative of all that you have done for me, and I could not have wished for a better life growing up. It is so hard to think that this will be the last Christmas that I will be living with you, but I always knew that this day would come eventually. The life that you have given me makes this fact even more painful to think about, but I am still so grateful for everything.";
        //Dad
        allIntros[1] = "The lessons that you have taught me will always be valued, and I will never forget the things that you have done for me. I know that there have been mistakes that I should not have made, but that is just a part of growing up. Thank you for your eternal patience, and for being the best father that any son could ask for. I hope you enjoy this gift as much as I enjoyed making it!";
        //Lauren
        allIntros[2] = "Listen, gangsta: we've been through a lot together. I know that not everything I do meets your standards, \"dawg,\" but I'm glad that you still want to be my friend. If I can give you my old computer, then I hope it serves you well, \"G.;\" if not, then at least I tried. You know where it's at, girl! [P.S.: Feel the Wrath - 1/1/19]";
        return allIntros[pChoice - 1];
    }
}
