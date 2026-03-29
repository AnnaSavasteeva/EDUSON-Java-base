package oop.abstract_classes;

/**
 * @author annasavasteeva
 * @date 29.03.2026
 */
public class DoctorProcess {

    public void runHomework() {
        Therapist therapist = new Therapist("ТЕРАПЕВТ");
        Patient patientForSurgeon = new Patient(1);
        Patient patientForDentist = new Patient(2);
        Patient patientForTherapist = new Patient(3);

        therapist.prescribeTreatment(patientForSurgeon);
        System.out.println("---------");
        therapist.prescribeTreatment(patientForDentist);
        System.out.println("---------");
        therapist.prescribeTreatment(patientForTherapist);
    }
}
