package oop.abstract_classes;

/**
 * @author annasavasteeva
 * @date 22.03.2026
 */
public class Triangle extends GeometricFigure {

    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        super.figureArea = calculateArea();
        super.figurePerimeter = calculatePerimeter();
    }

    @Override
    public double calculateArea() {
//        По формуле Герона
        double semiperimeter = super.figurePerimeter / 2;
        return Math.sqrt(semiperimeter * (semiperimeter - this.sideA) * (semiperimeter - this.sideB) *
                (semiperimeter - this.sideC));
    }

    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public double getFigureArea() {
        return super.getFigureArea();
    }

    @Override
    public double getFigurePerimeter() {
        return super.getFigurePerimeter();
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
