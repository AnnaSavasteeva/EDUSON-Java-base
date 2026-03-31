package oop.abstract_classes;

/**
 * @author annasavasteeva
 * @date 22.03.2026
 */
public class Triangle extends GeometricFigure {

    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(String figureName, double sideA, double sideB, double sideC) {
        super.setFigureName(figureName);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        super.setFigureArea(calculateArea());
        super.setFigurePerimeter(calculatePerimeter());
    }

    @Override
    public double calculateArea() {
//        По формуле Герона
        double semiperimeter = super.getFigurePerimeter() / 2;
        return Math.sqrt(semiperimeter * (semiperimeter - this.sideA) * (semiperimeter - this.sideB) *
                (semiperimeter - this.sideC));
    }

    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }
}
