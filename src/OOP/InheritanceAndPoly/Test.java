package OOP.InheritanceAndPoly;

public class Test {
    public static void main(String[] args) {
        Estate Strandparken = new Apartment("Ved Engen 1", "1. th", 96, 3, false, 12000);
        Strandparken.toString();
        System.out.println(Strandparken);
        System.out.println(Strandparken.getClass());

    }
}
