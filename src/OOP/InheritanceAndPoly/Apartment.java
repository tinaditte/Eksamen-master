package OOP.InheritanceAndPoly;

public class Apartment extends Estate{
    private String floor;
    private boolean isBalcony;

    public Apartment(String address, String floor, int size, int rooms, boolean isBalcony, int price) {
        super(address, size, rooms, price);
        this.floor = floor;
        this.isBalcony = isBalcony;
    }

    public String toStringBalc(boolean isBalcony){
        if(isBalcony == true){
            return "Yes";
        }else
            return "No";
    }

    public String toString(){
        String apartment = (super.toString() + "\nFLoor: " + floor + "\nBalcony: " + toStringBalc(isBalcony));

        return apartment;
    }
}