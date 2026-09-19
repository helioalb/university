package me.helioalbano.university.library.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StudentTest {

    @Test
    @DisplayName("Should create a student with valid data")
    public void shouldCreateAStudentWithValidData() {
        var studentId = "20090560022";
        var name = "John Doe";
        var email = "john.doe@example.com";

        var student = new Student(studentId, name, email);

        assertNotNull(student);
        assertEquals(name, student.getName());
        assertEquals(email, student.getEmail());
        assertEquals(3, student.getMaxActiveLoans());
    }

    @Test
    @DisplayName("Should calculate due date for student")
    public void shouldCalculateDueDateForStudent() {
        var studentId = "20090560022";
        var name = "Helio Albano";
        var email = "helio@mail.com";
        var student = new Student(studentId, name, email);

        var actualDueDate = student.calculateDueDate(LocalDate.of(2026, 1, 1));

        assertEquals(LocalDate.of(2026, 1, 8), actualDueDate);
    }
}
