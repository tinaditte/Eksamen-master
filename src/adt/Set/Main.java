package adt.Set;

import java.time.DayOfWeek;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Student Emma = new Student(new HashSet<>());
        Student Karo = new Student(new TreeSet<>());
        Student Tina = new Student(EnumSet.allOf(DayOfWeek.class));

        System.out.println("Emma: " + Emma);
        System.out.println("Karo: " + Karo);
        System.out.println("Tina: " + Tina);

        Emma.alsoStudy(DayOfWeek.MONDAY);
        Emma.alsoStudy(DayOfWeek.THURSDAY);
        Karo.alsoStudy(DayOfWeek.MONDAY);
        Karo.alsoStudy(DayOfWeek.MONDAY);
        Karo.alsoStudy(DayOfWeek.MONDAY);
        Tina.alsoStudy(DayOfWeek.MONDAY);


        System.out.println("Emma: " + Emma);
        System.out.println("Karo: " + Karo);
        System.out.println("Tina: " + Tina);
    }
}
