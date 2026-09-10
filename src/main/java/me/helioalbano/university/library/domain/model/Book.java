package me.helioalbano.university.library.domain.model;

public final class Book extends Item {
    final private String title;
    final private String author;

    public Book(final String title, final String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public String getDescription() {
        return title + " - " + author;
    }
}
