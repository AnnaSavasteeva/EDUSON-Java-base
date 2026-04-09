package oop.abstract_classes;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static java.util.Arrays.asList;

/**
 * @author annasavasteeva
 * @date 01.04.2026
 */
public class AnimalProcess {

    public void runHomework() {

        Animal dog;
        try {
            Class<?> dogClass = Class.forName("oop.abstract_classes.Dog");
            Constructor<?> dogConst = dogClass.getDeclaredConstructor(String.class);
            dogConst.setAccessible(true);
            dog = (Dog) dogConst.newInstance("Собакен");
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        Animal tiger = new Tiger("Тигра");
        Animal rabbit = new Rabbit("Кроля");
        String[] foodArray = {AnimalFood.MEAT, AnimalFood.GRASS, AnimalFood.BONE, "Печенька"};

        asList(dog, tiger, rabbit).forEach(animal -> {
            if (animal == null) throw new NullPointerException();
            System.out.println("---------");
            animal.voice();
            asList(foodArray).forEach(animal::eat);
            System.out.println("---------");
        });
    }
}
