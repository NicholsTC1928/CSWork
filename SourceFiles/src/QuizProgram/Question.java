package QuizProgram;

import java.util.*;

public class Question {
    private String question;
    private String c; //Correct Answer
    private String d1; //Wrong Answer (Distractor) 1
    private String d2; //Wrong Answer (Distractor) 2
    private String d3; //Wrong Answer (Distractor) 3
    private String[] answers;

    public Question(String[] q){
        this.question = q[0];
        this.c = q[1];
        this.d1 = q[2];
        this.d2 = q[3];
        this.d3 = q[4];
        this.answers = new String[]{c,d1,d2,d3};
    }

    public String getQuestion(){
        return this.question;
    }

    public String[] getAnswers(){
        //String[] answers = new String[4];
        Random r = new Random();
        for(int i = 3;i > 0;i--){
            int index = r.nextInt(i + 1);
            String a = this.answers[index];
            this.answers[index] = this.answers[i];
            this.answers[i] = a;
        }
        return this.answers;
    }

    public boolean isChosenAnswerCorrect(String a){
        return (a.equals(c));
    }
}
