package oop.abstract_classes;

/**
 * @author annasavasteeva
 * @date 22.03.2026
 */
public class Rectangle extends GeometricFigure {

    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
        super.figureArea = calculateArea();
        super.figurePerimeter = calculatePerimeter();
    }

    @Override
    public double calculateArea() {
        return this.length * this.width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (this.length + this.width);
    }

    @Override
    public double getFigureArea() {
        return super.getFigureArea();
    }

    @Override
    public double getFigurePerimeter() {
        return super.getFigurePerimeter();
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
