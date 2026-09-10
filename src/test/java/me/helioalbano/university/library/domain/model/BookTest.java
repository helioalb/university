package me.helioalbano.university.library.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BookTest {
    @Test
    @DisplayName("Should create a book with valid data")
    public void shouldCreateABookWithValidData() {
        var title = "Effective Java";
        var author = "Joshua Bloch";

        var book = new Book(title, author);

        assertNotNull(book);
        assertEquals("Effective Java - Joshua Bloch", book.getDescription());
    }
}
