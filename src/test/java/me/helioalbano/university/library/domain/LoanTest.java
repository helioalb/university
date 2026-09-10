package me.helioalbano.university.library.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoanTest {
    @Test
    @DisplayName("Should create a loan with valid data")
    public void shouldCreateALoanWithValidData() {
        var student = new Student("John Doe", "john.doe@example.com");
        var book = new Book("Effective Java", "Joshua Bloch");
        var copy = new Copy("CC-001", book);
        var loanDate = LocalDate.of(2026, 1, 1);

        var loan = new Loan(student, copy, loanDate);

        assertNotNull(loan);
        assertEquals(loan.getBorrower(), "John Doe");
        assertEquals(loan.getItemOnLoan(), "CC-001 - Effective Java - Joshua Bloch");
        assertEquals(loan.getLoanDate(), loanDate);
    }
}
