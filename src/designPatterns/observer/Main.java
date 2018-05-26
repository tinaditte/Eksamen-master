package designPatterns.observer;/*
Created by Karo on 16-May-18.
*/

public class Main {
    public static void main(String[] args) {
        Weekday weekday = new Weekday();
        System.out.println(weekday);

        PartyPerson partyPerson = new PartyPerson();
        weekday.attach(partyPerson);

        TiredTeacher tiredTeacher = new TiredTeacher();
        weekday.attach(tiredTeacher);

        weekday.setDay("FRIDAY");

        weekday.setDay("MONDAY");
    }
}
