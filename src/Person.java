import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {
    private int age;
    private String name;
    private int number;

    public Person(int age, String name, int number){
        this.age = age;
        this.name = name;
        this.number = number;
        //System.out.printf("Constructor for new Person has been called!\n");
    }

    public Person(){
        this(20, "Vasya", 88743);
        System.out.printf("Default Person has been created!\n");
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", number=" + number +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person Person = (Person) o;
        return getAge() == Person.getAge() && getNumber() == Person.getNumber() && Objects.equals(getName(), Person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAge(), getName(), getNumber());
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
