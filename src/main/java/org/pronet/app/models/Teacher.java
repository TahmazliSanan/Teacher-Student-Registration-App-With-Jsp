package org.pronet.app.models;

import org.pronet.app.abstracts.Person;

public class Teacher extends Person {
    public Teacher() {
    }

    public Teacher(Long id, String firstName, String lastName, String email) {
        super(id, firstName, lastName, email);
    }
}
