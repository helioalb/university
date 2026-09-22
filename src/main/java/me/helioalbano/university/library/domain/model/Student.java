package me.helioalbano.university.library.domain.model;

import java.time.LocalDate;

public final class Student extends User {

    public Student(final String studentId) {
        super(studentId);
    }

    @Override
    public LocalDate calculateDueDate(final LocalDate loanDate) {
        return loanDate.plusDays(7);
    }

    @Override
    public int getMaxActiveLoans() {
        return 3;
    }
}
