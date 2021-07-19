package com.koukio;

import java.util.Comparator;

public class Student implements Comparable<Student> {

    private final static Comparator<Student> CGPA_COMPARATOR = Comparator.comparingDouble(Student::getCGPA).reversed();
    private final static Comparator<Student> NAME_COMPARATOR = Comparator.comparing(Student::getName);
    private final static Comparator<Student> ID_COMPARATOR = Comparator.comparingInt(Student::getID);

    private final static Comparator<Student> STUDENT_COMPOSED_COMPARATOR = CGPA_COMPARATOR
            .thenComparing(NAME_COMPARATOR)
            .thenComparing(ID_COMPARATOR);

    private final int id;
    private final String name;
    private final double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }

    @Override
    public int compareTo(Student o) {
        return STUDENT_COMPOSED_COMPARATOR.compare(this, o);
    }

}
