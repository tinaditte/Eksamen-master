package efficiency;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class InsertionSorter {
    public static final int n = 100;

    public static void main(String[] args) {

       //Insertion
        Random random = new Random(54);
        int[] counter = {0};
        int[] bestCase = IntStream.generate(() -> counter[0]++).limit(n).toArray();
        int [] worstCase = IntStream.generate(() -> counter[0]--).limit(n).toArray();
        int [] averageCase = IntStream.generate(() -> random.nextInt(n)).limit(n).toArray();


        System.out.println("Best case: (Sorted)");
        System.out.println(Arrays.toString(bestCase));
        insertionSort(bestCase);
        System.out.println(Arrays.toString(bestCase));

        System.out.println("");
        System.out.println("Average case: (Randomnized)");
        System.out.println(Arrays.toString(averageCase));
        insertionSort(averageCase);
        System.out.println(Arrays.toString(averageCase));

        System.out.println("");
        System.out.println("Worst case: (Reversed order)");
        System.out.println(Arrays.toString(worstCase));
        insertionSort(worstCase);
        System.out.println(Arrays.toString(worstCase));
    }

    public static void insertionSort(int[] array){
        //static fordi ellers skal vi have et object tilknyttet
        int iterations = 0;
        int sorted = 1;
        while (sorted < array.length){
            int currentIndex = sorted;
            while (currentIndex > 0){
                iterations++;
                if (array[currentIndex] < array[currentIndex - 1]){
                    swap(array, currentIndex, currentIndex - 1);
                    currentIndex = currentIndex - 1;
                }else{
                    break;
                }
            }
            sorted++;
        }
        System.out.println("Iterations: " + iterations);
    }

    private static void swap(int[] array, int indexA, int indexB){
        int temporary = array[indexB];
        array[indexB] = array[indexA];
        array[indexA] = temporary;

    }
}
