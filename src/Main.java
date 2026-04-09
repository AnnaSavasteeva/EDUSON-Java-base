import oop.abstract_classes.AnimalProcess;

public class Main {

    public static void main(String[] args) {

        new AnimalProcess().runHomework();

        System.out.println("---------");
        char THIN_SPACE = ' ';
        char MATH_SPACE = ' ';
        System.out.println("Стоимость товара: 200" + THIN_SPACE + "у.е.");
        System.out.println("Стоимость товара: 500" + MATH_SPACE + "у.е.");
    }
}