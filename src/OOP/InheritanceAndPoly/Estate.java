package OOP.InheritanceAndPoly;

public abstract class Estate {
    private String address;
    private int size;
    private int rooms;
    private int price;

    public Estate(String address, int size, int rooms, int price){
        this.address = address;
        this.size = size;
        this.rooms = rooms;
        this.price = price;

    }

    @Override
    public String toString(){
        String estate = ("Address: " + address + "\nSize: " + size + " m2." + "\nRooms: " + rooms + " incl. Livingroom." + "\nPrice: " + price + " DKK/md." );

        return estate;
    }

}
