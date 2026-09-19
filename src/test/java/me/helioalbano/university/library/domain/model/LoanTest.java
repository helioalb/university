package me.helioalbano.university.library.domain.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoanTest {
    @Test
    @DisplayName("Should create a loan with valid data")
    public void shouldCreateALoanWithValidData() {
        var studendId = "20090560022";
        var studenName = "Helio Albano";
        var studentEmail = "helio@mail.com";

        User student = new Student(studendId, studenName, studentEmail);
        Item book = new Book("Effective Java", "Joshua Bloch");
        Copy copy = new Copy("CC-001", book, true);

        var loan = new Loan(student, copy);

        assertNotNull(loan);
    }
}
