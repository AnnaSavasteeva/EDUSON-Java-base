package oop.abstract_classes;

/**
 * @author annasavasteeva
 * @date 31.03.2026
 */
public abstract class Animal {

    private String animalName;

    public Animal(String animalName) {
        this.animalName = animalName;
    }

    public abstract void voice();

    public abstract void eat(String food);

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }
}
