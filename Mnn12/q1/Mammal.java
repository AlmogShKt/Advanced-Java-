package mmn12.q1;

public abstract class Mammal extends Animal {
    public Mammal(String name, Integer age, String color) {
        super(name, age, color);
    }

    //Mammal cant implement this move and eat function - it's too general for these calls and this is the reason this is an abstract class

    public void breath() {
        System.out.println("Mammal " + this.getName() + "is breathing");
    }

    @Override
    public String toString() {
        String parentToString = super.toString();
        return parentToString + "is Mammal";
    }
}
