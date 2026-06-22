import java.util.Objects;

public class User {
    private int age;
    private String name;
    private int number;

    public User(int age, String name, int number){
        this.age = age;
        this.name = name;
        this.number = number;
        System.out.printf("Constructor for new user has been called!\n");
    }

    public User(){
        this(20, "Vasya", 88743);
        System.out.printf("Default user has been created!\n");
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", number=" + number +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getAge() == user.getAge() && getNumber() == user.getNumber() && Objects.equals(getName(), user.getName());
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
