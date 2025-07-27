package org.pronet.app.models;

import org.pronet.app.abstracts.Person;

public class Student extends Person {
    private Double gpa;
    private Long teacherId;

    public Student() {
    }

    public Student(Long id, String firstName, String lastName, String email, Double gpa, Long teacherId) {
        super(id, firstName, lastName, email);
        this.gpa = gpa;
        this.teacherId = teacherId;
    }

    public Double getGpa() {
        return gpa;
    }

    public Student setGpa(Double gpa) {
        this.gpa = gpa;
        return this;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public Student setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
        return this;
    }
}
