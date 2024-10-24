package mmn12.q1;

public class Dog extends Mammal {
    private Onwer owner;

    public Dog(String name, Integer age, String color, Onwer owner) {
        super(name, age, color);
        setOwner(owner);
    }

    public Dog(String name, Integer age, String color, String ownerName, String ownerPhoneNumber) {
        super(name, age, color);
        setOwner(new Onwer(ownerName, ownerPhoneNumber));
    }

    @Override
    public void move() {
        System.out.println("Dog " + this.getName() + "is walking");
    }

    @Override
    public void eat() {
        System.out.println("Dog " + this.getName() + "is eating");
    }

    public void bark() {
        System.out.println("Dog " + this.getName() + "is barking");
    }

    public Onwer getOwner() {
        return this.owner;
    }

    public void setOwner(Onwer owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        String parentToString = super.toString();
        return parentToString + (", Owner :" + this.owner.getName());
    }

    public Dog clone() {
        Onwer onwer = new Onwer(this.owner.getName(), this.owner.getPhoneNumber());
        return new Dog(this.getName(), this.getAge(), this.getColor(), onwer);
    }

    public Boolean equals(Dog dog) {
        return super.equals(dog) && this.owner.equals(dog.getOwner());
    }
}