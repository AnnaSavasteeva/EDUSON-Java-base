package oop.abstract_classes;

/**
 * @author annasavasteeva
 * @date 01.04.2026
 */
public class Rabbit extends Animal {

    public Rabbit(String animalName) {
        super(animalName);
    }

    @Override
    public void voice() {
        System.out.println(super.getAnimalName() + " обычно молчит.");
    }

    @Override
    public void eat(String food) {
        switch (food) {
            case AnimalFood.GRASS -> System.out.printf("%s очень любит и ест только %s%n", super.getAnimalName(), food);
            case AnimalFood.MEAT -> System.out.printf("%s очень недоволен, что ему предлагают %s%n", super.getAnimalName(), food);
            default -> System.out.printf("%s не ест %s%n", super.getAnimalName(), food);
        }
    }
}
