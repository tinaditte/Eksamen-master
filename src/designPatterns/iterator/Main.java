package designPatterns.iterator;/*
Created by Karo on 16-May-18.
*/

public class Main {
    public static void main(String[] args) {
        Biterator biterator = new Biterator(1234577455);
        String number = "";
        System.out.print("Opbygges en bit ad gangen/mindste bit først: ");

        while (biterator.hasNext()) {
            if (biterator.next() == true) {
                //true er den et (da den ikke e r0)
                System.out.print("1");
                number = 1 + number;
            } else {
                System.out.print("0");
                number = 0 + number;
            }
        }
        System.out.println("");
        System.out.println("Vendt rigtigt:                               " + number);
    }
}
