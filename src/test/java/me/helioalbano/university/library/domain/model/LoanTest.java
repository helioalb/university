package me.helioalbano.university.library.domain.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.Clock;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoanTest {
    @Test
    @DisplayName("Should create a loan with valid data")
    public void shouldCreateALoanWithValidData() {
        var studendId = "20090560022";

        User student = new Student(studendId);
        Item book = new Book("Effective Java", "Joshua Bloch");
        Copy copy = new Copy("CC-001", book, true);

        var loan = Loan.create(student, copy, Clock.systemDefaultZone());

        assertNotNull(loan);
    }
}
