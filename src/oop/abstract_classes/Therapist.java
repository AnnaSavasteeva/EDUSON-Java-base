package oop.abstract_classes;

/**
 * @author annasavasteeva
 * @date 29.03.2026
 */
public class Therapist extends Doctor {

    public Therapist(String doctorName) {
        super.setDoctorName(doctorName);
    }

    @Override
    public void treat() {
        System.out.printf("Вас лечит %s", super.getDoctorName());
    }

    public void prescribeTreatment(Patient patient) {
        if (patient.getTreatmentPlan() == 1) {

        } else if (patient.getTreatmentPlan() == 2) {

        } else {
            patient.setDoctor(this);
            patient.getDoctor().treat();
        }
    }
}
