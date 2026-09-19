package me.helioalbano.university.library.domain.model;

import java.time.LocalDate;

abstract public class User {
    private String userId;
    private String name;
    private String email;

    User(final String userId, final String name, final String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    abstract public LocalDate calculateDueDate(final LocalDate loanDate);

    abstract public int getMaxActiveLoans();

    public boolean isBlocked() {
        return false;
    }

    public boolean hasReachedLoanLimit() {
        return false;
    }

    public boolean hasOverdueLoans() {
        return false;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }
}
