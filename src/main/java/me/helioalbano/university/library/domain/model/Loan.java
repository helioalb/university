package me.helioalbano.university.library.domain.model;

import java.time.LocalDate;

public final class Loan {
    private final User user;
    private final Copy copy;
    private final LocalDate loanDate;

    public Loan(final User user, final Copy copy, final LocalDate loanDate) {
        this.user = user;
        this.copy = copy;
        this.loanDate = loanDate;
    }

    public String getBorrower() {
        return user.getName();
    }

    public String getItemOnLoan() {
        return copy.getDescription();
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }
}
