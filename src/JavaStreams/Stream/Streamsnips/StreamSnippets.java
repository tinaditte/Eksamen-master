package JavaStreams.Stream.Streamsnips;

import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SuppressWarnings("ALL")
public class StreamSnippets {

    public static void main(String[] args) {

        /*
        //How stream works
        List<String> myList = Arrays.asList("a1", "a2", "b1", "b2", "c2", "c1");

        myList
                .stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
        //c2, c1

        //Kind of streams
        Arrays.asList("a1", "a2", "a3")//Sequential stream
                .stream()
                .findFirst()
                .ifPresent(System.out::println);
        //a1

        //Kalde stream()
        Stream.of("a1", "a2", "a3")
                .findFirst()
                .ifPresent(System.out::println);
        //a1

        //Primitiv stream
        IntStream.range(1, 4)
                .forEach(System.out::println);
        //1, 2, 3

        Arrays.stream(new int[] {1, 2, 3})
                .map(n -> 2 * n + 1)
                .average()
                .ifPresent(System.out::println);
        //5.0

        //Transform regular objekt stream to primitive stream
        Stream.of("a1", "a2", "a3")
                .map(s -> s.substring(1))
                .mapToInt(Integer::parseInt)
                .max()
                .ifPresent(System.out::println);
        //3

        //Transform to object stream
        IntStream.range(1, 4)
                .mapToObj(i -> "a" + i)
                .forEach(System.out::println);
        //a1, a2, a3

        //from double to int to object
        Stream.of(1.0, 2.4, 3.6)
                .mapToInt(Double::intValue)
                .mapToObj(i -> "a" + i)
                .forEach(System.out::println);
        //a1, a2, a3

        //Processing order
        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return true;
                })
                .forEach(s -> System.out.println("forEach: " + s));
        //nothing W/O terminal
        //w
        //filter d2, foreach: d2, filter a2, etc.

        //reduced operations
        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("anyMatch " + s);
                    return s.startsWith("A");
                });
        //map: d2, anymatch D2, map; a2, anymatch A2

        //Why orders matter
        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map " + s);
                    return s.toUpperCase();
                })
                .filter(s -> {
                    System.out.println("filter " + s);
                    return s.startsWith("A");
                })
                .forEach(s -> System.out.println("forEach " + s));
        //11 steps
        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter " + s);
                    return s.startsWith("A");
                })
                .map(s -> {
                    System.out.println("map " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach " + s));
        //7 steps

        //Reusing streams
        Stream<String> stream = Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> s.startsWith("a"));
        stream.anyMatch(s -> true); //ok
        stream.noneMatch(s -> true); //exception

        //solution
        Supplier<Stream<String>> streamSupplier =
                () -> Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> s.startsWith("a"));
        streamSupplier.get().anyMatch(s -> true);   //ok
        streamSupplier.get().noneMatch(s -> true);  //ok
*/
        //Advanced operations
        List<Person> people = Arrays.asList(
                new Person("Emma", 30),
                new Person("Karo", 31),
                new Person("Martin", 27),
                new Person("Malene", 27),
                new Person("Susan", 25),
                new Person("Tina", 25));

        //Collect usecase
        List<Person> filtered = people
                .stream()
                .filter(p -> p.name.startsWith("M"))
                .collect(Collectors.toList());
        System.out.println(filtered); //[Martin, Malene]

        //Group by age
        Map<Integer, List<Person>> personByAge = people
                .stream()
                .collect(Collectors.groupingBy(p -> p.age));

        personByAge
                .forEach((age, p) -> System.out.format("age %s: %s\n", age, p));
        //Age 30: Emma
        //Age 31: Karo
        //Age 27: Martin, Malene
        //Age 25: Susan, Tina

        //Determining average age of alle people
        Double averageAge = people
                .stream()
                .collect(Collectors.averagingInt(p -> p.age));
        System.out.println(averageAge); //27.5

        //Summarize collectors
        IntSummaryStatistics ageSummery =
                people
                .stream()
                .collect(Collectors.summarizingInt(p -> p.age));
        System.out.println(ageSummery);
        //IntSummaryStatistics{count=6, sum=165, min=25, average=27,500000, max=31}

        //Join to a single string
        String phrase = people
                .stream()
                .filter(p -> p.age < 27)
                .map(p -> p.name)
                .collect(Collectors.joining(" and ", " Both ", " are above below age."));
        System.out.println(phrase);

        //Transform stream elements into map
        Map<Integer, String> map = people
                .stream()
                .collect(Collectors.toMap(
                        p -> p.age,
                        p -> p.name,
                        (name1, name2 ) -> name1 + ";" + name2));
        System.out.println(map);
        //{25=Susan;Tina, 27=Martin;Malene, 30=Emma, 31=Karo}

        //build own collector
        Collector<Person, StringJoiner, String> personNameCollector =
                Collector.of(
                        () -> new StringJoiner(" | "),  //supplier
                        (j, p) -> j.add(p.name.toUpperCase()),  //Accumulator
                        (j1, j2) -> j1.merge(j2),               //Combiner
                        StringJoiner::toString);                //Finisher

        String names = people
                .stream()
                .collect(personNameCollector);
        System.out.println(names); //EMMA | KARO | MARTIN | MALENE | SUSAN | TINA

        //Reduce
        //Reduce a stream of elements to exactly one element of the stream
        people
                .stream()
                .reduce((p1, p2) -> p1.age > p2.age ? p1 : p2)
                .ifPresent(System.out::println); //Karo

        //Reduce accepts both identity and binaryoperator
        Person result =
                people
                .stream()
                .reduce(new Person("", 0), (p1, p2) -> {
                    p1.age += p2.age;
                    p1.name += p2.name;
                    return p1;
                });
        System.out.format("name=%s; age=%s", result.name, result.age);
        //name=EmmaKaroMartinMaleneSusanTina; age=165

        System.out.println();

        //Sum of all people
        Integer ageSum = people
                .parallelStream()
                .reduce(0,
                        (sum, p ) -> {
                            System.out.format("Accumulator: sum=%s; person=%s\n", sum, p);
                            return sum += p.age;
                        },
                        (sum1, sum2) ->{
                            System.out.format("Combiner: sum1=%s; sum2=%s\n", sum1, sum2);
                            return sum1 + sum2;
                        });

        ForkJoinPool comminPool = ForkJoinPool.commonPool();
        System.out.println(comminPool.getParallelism()); // 7 på stat


    }

}
