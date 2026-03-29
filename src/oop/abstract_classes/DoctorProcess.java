package oop.abstract_classes;

import java.util.Arrays;

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
        therapist.prescribeTreatment(patientForDentist);
        therapist.prescribeTreatment(patientForTherapist);

        Arrays.asList(patientForSurgeon, patientForDentist, patientForTherapist).forEach(patient -> {
            patient.getDoctor().treat();
            System.out.println("---------");
        });
    }
}
