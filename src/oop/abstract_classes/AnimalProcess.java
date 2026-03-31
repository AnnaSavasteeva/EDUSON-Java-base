package oop.abstract_classes;

import static java.util.Arrays.asList;

/**
 * @author annasavasteeva
 * @date 01.04.2026
 */
public class AnimalProcess {

    public void runHomework() {

        Animal dog = new Dog("Собакен");
        Animal tiger = new Tiger("Тигра");
        Animal rabbit = new Rabbit("Кроля");
        String[] foodArray = {AnimalFood.MEAT, AnimalFood.GRASS, AnimalFood.BONE, "Печенька"};

        asList(dog, tiger, rabbit).forEach(animal -> {
            System.out.println("---------");
            animal.voice();
            asList(foodArray).forEach(animal::eat);
            System.out.println("---------");
        });
    }
}
