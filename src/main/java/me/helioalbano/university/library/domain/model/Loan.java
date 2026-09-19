package me.helioalbano.university.library.domain.model;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public final class Loan {
    private static final DateTimeFormatter ID_DATE_FORMAT =
        DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");

    private final String id;

    public Loan(final User user, final Copy copy) {
        this(user, copy, Clock.systemDefaultZone());
    }

    public Loan(final User user, final Copy copy, final Clock clock) {
        Objects.requireNonNull(user, "user não pode ser nulo");
        Objects.requireNonNull(copy, "copy não pode ser nulo");
        Objects.requireNonNull(clock, "clock não pode ser nulo");

        var createdAt = LocalDateTime.now(clock);
        this.id = ID_DATE_FORMAT.format(createdAt) + "-" + user.getId() + "-" + copy.getCode();
    }

    public String getId() {
        return id;
    }
}
