package designPatterns.observer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Weekday {
    private String day = LocalDate.now().getDayOfWeek().toString();
    List<StringObserver> observerList = new ArrayList<>();

    public void attach(StringObserver observer) {
        this.observerList.add(observer);
        observer.update(day);
    }

    public void setDay(String day) {
        this.day = day;
        System.out.println(day + ": ");
        for (StringObserver observer : observerList) {
            observer.update(day);
        }
    }

    @Override
    public String toString() {
        return day;
    }
}
