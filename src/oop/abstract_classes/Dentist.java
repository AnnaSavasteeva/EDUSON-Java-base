package oop.abstract_classes;

/**
 * @author annasavasteeva
 * @date 29.03.2026
 */
public class Dentist extends Doctor {

    public Dentist(String doctorName) {
        super(doctorName);
    }

    @Override
    public void treat() {
        System.out.printf("Вас лечит %s", super.getDoctorName());
    }
}
