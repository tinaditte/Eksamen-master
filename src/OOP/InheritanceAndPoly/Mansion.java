package OOP.InheritanceAndPoly;

public class Mansion extends Estate {
    private String drivewayType;
    private boolean isGarden;
    private boolean isShed;

    public Mansion(String address, int size, int rooms, int price, String drivewayType, boolean isGarden, boolean isShed) {
        super(address, size, rooms, price);
        this.drivewayType = drivewayType;
        this.isGarden = isGarden;
        this.isShed = isShed;
    }

    @Override
    public String toString(){
        return (super.toString() + "\nDrivewaytype: " + drivewayType + "\nGarden: " + isGarden + "\nShed; " + isShed);
    }
}