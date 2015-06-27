public class Triangle {
    TriangleKind tk=TriangleKind.SCALENE;

    public Triangle(double a, double b, double c) throws TriangleException {
        if (a + b <= c | b+c <= a | a+c <= b) throw new TriangleException();
        if (a==b || a==c || b==c) tk=TriangleKind.ISOSCELES;
        if (a==b && b==c) tk=TriangleKind.EQUILATERAL;
    }

    public TriangleKind getKind(){
        return tk;
    }
}
