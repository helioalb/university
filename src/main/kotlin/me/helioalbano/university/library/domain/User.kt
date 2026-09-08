package me.helioalbano.university.library.domain

import java.time.LocalDate

sealed class User(
    open val id: String,
    open val name: String,
    open val email: String,
) {
    abstract fun calculateDueDate(startDate: LocalDate = LocalDate.now()): LocalDate

    data class Student(
        override val id: String,
        override val name: String,
        override val email: String,
    ) : User(id, name, email) {
        override fun calculateDueDate(startDate: LocalDate): LocalDate {
            return startDate.plusDays(7)
        }
    }

    data class Teacher(
        override val id: String,
        override val name: String,
        override val email: String,
    ) : User(id, name, email) {
        override fun calculateDueDate(startDate: LocalDate): LocalDate {
            return startDate.plusDays(30)
        }
    }
}
