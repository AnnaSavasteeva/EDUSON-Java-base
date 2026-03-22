package oop.abstract_classes;

import java.util.Scanner;

/**
 * @author annasavasteeva
 * @date 23.03.2026
 */
public class GeometricFigureProcess {

    public void runAbstractClassHomework() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Укажите длины сторон треугольника:");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        GeometricFigure triangle = new Triangle(a, b, c);

        System.out.println("Укажите длину и ширину прямоугольника:");
        double length = sc.nextDouble();
        double width = sc.nextDouble();
        GeometricFigure rectangle = new Rectangle(length, width);

        System.out.println("Укажите длину стороны квадрата:");
        double squareLength = sc.nextDouble();
        GeometricFigure square = new Rectangle(squareLength, squareLength);

        System.out.println("Укажите радиус круга:");
        double radius = sc.nextDouble();
        GeometricFigure circle = new Circle(radius);

        System.out.println("Укажите радиус второго круга:");
        double secondRadius = sc.nextDouble();
        GeometricFigure secondCircle = new Circle(secondRadius);

        GeometricFigure[] figures = {triangle, rectangle, square, circle, secondCircle};
        double allFiguresPerimetersSum =0;
        for (GeometricFigure figure : figures) {
            allFiguresPerimetersSum += figure.getFigurePerimeter();
        }
        System.out.printf("Сумма периметра всех фигур: %.2f%n", allFiguresPerimetersSum);

        sc.close();
    }
}
