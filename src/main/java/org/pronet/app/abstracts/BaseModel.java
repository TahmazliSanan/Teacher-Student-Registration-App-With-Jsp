package org.pronet.app.abstracts;

public abstract class BaseModel {
    private Long id;

    public BaseModel() {
    }

    public BaseModel(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public BaseModel setId(Long id) {
        this.id = id;
        return this;
    }
}
