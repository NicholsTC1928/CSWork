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

    public static List<Question> quiz2(){
        //Standards 4-6
        List<Question> quiz = new ArrayList<Question>();
        quiz.add(new Question(createQArray(
            "In Java, which of the following is NOT a primitive data type?",
            "String",
            "integer",
            "float",
            "double"
        )));
        quiz.add(new Question(createQArray(
            "In Java, if data is NOT a primitive type, then what type of data must it be?",
            "object",
            "function",
            "method",
            "conditional"
        )));
        quiz.add(new Question(createQArray(
            "If you are writing a program to determine if a number is even, which of the following data types would allow a true response to be reported when the number is even?",
            "boolean",
            "numeric",
            "String",
            "integer"
        )));
        quiz.add(new Question(createQArray(
            "If you are writing a program that will need to determine the number of characters in an input response, which of the following data types should be used to store the input?",
            "String",
            "integer",
            "float",
            "boolean"
        )));
        quiz.add(new Question(createQArray(
            "If you are writing a program to store the quotient and remainder as separate whole numbers, which of the following data types should be used when declaring the variables?",
            "integer",
            "float",
            "double",
            "String"
        )));
        quiz.add(new Question(createQArray(
            "What is wrong with the statement \"int a = 5.5;?\"",
            "The value being assigned is a real number, while the data type is declared as an integer.",
            "The value being assigned is an integer and the data type is an int.",
            "The variable is not a valid variable name.",
            "The variable cannot assign its data type and a value at the same time."
        )));
        quiz.add(new Question(createQArray(
            "Which of the following shows the correct syntax when writing an assignment statement?",
            "variableName = assignment;",
            "expression = variableName;",
            "dataType = variableName;",
            "dataType = expression;"
        )));
        quiz.add(new Question(createQArray(
            "Which of the following cannot be used as a variable because it is a reserved word?",
            "boolean",
            "apple",
            "2b",
            "b2"
        )));
        quiz.add(new Question(createQArray(
            "Which of the following correctly uses length on the String object (str) and stores the result correctly?",
            "int len = str.length();",
            "float len = str.length();",
            "double len = str.size();",
            "int len = str.length"
        )));
        quiz.add(new Question(createQArray(
            "Which of the following correctly constructs a String variable (str) to store the String \"Hello World!?\"",
            "String str = \"Hello World!\";",
            "\"Hello World!\" = String str;",
            "String(\"Hello World!\")",
            "String str(\"Hello World!\");"
        )));
        quiz.add(new Question(createQArray(
            "How many choices are possible when writing an if/else structure in your program?",
            "two",
            "one",
            "three",
            "four"
        )));
        quiz.add(new Question(createQArray(
            "Which of the following operators would correctly determine that num1 is less than num2?",
            "<",
            ">",
            "<>",
            "="
        )));
        quiz.add(new Question(createQArray(
            "Which of the following operators would correctly determine if a number is less than or equal to a second number?",
            "<=",
            ">=",
            "<>",
            "="
        )));
        quiz.add(new Question(createQArray(
            "Given a list of numbers that are ordered, which of the following operators could determine if the list is descending?",
            ">=",
            "<",
            "<=",
            "!="
        )));
        quiz.add(new Question(createQArray(
            "What is the output of the following code fragment?\n int value = 6;\n if(value != 26) System.out.println(\"You missed!\");\n else System.out.println(\"You hit!\");\n System.out.println(\"Try again!\");",
            "You missed! Try again!",
            "You hit! Try again!",
            "You missed! You hit!",
            "You missed!Try again!"
        )));
        quiz.add(new Question(createQArray(
            "What is the binary value of decimal 207?",
            "11001111",
            "11111001",
            "11111111",
            "11110000"
        )));
        quiz.add(new Question(createQArray(
            "How many megabytes are in a gigabyte?",
            "1000 MB",
            "2000 MB",
            "500 MB",
            "200 MB"
        )));
        quiz.add(new Question(createQArray(
            "What is the purpose of order of operation in software programming?",
            "To determine which mathematical operation to perform first",
            "To determine which mathematical operations are valid",
            "To determine how many mathematical operations are required",
            "To determine which mathematical operations are NOT valid"
        )));
        quiz.add(new Question(createQArray(
            "How does the ++ symbol in programming change a variable?",
            "Add 1 to the value of itself",
            "Subtract 1 from the value of itself",
            "Multiply by 2 to the value of itself",
            "Divide by 2 to the value of itself"
        )));
        quiz.add(new Question(createQArray(
            "How does the -- symbol in programming change a variable?",
            "Subtract 1 from the value of itself",
            "Add 1 to the value of itself",
            "Multiply by 2 to the value of itself",
            "Divide by 2 to the value of itself"
        )));
        quiz.add(new Question(createQArray(
            "How would you show the value of a added to the value of b?",
            "a + b",
            "a - b",
            "a * b",
            "a / b"
        )));
        quiz.add(new Question(createQArray(
            "How would you show the value of a subtracted by the value of b?",
            "a - b",
            "a + b",
            "a / b",
            "a * b"
        )));
        quiz.add(new Question(createQArray(
            "How would you show the value of a divided by the value of b?",
            "a / b",
            "a * b",
            "a - b",
            "a + b"
        )));
        quiz.add(new Question(createQArray(
            "How would you show the value of a multiplied by the value of b?",
            "a * b",
            "a / b",
            "a + b",
            "a - b"
        )));
        quiz.add(new Question(createQArray(
            "Which of the following is a valid integer?",
            "-25",
            "0.25",
            "0.5",
            "0.75"
        )));
        quiz.add(new Question(createQArray(
            "Which of the following is a valid integer?",
            "5",
            "0.25",
            "0.1",
            "0.57"
        )));
        quiz.add(new Question(createQArray(
            "What comes first in the if/else statement?",
            "if",
            "else",
            "not",
            "then"
        )));
        quiz.add(new Question(createQArray(
            "What does the == symbol in programming mean?",
            "Equals (Comparison)",
            "Subtraction",
            "Assignment",
            "Multiplication"
        )));
        quiz.add(new Question(createQArray(
            "What does the = symbol in programming mean?",
            "Assignment",
            "Subtraction",
            "Addition",
            "Equals (Comparison)"
        )));
        quiz.add(new Question(createQArray(
            "What does the && symbol in programming mean?",
            "And",
            "Not",
            "Or",
            "Equals"
        )));
    }

    public static List<Question> quiz3(){
        //Standards 8 and 9
        List<Question> quiz = new ArrayList<Question>();
        quiz.add(new Question(createQArray(
            "How do you declare a variable to store 10 different integer values in VB?",
            "Dim numbers[9] as Integer",
            "Dim numbers[10] as Integer",
            "Dim numbers as IntegerArray",
            "Dim numbers[1 to 10] as Integer"
        )));
        quiz.add(new Question(createQArray(
            "How do you declare a variable to store 10 different integer values in Java?",
            "int[] numbers = new int[10];",
            "int[10] numbers;",
            "int numbers[10];",
            "int[10] numbers[10];"
        )));
        quiz.add(new Question(createQArray(
            "What operation is used to put a set of values in an array in order?",
            "Sort",
            "List",
            "Order",
            "Organize"
        )));
        quiz.add(new Question(createQArray(
            "Which of the following is NOT a sorting algorithm?",
            "FIFO",
            "Bubble",
            "Insertion",
            "Merge"
        )));
        quiz.add(new Question(createQArray(
            "What is the most efficient sorting algorithm?",
            "Merge",
            "Bubble",
            "Insertion",
            "FIFO"
        )));
        quiz.add(new Question(createQArray(
            "Which sorting algorithm is most efficient based on O?",
            "O(log(n))",
            "O(n)",
            "O(n^2)",
            "O(2n)"
        )));
        quiz.add(new Question(createQArray(
            "What is a common syntax error?",
            "error: ';' expected",
            "divide by zero error",
            "unhandled exception",
            "off by one error"
        )));
        quiz.add(new Question(createQArray(
            "What is the difference between http and https?",
            "https encrypts the data sent between the browser and server",
            "https provides spell-checking capability",
            "https allows for a larger packet size",
            "There is no difference between the two"
        )));
        quiz.add(new Question(createQArray(
            "Which of these is an advantage of IPv6 over IPv4?",
            "IPv6 allows for a larger number of IP addresses",
            "IPv6 is faster than IPv4",
            "IPv6 checks to make sure the IP address is properly formatted",
            "IPv6 uses 6-bit addresses, while IPv4 uses 4-bit addresses"
        )));
        quiz.add(new Question(createQArray(
            "Which of the following protocols would be used to send e-mail?",
            "IMAP",
            "FTP",
            "HTTP",
            "HTTPM"
        )));
        quiz.add(new Question(createQArray(
            "Which of these represents the amount of time it takes for a packet to reach a destination?",
            "Latency",
            "Bandwidth",
            "Packet size",
            "Baud rate"
        )));
        quiz.add(new Question(createQArray(
            "Which of these represents the amount of dtat transferred during a set period of time?",
            "Bandwidth",
            "Latency",
            "Packet size",
            "TTL"
        )));
        quiz.add(new Question(createQArray(
            "What is the purpose of DNS?",
            "To associate an IP address with a hostname",
            "Provide encryption services",
            "Route packets over large distances",
            "Provide language translation between countries"
        )));
        quiz.add(new Question(createQArray(
            "Which of these protocols works along with TCP to provide internet connectivity?",
            "Internet Protocol (IP)",
            "HTTP",
            "FTP",
            "IMAP"
        )));
        quiz.add(new Question(createQArray(
            "Which of these features is not guaranteed by the TCP/IP protocols?",
            "No packet will be dropped",
            "Error checking",
            "All packets will be delivered in the same order as they were sent",
            "The delivery of all packets"
        )));
    }

    public static List<Question> quiz4(){
        //Standards 12, 16, 18, and 19
        List<Question> quiz = new ArrayList<Question>();
    }
}
