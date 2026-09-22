package me.helioalbano.university.library.domain.model;

import java.time.LocalDate;

abstract public class User {
    private String userId;

    User(final String userId) {
        this.userId = userId;
    }

    abstract public LocalDate calculateDueDate(final LocalDate loanDate);
    abstract public int getMaxActiveLoans();

    public boolean isBlocked() {
        return false;
    }

    public boolean hasReachedLoanLimit(int activeLoans) {
        return activeLoans >= getMaxActiveLoans();
    }

    public String getId() {
        return userId;
    }
}
