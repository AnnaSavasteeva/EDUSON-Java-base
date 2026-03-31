package oop.abstract_classes;

/**
 * @author annasavasteeva
 * @date 01.04.2026
 */
public class Tiger extends Animal {

    public Tiger(String animalName) {
        super(animalName);
    }

    @Override
    public void voice() {
        System.out.println(super.getAnimalName() + " говорит: ррррррр!");
    }

    @Override
    public void eat(String food) {
        switch (food) {
            case AnimalFood.MEAT -> System.out.printf("%s очень любит %s%n", super.getAnimalName(), food);
            case AnimalFood.BONE -> System.out.printf("%s может погрызть %s, но ему это не очень нравится%n", super.getAnimalName(), food);
            default -> System.out.printf("%s не ест %s%n", super.getAnimalName(), food);
        }
    }
}
