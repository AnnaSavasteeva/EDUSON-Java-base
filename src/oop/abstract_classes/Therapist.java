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
        System.out.printf("%s проводит скрининг Ваших анализов для назначения лечения", super.getDoctorName());
    }

    public void prescribeTreatment(Patient patient) {
        if (patient.getTreatmentPlan() == 1) {
            patient.setDoctor(new Surgeon("ХИРУРГ"));
            patient.getDoctor().treat();
        } else if (patient.getTreatmentPlan() == 2) {
            patient.setDoctor(new Dentist("ДАНТИСТ"));
            patient.getDoctor().treat();
        } else {
            patient.setDoctor(this);
            patient.getDoctor().treat();
        }
    }
}
