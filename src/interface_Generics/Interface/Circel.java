package interface_Generics.Interface;

public class Circel implements Shape, Printable{
    private double radius;

    public Circel(double radius){
        this.radius = radius;

    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double circumference() {
        return 2.0 * Math.PI * radius;
    }

    @Override
    public void print() {
        System.out.println(new Circel(radius) + " is " + radius + " radius");
    }
}
