package adt.adt;

public class Earring implements Accessory {
    private String color;
    private String material;

    public Earring(String color, String material){
        this.color = color;
        this.material = material;
    }

    @Override
    public String color() {
        return color + " " + material + " earring";
    }

    @Override
    public int weight() {
        return 1;
    }
}
