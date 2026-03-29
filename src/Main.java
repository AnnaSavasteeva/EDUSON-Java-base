import oop.abstract_classes.DoctorProcess;
import oop.reflection.AppleProcess;

public class Main {

    public static void main(String[] args) {

//        new HomeWork1().processHW1();
//        new HomeWork2().processHW2();

        new DoctorProcess().runHomework();
        new AppleProcess().runHomework();
    }
}