package pointExample;

//This class will represent hours and minutes.
//Class Invariant: hours >= 0 / minutes >= 0 / minutes < 60
public class TimeSpan {
    private int hours;
    private int minutes;

    public TimeSpan(int hours,int minutes){
        if(hours >= 0) this.hours = hours;
        else throw new IllegalArgumentException();
        if(minutes >= 0 && minutes < 60) this.minutes = minutes;
        else throw new IllegalArgumentException();
    }
}
