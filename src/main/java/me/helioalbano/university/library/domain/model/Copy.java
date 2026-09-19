package me.helioalbano.university.library.domain.model;

public final class Copy {
    private final String code;
    private final Item item;

    public Copy(final String code, final Item item) {
        this.code = code;
        this.item = item;
    }

    public boolean isAvailable() {
        return true;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return code + " - " + item.getDescription();
    }
}
