package JavaStreams.LambdaCalc;

public class LambdaCalculator {

    public static void main(String[] args) {
        //Multiple values to a method using lambda, w/o specifying data type

        Calculate add = (a,b) -> a + b;
        Calculate difference = (a,b) -> Math.abs(a-b);
        //if b != 0, we a/b. if b= 0, skip a/b and return value after : (0)
        Calculate divide = (a,b) -> (b != 0 ? a/b : 0);
        Calculate multiply = (c,d) -> c * d;

        System.out.println(add.calc(3,2));
        System.out.println(difference.calc(5,10));
        System.out.println(divide.calc(12, 3));
        System.out.println(divide.calc(12, 0));
        System.out.println(multiply.calc(3,5));
    }
}
//store lambda operation (method part) in a variable --> use variable to print out a call on the method