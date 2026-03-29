package oop.abstract_classes;

/**
 * @author annasavasteeva
 * @date 29.03.2026
 */
public class Surgeon extends Doctor {

    public Surgeon(String doctorName) {
        super(doctorName);
    }

    @Override
    public void treat() {
        System.out.printf("%s сделал Вам операцию%n", super.getDoctorName());
    }
}
