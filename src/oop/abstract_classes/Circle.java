package oop.abstract_classes;

/**
 * @author annasavasteeva
 * @date 22.03.2026
 */
public class Circle extends GeometricFigure {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
        super.setFigureArea(calculateArea());
        super.setFigurePerimeter(calculatePerimeter());
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
