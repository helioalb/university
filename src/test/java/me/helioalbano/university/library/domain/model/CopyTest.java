package me.helioalbano.university.library.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CopyTest {

    @Test
    @DisplayName("Should create a copy with valid data")
    public void shouldCreateACopyWithValidData() {
        Item item = new Book("Effective Java", "Joshua Bloch");

        var copy = new Copy("CC-001", item);

        assertNotNull(copy);
        assertEquals("CC-001 - Effective Java - Joshua Bloch", copy.getDescription());
    }
}
