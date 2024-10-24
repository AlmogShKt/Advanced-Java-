/**
 * Maman by ALmog Shtaigmann
 */

package mmn12.q1;

abstract public class Animal {
    private String name;
    private Integer age;
    private String color;

    public Animal(String name, Integer age, String color) {
        setAge(age);
        setName(name);
        setColor(color);
    }

    public abstract void eat();

    public abstract void move();


    public String getName() {
        return this.name;
    }

    public String getColor() {
        return this.color;
    }

    public Integer getAge() {
        return this.age;
    }

    // for all setter function - assuming the input is valid
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        String toStringName = "name: " + name;
        String toStringAge = " age: " + age;
        String toStringColor = " color: " + color;

        return toStringName + toStringAge + toStringColor;
    }

    public Boolean equals(Animal animal) {
        return (this.name.equals(animal.getName())) &&
                (this.color.equals(animal.getColor())) &&
                (this.age.equals(animal.getAge()));
    }
}