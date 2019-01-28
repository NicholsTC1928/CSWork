package PolymorphismExample;

//This class will represent secretaries.
public class Secretary extends Employee{
    public void takeDictation(String text){
        System.out.println("Dictating Text: " + text);
    }
}
