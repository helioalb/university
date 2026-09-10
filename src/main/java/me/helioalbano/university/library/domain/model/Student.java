package me.helioalbano.university.library.domain.model;

import java.time.LocalDate;

public final class Student extends User {

    public Student(final String name, final String email) {
        super(name, email);
    }

    @Override
    public LocalDate calculateDueDate(final LocalDate loanDate) {
        return loanDate.plusDays(7);
    }
}
