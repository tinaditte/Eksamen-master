package efficiency.Sort;

import java.util.Arrays;

public class MergeSorter {
    public static void main(String[] args) {
        int[] array = {6, 5, 3, 1, 8, 7, 2, 4};
        System.out.println(Arrays.toString(splitAndMerge(array)));

    }

    public static int[] splitAndMerge(int[] array){
        if (array.length < 2 ){
            return array;
        }
        int[] arrayA = Arrays.copyOfRange(array, 0, array.length /2 );
        int[] arrayB = Arrays.copyOfRange(array , array.length /2, array.length );

        arrayA = splitAndMerge(arrayA);
        arrayB = splitAndMerge(arrayB);

        return merge(arrayA, arrayB);
    }

    //Samler de splittede array
    private static int[] merge(int[] arrayA, int[] arrayB){
        int indexA = 0;
        int indexB = 0;
        int indexArray = 0;
        int[] array = new int[arrayA.length + arrayB.length];

        while (indexA < arrayA.length && indexB < arrayB.length){
            //tager hele tiden det mindste element fra A eller B, afhængig af hvilket er mindst
            //smider det ind i det nye array
            if (arrayA[indexA] < arrayB[indexB]){
                array[indexArray] = arrayA[indexA];
                indexA++;
            } else{
                array[indexArray] = arrayB[indexB];
                indexB++;
            }
            indexArray++;
        }

        //hvis der stadig er flere elementer i arrayA efter man har taget alle fra en liste --> smides bagpå resultat-array
        while (indexA < arrayA.length){
            array[indexArray] = arrayA[indexA];
            indexA++;
            indexArray++;
        }

        //hvis der er flere elementer i arrayB, skal de smides bagpå
        while (indexB < arrayB.length){
            array[indexArray] = arrayB[indexB];
            indexB++;
            indexArray++;
        }

        return array;
    }
}
