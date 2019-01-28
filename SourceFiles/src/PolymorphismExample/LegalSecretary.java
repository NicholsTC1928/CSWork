package PolymorphismExample;

//This class will represent legal secretaries.
public class LegalSecretary extends Secretary{
    //This method will override the getSalary() method from the Employee class.
    public double getSalary(){
        return super.getSalary() + 5000;
        //The "super" keyword calls the method from the superclass. In this case, it calls the method from the Employee
        //class. (It should be noted that the keyword can still be used in the overriding method, as shown above.)
    }

    //This is a method exclusive to legal secretaries.
    public void fileLegalBriefs(){
        System.out.println("I could file all day!");
    }
}
