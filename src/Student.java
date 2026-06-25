import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Student extends Person{
    private int kurs;
    private ArrayList<String> zachetka;
    private String location;
    private double health;
    private final long id;

    {
        id = new Random(1).nextLong(100);
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
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return getKurs() == student.getKurs() && Double.compare(getHealth(), student.getHealth()) == 0 && Objects.equals(getZachetka(), student.getZachetka()) && Objects.equals(getLocation(), student.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getKurs(), getZachetka(), getLocation(), getHealth());
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
}
