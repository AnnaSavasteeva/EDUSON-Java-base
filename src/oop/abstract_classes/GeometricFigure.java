package oop.abstract_classes;

/**
 * @author annasavasteeva
 * @date 22.03.2026
 */
public abstract class GeometricFigure {

    protected double figureArea;
    protected double figurePerimeter;

    public abstract double calculateArea();

    public abstract double calculatePerimeter();

    public double getFigureArea() {
        return figureArea;
    }

    public double getFigurePerimeter() {
        return figurePerimeter;
    }
}
