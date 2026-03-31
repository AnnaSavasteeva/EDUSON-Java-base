package oop.interfaces;

/**
 * @author annasavasteeva
 * @date 22.03.2026
 */
public class Worker implements JobPosition {

    private final String jobPositionName = "Рабочий";

    @Override
    public void printJobPositionName() {
        System.out.printf("Должность '%s'%n", this.jobPositionName);
    }
}
