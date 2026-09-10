package me.helioalbano.university.library.domain.model;

import java.time.LocalDate;

public final class Teacher extends User {

    public Teacher(final String name, final String email) {
        super(name, email);
    }

    @Override
    public LocalDate calculateDueDate(final LocalDate loanDate) {
        return loanDate.plusDays(30);
    }

    @Override
    public int getMaxActiveLoans() {
        return 7;
    }
}
