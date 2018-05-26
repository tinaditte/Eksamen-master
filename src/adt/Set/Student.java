package adt.Set;

import java.time.DayOfWeek;
import java.util.Set;

public class Student {
    Set<DayOfWeek> studyDays;

    public Student(Set<DayOfWeek> set){
        studyDays = set;
    }

    public void alsoStudy(DayOfWeek day){
        studyDays.add(day);
    }

    @Override
    public String toString() {
        String days = "";

        for (DayOfWeek studyDay : studyDays) {
            days += studyDay + ", ";
        }
        return days;
    }
}
