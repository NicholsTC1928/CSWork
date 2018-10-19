/*
Assignment: Write a program that prompts for a date (month, day, year) and reports the day of the week for that date.
It might be helpful to know that January 1, 1601 was a Monday.

Important Notes:
-If the year % 4 == 0, then it is a leap year.
-The year 1604 is a leap year.
-Since January 1, 1601 was a Monday, January 1, 1602 was a Tuesday, January 1, 1603 was a Wednesday, and January 1, 1604
was a Thursday. However, since 1604 was a leap year, January 1, 1605 was Saturday, and not a Friday.
-January 1, 1600 was a Saturday.
 */
import java.util.*;
public class DayOfWeek
{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("This program will print the day of the week for any given day.");
        System.out.print("Enter the number for the month here (1-12). ");
        int month = input.nextInt();
        System.out.print("Enter the number for the day here (1-31). ");
        int day = input.nextInt();
        System.out.print("Enter the number for the year here. ");
        int year = input.nextInt();
        dayOfTheWeek(month,day,year);
    }

    public static void dayOfTheWeek(int month,int day,int year){
        boolean leapYear = false;
        if(year % 4 == 0){
            if(month >= 3)
            leapYear = true;
        }
        int leapYearsPassed;
        if(leapYear) leapYearsPassed = (Math.abs(year - 1600) / 4);
        else leapYearsPassed = ((Math.abs(year - 1600) / 4) - 1);
        System.out.println(leapYearsPassed + " leap years have passed."); //Debug
        String[] daysOf1600 = new String[]{"Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday"};
        String dayOfTheWeek = daysOf1600[((day - 1) % 7) + ((leapYearsPassed - 1) % 7)];
        System.out.println("The day of the week for this date is " + dayOfTheWeek + ".");
    }
}
