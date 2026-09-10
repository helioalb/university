package me.helioalbano.university.library.domain.model;

import java.time.LocalDate;

abstract public class User {
    private String name;
    private String email;

    User(final String name, final String email) {
        this.name = name;
        this.email = email;
    }

    abstract public LocalDate calculateDueDate(final LocalDate loanDate);

    abstract public int getMaxActiveLoans();

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
