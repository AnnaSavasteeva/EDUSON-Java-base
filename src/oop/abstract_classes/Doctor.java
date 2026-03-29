package oop.abstract_classes;

/**
 * @author annasavasteeva
 * @date 29.03.2026
 */
public abstract class Doctor {

    private String doctorName;

    public Doctor(String doctorName) {
        this.doctorName = doctorName;
    }

    public abstract void treat();

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
}
