package QuizProgram;

import java.util.*;

public class Quiz {
    public static void main(String[] args){
        System.out.println("This program will quiz you on questions related to the upcoming test.");
        System.out.println();
        int choice = -1;
        boolean choiceMade = false;
        while(!choiceMade){
            System.out.println("Choose the set of standards that you wish to review:");
            System.out.println();
            System.out.println("1. Standards 1-3");
            System.out.println("2. Standards 4-6");
            System.out.println("3. Standards 8 and 9");
            System.out.println("4. Standards 12, 16, 18, and 19");
            System.out.println();
            try{
                Scanner input = new Scanner(System.in);
                System.out.print("Enter your desired choice here: ");
                choice = input.nextInt();
                if(choice < 1 || choice > 4) throw new InputMismatchException();
                System.out.println();
                choiceMade = true;
                //input.close();
            }
            catch(InputMismatchException e){
                System.out.println();
                System.out.println("ERROR: This choice is invalid.");
                System.out.println();
            }
        }
        List<Question> quizList;
        switch(choice){
            case 1:
                //Standards 1-3
                quizList = quiz1();
                break;
            case 2:
                //Standards 4-6
                quizList = quiz2();
                break;
            case 3:
                //Standards 8 and 9
                quizList = quiz3();
                break;
            case 4:
                //Standards 12, 16, 18, and 19
                quizList = quiz4();
                break;
            default:
                System.out.println("There was an unknown error that occurred. Starting the 1st quiz...");
                System.out.println();
                quizList = quiz1();
                break;
        }
        takeQuiz(quizList);
    }

    public static void takeQuiz(List<Question> qList){
        int currentScore = 0;
        int possibleScore = qList.size();
        int currentQuestion = 1;
        Collections.shuffle(qList);
        while(currentQuestion <= qList.size()){
            System.out.println(currentQuestion + ". " + qList.get(currentQuestion - 1).getQuestion());
            String[] ans = qList.get(currentQuestion - 1).getAnswers();
            System.out.println("A. " + ans[0]);
            System.out.println("B. " + ans[1]);
            System.out.println("C. " + ans[2]);
            System.out.println("D. " + ans[3]);
            System.out.println();
            System.out.print("Enter your desired choice here: ");
            Scanner input = new Scanner(System.in);
            String choice = input.next().toUpperCase();
            if(!choice.equals("A") && !choice.equals("B") && !choice.equals("C") && !choice.equals("D")){
                System.out.println();
                System.out.println("ERROR: This value is invalid.");
                System.out.println();
            }
            else{
                boolean correct = false;
                switch(choice){
                    case "A":
                        correct = qList.get(currentQuestion - 1).isChosenAnswerCorrect(ans[0]);
                        break;
                    case "B":
                        correct = qList.get(currentQuestion - 1).isChosenAnswerCorrect(ans[1]);
                        break;
                    case "C":
                        correct = qList.get(currentQuestion - 1).isChosenAnswerCorrect(ans[2]);
                        break;
                    case "D":
                        correct = qList.get(currentQuestion - 1).isChosenAnswerCorrect(ans[3]);
                        break;
                    default:
                        break;
                }
                if(correct){
                    currentScore++;
                    System.out.println();
                    System.out.println("This answer is correct! Your current score is " + currentScore + ".");
                    System.out.println();
                }
                else{
                    System.out.println();
                    System.out.println("This answer is wrong! Your score is still " + currentScore + ".");
                    System.out.println("(The correct answer is " + qList.get(currentQuestion - 1).getCorrectAnswer() + ".)");
                    System.out.println();
                }
                currentQuestion++;
            }
        }
        System.out.println("The quiz has concluded. Your final score is " + currentScore + " / " + possibleScore + ".");
        System.out.println();
    }

    public static String[] createQArray(String q,String c,String d1,String d2,String d3){
        return new String[]{q,c,d1,d2,d3};
    }

