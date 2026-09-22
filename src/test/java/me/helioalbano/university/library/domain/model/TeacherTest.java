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
        var teacherId = "99990000001";

        var teacher = new Teacher(teacherId);

        assertNotNull(teacher);
        assertEquals(7, teacher.getMaxActiveLoans());
    }

    @Test
    @DisplayName ("Should calculate due date for teacher")
    public void shouldCalculateDueDateForTeacher() {
        var teacherId = "99990000001";
        var teacher = new Teacher(teacherId);

        var actualDueDate = teacher.calculateDueDate(LocalDate.of(2026, 1, 1));

        assertEquals(LocalDate.of(2026, 1, 31), actualDueDate);
    }
}
