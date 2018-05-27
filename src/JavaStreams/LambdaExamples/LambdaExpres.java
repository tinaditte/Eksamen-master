package JavaStreams.LambdaExamples;

import com.sun.org.apache.xpath.internal.operations.UnaryOperation;

import java.util.function.*;

public class LambdaExpres {

    public static void main(String[] args) {

        //test method of predicate
        Predicate<String> stringPredicate = (s) -> s.length() < 10;
        System.out.println(stringPredicate.test("Apples") + " - 'Apples' is less than 10");

        //Consumer example uses accept method
        Consumer<String> stringConsumer = (s) -> System.out.println(s.toLowerCase());
        stringConsumer.accept("tHIS sHOULD bE lOWERCASE");

        //Function example
        Function<Integer, String> converter = (num) -> Integer.toString(num);
        System.out.println("Lenght of 26: " + converter.apply(26).length());

        //Supllier example
        Supplier<String> supplier = () -> "Supply me";
        System.out.println(supplier.get());

        //Binary operator example
        BinaryOperator<Integer> add = (a, b) -> a + b;
        System.out.println("Add 10 + 25: " + add.apply(10, 25));

        //Unary Operator example
        UnaryOperator<String> str = (msg) -> msg.toUpperCase();
        System.out.println(str.apply("All big letters"));

        //Lambda reference metode
        IntFunction<String> intFunction = Integer::toString;
        System.out.println("Expected value 3, actual value: " + intFunction.apply(123).length());

        //Îstedet for
        IntFunction<String> stringIntFunction = num -> Integer.toString(num);
        System.out.println("Expected value 3, actual value: " + stringIntFunction.apply(123).length());
    }
}