    public static List<Question> quiz1(){
        //Standards 1-3
        List<Question> quiz = new ArrayList<Question>();
        quiz.add(new Question(createQArray(
                "Which type of person would an organization hire to discover security flaws in their network system?",
                "White-collar hacker",
                "Network specialist",
                "Software tester",
                "Cloud consultent"
        )));
        quiz.add(new Question(createQArray(
                "Which type of computer virus disguises itself to be a different, unharmful program?",
                "Trojan",
                "Worm",
                "Spyware",
                "Macro"
        )));
        quiz.add(new Question(createQArray(
                "Which component of the CIA protection concept ensures that only approved individuals can access special content of an organization?",
                "Confidentiality",
                "Integrity",
                "Accounting",
                "Availability"
        )));
        quiz.add(new Question(createQArray(
                "Which is the federal law that created security standards that all companies that process, store, or transmit credit card information must follow?",
                "PCI",
                "GDPR",
                "COPPA",
                "HIPAA"
        )));
        quiz.add(new Question(createQArray(
                "Which of the following malwares is a program that uses a computer network to replicate itself and take advantage of a vulnerability in an application or the operating system on the host computer?",
                "Worm",
                "Trojan",
                "Virus",
                "Spam"
        )));
        quiz.add(new Question(createQArray(
                "Which of the following is a type of malicious code that infects a program file and reproduces itself on the same computer but does not automatically spread to another computer?",
                "Virus",
                "Worm",
                "Trojan",
                "Spam"
        )));
        quiz.add(new Question(createQArray(
                "Which of the following malware is an executable program that perform an intended activity while containing a malicious payload in the background but can only be transferred to other computer by the user?",
                "Trojan",
                "Worm",
                "Virus",
                "Spam"
        )));
        quiz.add(new Question(createQArray(
                "Which term is described as the use of a physical token, such as an RFID fitted ID badge, to increase cyber security and identify those who have access to an authorized area?",
                "Proximity readers",
                "Protected distribution system",
                "Hardware security",
                "Encryption"
        )));
        quiz.add(new Question(createQArray(
                "Which of the following items does copyright apply to?",
                "An original creative work in a permanent format",
                "An original invention developed for use by others",
                "An original process detailed in steps and parameters",
                "An adapted product for use with permission"
        )));
        quiz.add(new Question(createQArray(
                "Which of the following best describes the purpose of the Creative Commons?",
                "It allows the owner to maintain ownership while allowing others to share, use or alter the original material for free",
                "It allows the owner to maintain ownership and give permission for others to share, use or alter their original material for a small fee",
                "It allows the owner to determine who can share, use or alter their original material based on a set criteria",
                "It allows the user to share, use or alter the original material only after written permission from the owner"
        )));
        quiz.add(new Question(createQArray(
                "Which of the following is a simplified program language used for planning and development prior to writing code?",
                "Pseudocode",
                "Algorithm",
                "Flowchart",
                "Wireframe"
        )));
        quiz.add(new Question(createQArray(
                "Which of the following best explains ownership and use of digital download copies?",
                "The copy can be used, according to the license agreement, but the originator retains ownership so the license can not be copied, transferred or sold",
                "The copy can be used, according to the license agreement, sold or copied as long as original receipt and use agreement is also transferred",
                "The copy can be used, according to the license agreement and the user can make up to 4 additional copies for their own use only",
                "The copy can be used according to the license agreement with ownership being transferred only with permission to a second license holder"
        )));
        quiz.add(new Question(createQArray(
                "Which of the following allows for a portion of a copyrighted material to be used in special situations such as educational purposes?",
                "Fair Use Act",
                "Digital Millennium Copyright Act",
                "Fair Recording Standards Act",
                "Digital Licensing Act"
        )));
        quiz.add(new Question(createQArray(
                "Which of the following best describes the criteria required for a creative work to be copyrighted?",
                "It must be an original work",
                "It must be an independent idea",
                "It must be professional in quality",
                "It must be something others would use"
        )));
        quiz.add(new Question(createQArray(
                "Which of the following is NOT a factor when determining whether or not the use of a copyrighted work falls under the protection Fair Use?",
                "The format and distribution method of the original item",
                "The intended purpose or use of the original item",
                "The effect on the market value of the original item",
                "The amount or percentage of the original item used"
        )));
        quiz.add(new Question(createQArray(
                "What is the length of copyright for an original work that is posted or used on the Internet?",
                "It is the same as if it were printed in a book or anywhere else",
                "A time limit does not exist because anything on the Internet is public domain",
                "It depends upon whether or not the originator has filed for copyright protection",
                "It is only 14 years since it is a public forum"
        )));
        quiz.add(new Question(createQArray(
                "Which best defines royalty fees?",
                "An ongoing fee paid for the use of a licensed asset each time the asset is used, normally a percentage of the sales",
                "A one time fee paid for the use of a licensed asset for the duration of use whether it is profit or nonprofit",
                "A fee based on the income earned because of the use of the licensed asset",
                "An ongoing fee that changes based on the value of the licenses asset at the time it is being used"
        )));
        return quiz;
    }
/*
    public static List<Question> quiz2(){
        //Standards 4-6
        List<Question> quiz = new ArrayList<Question>();
    }

    public static List<Question> quiz3(){
        //Standards 8 and 9
        List<Question> quiz = new ArrayList<Question>();
    }

    public static List<Question> quiz4(){
        //Standards 12, 16, 18, and 19
        List<Question> quiz = new ArrayList<Question>();
    }

 */
}
