package me.helioalbano.university.library.domain.model;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class Loan {
    private static final DateTimeFormatter ID_DATE_FORMAT =
        DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");

    private final String id;

    public Loan(final User user, final Copy copy) {
        this(user, copy, Clock.systemDefaultZone());
    }

    public Loan(final User user, final Copy copy, final Clock clock) {
        var createdAt = LocalDateTime.now(clock);

        this.id =
            ID_DATE_FORMAT.format(createdAt) + "-" +
            user.getId() + "-" + copy.getCode();
    }

    public String getId() {
        return id;
    }
}
