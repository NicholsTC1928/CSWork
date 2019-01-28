package PolymorphismExample;

//This class will represent lawyers.
public class Lawyer extends Employee{
    //This will override the getVacationDays() method from the Employee class.
    public int getVacationDays(){
        return 15;
    }

    //This will override the getVacationForm() method from the Employee class.
    public String getVacationForm(){
        return "Pink";
    }

    //This method is exclusive to the Lawyer class.
    public void sue(){
        System.out.println("I will see you in court!");
    }
}
