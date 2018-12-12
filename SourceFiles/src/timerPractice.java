import java.util.Timer; //This imports the Timer() class, which allows for an internal timer.
import java.util.TimerTask; //This imports the TimerTask() class, which allows for a task to be carried after the aforementioned
//timer has elapsed.

public class timerPractice {
    public static void main(String[] args){
        Timer t = new Timer();
        TimerTask task = new TimerTask(){
            //The @Override is required in order to allow the run() method to be used. This is required in order to use
            //a unique version of the run() method. Without the @Override, a method call of the same name from a different
            //class would use the method belonging to the method of the first class; this can obviously cause problems.
            //For more of an explanation on the purpose of @Override, visit https://www.geeksforgeeks.org/overriding-in-java/.
            @Override public void run(){
                System.out.println("It has been 5 seconds.");
                t.cancel(); //IMPORTANT - This ends the timer after the method is completed. It must be added into the run()
                //method at the end in order to prevent an infinite loop.
            }
        }; //Notice that the semicolon is still required, since you are still declaring a variable (task).
        //The following method call will run the task once after 5 seconds.
        t.schedule(task,(5 * 1000)); //The usage of the schedule method from the Timer() class is as follows:
        //schedule([Instance of TimerTask],[Delay (in milliseconds)])
        //Note that the delay is typed as 5 * 1000, which is 5 * 1000 milliseconds. This is equivalent to 5 seconds.
    }
}
