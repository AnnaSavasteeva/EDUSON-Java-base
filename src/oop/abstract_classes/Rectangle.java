package oop.abstract_classes;

/**
 * @author annasavasteeva
 * @date 22.03.2026
 */
public class Rectangle extends GeometricFigure {

    private double length;
    private double width;

    public Rectangle(String figureName, double length, double width) {
        super.setFigureName(figureName);
        this.length = length;
        this.width = width;
        super.setFigureArea(calculateArea());
        super.setFigurePerimeter(calculatePerimeter());
    }

    @Override
    public double calculateArea() {
        return this.length * this.width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (this.length + this.width);
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
