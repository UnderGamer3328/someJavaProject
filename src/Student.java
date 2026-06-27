import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Student extends Person implements Cloneable, Comparable<Student>, Serializable {
    private int kurs;
    private ArrayList<String> zachetka;
    private String location;
    private double health;
    private final long id;

    {
        id = ThreadLocalRandom.current().nextLong(100_000, 1_000_000);
        System.out.printf("New Student with student id:%d has been created!\n", id);
    }

    public Student(int age, String name, int number, int kurs, ArrayList<String> zachetka, String location, double health){
        super(age, name, number);
        this.kurs = kurs;
        this.zachetka = zachetka;
        this.location = location;
        this.health = health;
        System.out.print("Constructor for new Student has been called!\n");
    }

    @Override
    public String toString() {
        return "Student{" +
                "kurs=" + kurs +
                ", zachetka=" + zachetka +
                ", location='" + location + '\'' +
                ", health=" + health +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return getKurs() == student.getKurs() && Double.compare(getHealth(), student.getHealth()) == 0 && getId() == student.getId() && Objects.equals(getZachetka(), student.getZachetka()) && Objects.equals(getLocation(), student.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getKurs(), getZachetka(), getLocation(), getHealth(), getId());
    }



    public int getKurs() {
        return kurs;
    }

    public void setKurs(int kurs) {
        this.kurs = kurs;
    }

    public ArrayList<String> getZachetka() {
        return zachetka;
    }

    public void setZachetka(ArrayList<String> zachetka) {
        this.zachetka = zachetka;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public long getId() {
        return id;
    }

    @Override
    public int compareTo(Student o) {
        return Double.compare(this.health, o.health);
    }

    @Override
    public Student clone() {
        try {
            Student cloned = (Student) super.clone();
            cloned.zachetka = new ArrayList<>(this.zachetka);
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}