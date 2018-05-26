package designPatterns.observer;/*
Created by Karo on 16-May-18.
*/

public class TiredTeacher implements StringObserver{

    public void update(String day) {
        if (day.equals("FRIDAY")) {
            System.out.println("Happy teacher");
            return;
        }
        System.out.println("Tired teacher");
    }
}
