package efficiency;

public class MergeSorter {
    public static void main(String[] args) {
        int[] array = {6, 5, 3, 1, 8, 7, 2, 4};

    }

    public static int[] merge(int[] arrayA, int[] arrayB){
        int indexA = 0;
        int indexB = 0;
        int indexArray = 0;
        int[] array = new int[arrayA.length + arrayB.length];

        while (indexA < arrayA.length && indexB < arrayB.length){
            if (arrayA[indexA] < arrayB[indexB]){
                array[indexArray] = arrayA[indexA];
                indexA++;
            } else{
                array[indexArray] = arrayB[indexB];
                indexB++;
            }
            indexArray++;
        }

        //hvis der stadig er flere elementer i arrayA, skal de smides bagpå
        //eller hvis der stadig er flere elementer i arrayB, skal de smides bagpå
        // også er vi færdige og kan returnerer 'array'

        return array;
    }

    /*
    public static int[][] split(int[] array){
        int[] left = new int[];
        int [] right = new int[];
        int[] combined = new int[][];
        if (array.length < 1){
            int[] left = Arrays.copyOfRange(array, 0, array.length / 2);
            int[] right = Arrays.copyOfRange(array, array.length / 2, array.length);

        } else{
            return new int[][] {array};
        }
    }*/
}
