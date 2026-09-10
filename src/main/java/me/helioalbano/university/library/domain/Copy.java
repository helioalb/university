package me.helioalbano.university.library.domain;

public final class Copy {
    private final String code;
    private final Item item;

    public Copy(final String code, final Item item) {
        this.code = code;
        this.item = item;
    }

    public String getDescription() {
        return code + " - " + item.getDescription();
    }
}
