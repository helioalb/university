package me.helioalbano.university.library.domain

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertNotNull
import java.time.LocalDate
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ItemTest {

    @Test
    @DisplayName("Deve criar um livro com todas as propriedades corretamente")
    fun `should create a book with the correct properties`() {
        val title = "Clean Code"
        val code = "LIB-BK-001"
        val author = "Robert C. Martin"
        val acquisitionDate = LocalDate.of(2026, 1, 15)

        val book = Item.Book(
            code = code,
            title = title,
            author = author,
            acquisitionDate = acquisitionDate
        )

        assertNotNull(book.id)
        assertEquals(code, book.code)
        assertEquals(title, book.title)
        assertEquals(author, book.author)
        assertEquals(acquisitionDate, book.acquisitionDate)
    }

    @Test
    fun `should create a magazine with the correct properties`() {
        val title = "Tech Monthly"
        val code = "LIB-MG-001"
        val issueNumber = 42

        val magazine = Item.Magazine(
            code = code,
            title = title,
            issueNumber = issueNumber,
        )

        assertNotNull(magazine.id)
        assertEquals(code, magazine.code)
        assertEquals(title, magazine.title)
        assertEquals(issueNumber, magazine.issueNumber)
        assertEquals(LocalDate.now(), magazine.acquisitionDate)
    }
}
