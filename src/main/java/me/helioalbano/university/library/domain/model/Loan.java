package me.helioalbano.university.library.domain.model;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import me.helioalbano.university.shared.result.Result;

public final class Loan {
    private static final DateTimeFormatter ID_DATE_FORMAT =
        DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");

    private final String id;

    private Loan(final User user, final Copy copy, final Clock clock) {
        var createdAt = LocalDateTime.now(clock);

        this.id =
            ID_DATE_FORMAT.format(createdAt) + "-" +
            user.getId() + "-" + copy.getCode();
    }

    public static Result<Loan> create(final User user, final Copy copy, final Clock clock) {
        if (user.isBlocked()) {
            return Result.failure("O usuário está bloqueado.");
        }

        if (!copy.isAvailable()) {
            Result.failure("O exemplar não está disponível para empréstimo.");
        }

        copy.markAsLoaned();

        return Result.success(new Loan(user, copy, clock));
    }

    public String getId() {
        return id;
    }
}
