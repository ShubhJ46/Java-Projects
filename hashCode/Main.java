package hashCode;

import java.util.Objects;
import java.util.HashMap;
import java.util.HashSet;

class Student {
    int id;
    String name;

    public Student(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o)  return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}

public class Main {
    public static void main(String[] args) {
        HashSet<Student> set = new HashSet<Student>();
        Student s = new Student(1, "Alex");
        set.add(s);
        Student s2 = new Student(1, "Alex");
        set.add(s2);

        System.out.println("Size of hashSet: " + set.size());

        HashMap <Student, Integer> mp = new HashMap<Student, Integer>();
        mp.put(s, 90);
        mp.put(s2, 95);

        System.out.println("Size of hashMap: " + mp.size());

        for (Student it: mp.keySet()) {
            System.out.println("Student id: " + it.id + " Student name: " + it.name);
        }
    }
}
