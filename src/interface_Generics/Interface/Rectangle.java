package interface_Generics.Interface;

public class Rectangle implements Shape, Printable{
    private double height;
    private double width;

    public Rectangle(double height, double width){
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return height * width;
    }

    @Override
    public double circumference() {
        return 2.0 * (width + height);
    }

    @Override
    public void print() {
        System.out.println(new Rectangle(height, width) + " is " + width + " width" + " and " + height + " height.");
    }
}
