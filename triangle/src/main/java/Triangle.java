import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

public class Triangle {
    private TriangleKind tk=TriangleKind.SCALENE;

    public Triangle(double a, double b, double c) throws TriangleException {
        if (isIllegal(a,b,c)) throw new TriangleException();
        if (a==b || a==c || b==c) tk=TriangleKind.ISOSCELES;
        if (a==b && b==c) tk=TriangleKind.EQUILATERAL;
    }

    private Boolean isIllegal(double a, double b, double c) {
        return a+b <= c | b+c <= a | a+c <= b;
    }

    private Boolean twoSidesAreEqual

    public TriangleKind getKind(){
        return tk;
    }
}
