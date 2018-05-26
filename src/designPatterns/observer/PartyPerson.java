package designPatterns.observer;/*
Created by Karo on 16-May-18.
*/

public class PartyPerson implements StringObserver {

    @Override
    public void update(String day) {
        if (day.equals("FRIDAY")) {
            System.out.println("Drunk PartyPerson");
            return;
        }
        System.out.println("Sad PartyPerson");
    }
}
