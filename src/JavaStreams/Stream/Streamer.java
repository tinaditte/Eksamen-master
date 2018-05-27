package JavaStreams.Stream;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streamer {

    public static void main(String[] args) {

        Arrays.asList("Red", "Green", "Blue")
                .stream()
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);

        //Stream with filter
        Stream.of("Apple", "Pear", "Banana", "Cherry", "Apricot").filter(fruit -> {
            System.out.println("Filter: " + fruit);
            return fruit.startsWith("A");
        })
                //minus forEach = no print
                //ForEach makes it a terminal event
                .forEach(fruit -> System.out.println("Starts with A: " + fruit));

        //using a stream and map operation to create a list of word in caps
        List<String> collected = Stream.of("Java", " Rocks")
                .map(string -> string.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(collected.toString());
    }
}
