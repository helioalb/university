package me.helioalbano.university.library.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TeacherTest {

    @Test
    @DisplayName ("Should create a teacher with valid data")
    public void shouldCreateATeacherWithValidData() {
        var name = "Jane Smith";
        var email = "jane.smith@example.com";

        var teacher = new Teacher(name, email);

        assertNotNull(teacher);
        assertEquals(name, teacher.getName());
        assertEquals(email, teacher.getEmail());
    }

    @Test
    @DisplayName ("Should calculate due date for teacher")
    public void shouldCalculateDueDateForTeacher() {
        var name = "Jane Smith";
        var email = "jane.smith@example.com";
        var teacher = new Teacher(name, email);

        var actualDueDate = teacher.calculateDueDate(LocalDate.of(2026, 1, 1));

        assertEquals(LocalDate.of(2026, 1, 31), actualDueDate);
    }
}
