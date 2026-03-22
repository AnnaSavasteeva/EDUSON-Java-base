package oop.abstract_classes;

/**
 * @author annasavasteeva
 * @date 22.03.2026
 */
public abstract class GeometricFigure {

    double figureArea;
    double figurePerimeter;

    abstract void calculateArea();

    abstract void calculatePerimeter();

    public double getFigureArea() {
        return figureArea;
    }

    public double getFigurePerimeter() {
        return figurePerimeter;
    }
}
