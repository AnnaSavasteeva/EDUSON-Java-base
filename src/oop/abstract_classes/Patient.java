package oop.abstract_classes;

/**
 * @author annasavasteeva
 * @date 29.03.2026
 */
public class Patient {

    private int treatmentPlan;
    private Doctor doctor;

    public Patient(int treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
    }

    public int getTreatmentPlan() {
        return treatmentPlan;
    }

    public void setTreatmentPlan(int treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
