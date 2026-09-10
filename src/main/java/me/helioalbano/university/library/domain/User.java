package me.helioalbano.university.library.domain;

import java.time.LocalDate;

abstract class User {
    private String name;
    private String email;

    User(final String name, final String email) {
        this.name = name;
        this.email = email;
    }

    abstract public LocalDate calculateDueDate(final LocalDate loanDate);

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
