package me.helioalbano.university.library.domain

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.time.LocalDate
import kotlin.test.assertEquals

class UserTest {
    @Test
    @DisplayName("Deve calcular a data de devolução corretamente para um estudante")
    fun `should calculate due date correctly for a student`() {
        val student = User.Student(
            id = "1",
            name = "John Doe",
            email = "john.doe@example.com"
        )

        val dueDate = student.calculateDueDate(LocalDate.of(2026, 1, 1))

        assertEquals(LocalDate.of(2026, 1, 8), dueDate)
    }

    @Test
    @DisplayName("Deve calcular a data de devolução corretamente para um professor")
    fun `should calculate due date correctly for a teacher`() {
        val teacher = User.Teacher(
            id = "1",
            name = "Jane Doe",
            email = "jane.doe@example.com"
        )

        val dueDate = teacher.calculateDueDate(LocalDate.of(2026, 1, 1))

        assertEquals(LocalDate.of(2026, 1, 31), dueDate)
    }
}
