package oop.interfaces;

/**
 * @author annasavasteeva
 * @date 22.03.2026
 */
public class Accountant implements JobPosition {

    private final String jobPositionName = "Бухгалтер";

    @Override
    public void printJobPositionName() {
        System.out.printf("Должность '%s'%n", this.jobPositionName);
    }
}
