package me.helioalbano.university.library.domain.model;

public final class Copy {
    private final String code;
    private boolean isAvailable = false;

    public Copy(final String code, final Item item, final boolean isAvailable) {
        this.code = code;
        this.isAvailable = isAvailable;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void markAsLoaned() {
        isAvailable = false;
    }

    public void markAsReturned() {
        isAvailable = true;
    }

    public String getCode() {
        return code;
    }
}
