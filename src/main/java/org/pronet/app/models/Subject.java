package org.pronet.app.models;

import org.pronet.app.abstracts.BaseModel;

public class Subject extends BaseModel {
    private String name;
    private Long teacherId;

    public Subject() {
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

    public Long getTeacherId() {
        return teacherId;
    }

    public Subject setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
        return this;
    }
}
