package oop.abstract_classes;

/**
 * @author annasavasteeva
 * @date 22.03.2026
 */
public class Circle extends GeometricFigure {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
        super.figureArea = calculateArea();
        super.figurePerimeter = calculatePerimeter();
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getFigureArea() {
        return super.getFigureArea();
    }

    @Override
    public double getFigurePerimeter() {
        return super.getFigurePerimeter();
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
