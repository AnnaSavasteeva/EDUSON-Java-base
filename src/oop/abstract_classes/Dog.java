package oop.abstract_classes;

/**
 * @author annasavasteeva
 * @date 01.04.2026
 */
public class Dog extends Animal {

    public Dog(String animalName) {
        super(animalName);
    }

    @Override
    public void voice() {
        System.out.println(super.getAnimalName() + " говорит: гав-гав");
    }

    @Override
    public void eat(String food) {
        switch (food) {
            case AnimalFood.MEAT, AnimalFood.BONE -> System.out.printf("%s любит %s%n", super.getAnimalName(), food);
            default -> System.out.printf("%s не ест %s%n", super.getAnimalName(), food);
        }
    }
}
