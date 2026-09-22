package me.helioalbano.university.library.domain.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CopyTest {

    @Test
    @DisplayName("Should create a copy with valid data")
    public void shouldCreateACopyWithValidData() {
        var code = "CC-001";
        Item item = new Book("Effective Java", "Joshua Bloch");
        var isAvailable = true;

        var copy = new Copy(code, item, isAvailable);

        assertNotNull(copy);
    }

    @Test
    @DisplayName("Should mark a copy as loaned and returned")
    public void shouldMarkACopyAsLoanedAndReturned() {
        var code = "CC-001";
        Item item = new Book("Effective Java", "Joshua Bloch");
        var isAvailable = true;

        var copy = new Copy(code, item, isAvailable);

        assertTrue(copy.isAvailable());

        copy.markAsLoaned();

        assertFalse(copy.isAvailable());

        copy.markAsReturned();

        assertTrue(copy.isAvailable());
    }
}
