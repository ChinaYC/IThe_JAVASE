package COM.I.JAVASE;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 学生类
 */
public class Student implements Comparable<Student>{
    public String id;
    public String name;

    public Set<Course> courses;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public Student(String id, String name){
        this.id = id;
        this.name = name;
        this.courses = new HashSet<Course>();

    }


    @Override
    public int compareTo(Student o) {
        return this.id.compareTo(o.id);
    }
}
