package oop.reflection;

import java.lang.reflect.Field;

/**
 * @author annasavasteeva
 * @date 30.03.2026
 */
public class AppleProcess {

    public void runHomework() {
        Apple apple = new Apple("WHITE");
        System.out.printf("Apple color: %s%n", apple.getColor());
        System.out.println("---------");

        try {
            Field field = apple.getClass().getDeclaredField("color");
            field.setAccessible(true);
            field.set(apple, "BLACK");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        System.out.printf("New color for Apple: %s%n", apple.getColor());
    }
}
