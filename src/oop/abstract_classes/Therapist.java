package oop.abstract_classes;

/**
 * @author annasavasteeva
 * @date 29.03.2026
 */
public class Therapist extends Doctor {

    public Therapist(String doctorName) {
        super(doctorName);
    }

    @Override
    public void treat() {
        System.out.printf("%s проводит скрининг Ваших анализов для назначения лечения%n", super.getDoctorName());
    }

    public void prescribeTreatment(Patient patient) {
        if (patient.getTreatmentPlan() == 1) {
            patient.setDoctor(new Surgeon("ХИРУРГ"));
        } else if (patient.getTreatmentPlan() == 2) {
            patient.setDoctor(new Dentist("ДАНТИСТ"));
        } else {
            patient.setDoctor(this);
        }
    }
}
