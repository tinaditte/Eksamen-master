package JavaStreams.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {

    public static void main(String[] args) {
        List<Integer> listOfIntegers = new ArrayList<>();
        listOfIntegers.add(1);
        listOfIntegers.add(2);
        listOfIntegers.add(3);
        listOfIntegers.add(4);
        listOfIntegers.add(5);
        System.out.println(average(listOfIntegers));

        List<String> toUpperCaseStrings = new ArrayList<>();
        toUpperCaseStrings.add("Make");
        toUpperCaseStrings.add("This");
        toUpperCaseStrings.add("Uppercase");
        System.out.println(upperCase(toUpperCaseStrings));

        List<String> stringWAs = new ArrayList<>();
        stringWAs.add("hej");
        stringWAs.add("ale");
        stringWAs.add("alm");
        stringWAs.add("alle");
        stringWAs.add("Ask");
        System.out.println(search(stringWAs));
    }

    //Method returns average of a list of Integers.
    public static double average(List<Integer> list){
        return list.stream()
                .reduce(0, (a, b) -> a + b)
                / (double)list.size();
    }

    //Method that converts strings to uppercase
    public static List<String> upperCase(List<String> list){
        return list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    //Method that with a given list, returns a list of string starting with a + have 3 letters
    public static List<String> search(List<String> list){
        return list.stream()
                .filter(s -> s.length() == 3 && s.startsWith("a"))
                .collect(Collectors.toList());
    }
}
