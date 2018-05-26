package interface_Generics.Interface;

public class Test {
    public static void main(String[] args) {
        Circel circel = new Circel(7.5);
        //Kan ikke kalde printable, fordi den ikke kan garanterer at Shape er printable.
        //Ved det først i runtime.
        Shape rectangle = new Rectangle(3.0, 5.5);

        circel.print();

        System.out.println(circel.area());
        System.out.println(rectangle.area());

    }
}
