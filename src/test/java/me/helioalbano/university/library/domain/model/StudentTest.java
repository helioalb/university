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

        var student = new Student(studentId);

        assertNotNull(student);
        assertEquals(3, student.getMaxActiveLoans());
    }

    @Test
    @DisplayName("Should calculate due date for student")
    public void shouldCalculateDueDateForStudent() {
        var studentId = "20090560022";
        var student = new Student(studentId);

        var actualDueDate = student.calculateDueDate(LocalDate.of(2026, 1, 1));

        assertEquals(LocalDate.of(2026, 1, 8), actualDueDate);
    }
}
