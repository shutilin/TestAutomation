package logic;

public class TriangleHelper {

    public static boolean isValidTriangle(double a, double b, double c) {
        if (a<=0 || b<=0 || c<=0) {
            throw new IllegalArgumentException("Invalid sides");
        }

        return (a + b > c) && (b + c > a) && (a + c > b);
    }
}
