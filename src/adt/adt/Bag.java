package adt.adt;

import java.util.ArrayList;

public class Bag extends ArrayList implements Accessory {

    @Override
    public String color() {
        return "Blue bag";
    }

    @Override
    public int weight() {
        return 500 + this.size() * 100;
    }
}
