import java.util.*;

public class TestGenerics1 {
    public static void main(String[] args) {
        new TestGenerics1().go();
    }

    public void go() {
        // Declare an animal array that contains dogs and cats.
        Animal[] animals = {new Dog(), new Cat(), new Dog()};
        // Dog array that holds only dogs.
        Dog[] dogs = {new Dog(), new Dog(), new Dog()};
        takeAnimals(animals);
        takeAnimals(dogs);
    }

    public void takeAnimals(Animal[] animals) {
        // Polymorphic!
        for (Animal a: animals) {
            a.eat();
        }
    }
}
