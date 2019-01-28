package PolymorphismExample;

public class Main {
    public static void main(String[] args){
        Employee edna = new Employee();
        Lawyer lucy = new Lawyer();
        Secretary stan = new Secretary();
        LegalSecretary leo = new LegalSecretary();

        printInfo(edna);
        printInfo(lucy);
        printInfo(stan);
        printInfo(leo);
    }

    public static void printInfo(Employee e){
        System.out.print(e.getHours() + ", ");
        System.out.printf("$%.2f, ", e.getSalary()); //The %.2f represents two decimal places.
        System.out.print(e.getVacationDays() + ", ");
        System.out.print(e.getVacationForm() + ", ");
        System.out.println(e); //This is the toString() representation of Employee.
    }
}
