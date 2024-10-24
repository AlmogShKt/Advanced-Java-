package mmn12.q1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // ---- A ----
        Onwer owner1 = new Onwer("Almog Shta", "123-456-7890");
        Onwer owner2 = new Onwer("Almog Shtaigmann", "987-654-3210");
        Onwer owner3 = new Onwer("Almog Shta", "123-456-7890");

        Dog dog1 = new Dog("Nova", 3, "Brown", owner1);
        Dog dog2 = new Dog("Nova", 3, "Brown", owner1);
        Dog dog3 = new Dog("Chai", 4, "Black", owner2);
        Dog dog4 = new Dog("Nova", 3, "Brown", owner3);

        System.out.println("Dog1 equals Dog2: " + dog1.equals(dog2));
        System.out.println("Dog1 equals Dog3: " + dog1.equals(dog3));
        System.out.println("Dog1 equals Dog4: " + dog1.equals(dog4));

        System.out.println("Dog1 toString: " + dog1.toString());
        System.out.println("Dog3 toString: " + dog3.toString());

        // ---- B ----
        ArrayList<Dog> animals = new ArrayList<>();
        animals.add(dog1);
        animals.add(dog2);
        animals.add(dog3);

        for (Animal animal : animals) {
            System.out.println(animal.toString());
            animal.eat();
            animal.move();

            if (animal instanceof Mammal) {
                ((Mammal) animal).breath();
            }

            System.out.println();
        }

        // ---- C ----
        Dog cloneDog1 = dog1.clone();
        System.out.println("dog1: " + dog1 + " " + "clone: "  + cloneDog1);
        cloneDog1.setAge(12);
        cloneDog1.setName("Milka");
        cloneDog1.setOwner(new Onwer("Eden", "9999999"));
        System.out.println("dog1: " + dog1 + " " + "clone: "  + cloneDog1);
    }
}