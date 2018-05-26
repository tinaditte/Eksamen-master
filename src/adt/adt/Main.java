package adt.adt;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Earring leftEar = new Earring("Red", "Gold");
        Earring rigthEar = new Earring("pink", "plastic");
        Bag bag = new Bag();

        bag.add("Books");
        bag.add("Purse");
        bag.add("Pencil case");
        bag.add("Computer");

        List<Accessory> accessories = new ArrayList<>();
        accessories.add(leftEar);
        accessories.add(rigthEar);
        accessories.add(bag);

        for (Accessory accessory : accessories) {
            System.out.println("My " + accessory.color() + " weights " + accessory.weight());
        }
    }
}
