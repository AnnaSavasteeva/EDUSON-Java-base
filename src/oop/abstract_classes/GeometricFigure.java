package oop.abstract_classes;

/**
 * @author annasavasteeva
 * @date 22.03.2026
 */
public abstract class GeometricFigure {

    private String figureName;
    private double figureArea;
    private double figurePerimeter;

    public abstract double calculateArea();

    public abstract double calculatePerimeter();

    public String getFigureName() {
        return figureName;
    }

    public void setFigureName(String figureName) {
        this.figureName = figureName;
    }

    public double getFigureArea() {
        return this.figureArea;
    }

    public void setFigureArea(double figureArea) {
        this.figureArea = figureArea;
    }

    public double getFigurePerimeter() {
        return this.figurePerimeter;
    }

    public void setFigurePerimeter(double figurePerimeter) {
        this.figurePerimeter = figurePerimeter;
    }
}
