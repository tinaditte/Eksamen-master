package efficiency;

import java.util.stream.IntStream;

public class Searcher {

    public static void main(String[] args) {

        int[] counter = { 0 };
        int[] array = IntStream.generate(() -> counter[0]++).limit(1000).toArray();

        linearSearch(711, array);
        System.out.println();
        binarySearch(711, array);
    }

    public static int linearSearch(int needle, int[] haystack) {
        int iterations = 0;

        for (int i = 0; i < haystack.length; i++) {
            System.out.print(i + " ");
            iterations++;
            if (needle == haystack[i]) {
                System.out.println("\n" + iterations + " iterationer");
                System.out.println(needle + " is found on index " + i);
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int needle, int[] haystack) {
        int start = 0;
        int end = haystack.length - 1;
        int iterations = 0;

        while (start <= end) {
            int i = start + (end - start) / 2;
            System.out.print(i + " ");
            iterations++;
            if (needle == haystack[i]) {
                System.out.println("\n" + iterations + " iterationer");
                System.out.println(needle + " is found on index " + i);
                return i;
            } else if (needle < haystack[i]) {
                end = i - 1;
            } else {
                start = i + 1;
            }
        }
        return -1;
    }
}