import javax.xml.crypto.Data;
import java.util.Date;

public class Student {
//    @Override
//    public int compareTo(Student o) {
//        // sắp xếp theo ten
////        return this.name.compareTo(o.name);
//        // cân nặng giảm dần
////        return Double.compare(this.weight,o.weight);
//        // tuổi giảm dần
//            return this.age-o.age;
//    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }

    private int id;
    private String name;
    private int age;
    private double weight;

    public Student() {
    }

    public Student(int id, String name, int age, double weight) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
