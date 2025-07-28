package org.pronet.app.models;

import org.pronet.app.abstracts.BaseModel;

public class Subject extends BaseModel {
    private String name;
    private String teacherFirstName;
    private String teacherLastName;
    private Long teacherId;

    public Subject() {
    }

    public Subject(Long id, String name, String teacherFirstName, String teacherLastName) {
        super(id);
        this.name = name;
        this.teacherFirstName = teacherFirstName;
        this.teacherLastName = teacherLastName;
    }

    public Subject(String name, Long teacherId) {
        this.name = name;
        this.teacherId = teacherId;
    }

    public Subject(Long id, String name, Long teacherId) {
        super(id);
        this.name = name;
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public Subject setName(String name) {
        this.name = name;
        return this;
    }

    public String getTeacherFirstName() {
        return teacherFirstName;
    }

    public Subject setTeacherFirstName(String teacherFirstName) {
        this.teacherFirstName = teacherFirstName;
        return this;
    }

    public String getTeacherLastName() {
        return teacherLastName;
    }

    public Subject setTeacherLastName(String teacherLastName) {
        this.teacherLastName = teacherLastName;
        return this;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public Subject setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
        return this;
    }
}
