import java.util.*;

public class TestGenerics2 {
    public static void main(String[] args) {
        new TestGenerics1().go();
    }

    public void go() {
        // Declare an animal array that contains dogs and cats.
        ArrayList<Animal> animals = new ArrayList<Animal>();
        animals.add(new Dog());
        animals.add(new Cat());
        animals.add(new Dog());
        takeAnimals(animals);
    }

    public void takeAnimals(ArrayList<Animal> animals) {
        // Polymorphic!
        for (Animal a: animals) {
            a.eat();
        }
    }
}
