package me.helioalbano.university.library.domain.model;

import java.time.Clock;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import me.helioalbano.university.shared.result.Result;

public final class Loan {
    private static final DateTimeFormatter ID_DATE_FORMAT =
        DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private final String id;
    private final User user;
    private final Copy copy;

    private Loan(
        final User user,
        final Copy copy,
        final LocalDate createdAt,
        final LocalDate dueDate
    ) {
        this.id =
            ID_DATE_FORMAT.format(createdAt) + "-" +
            user.getId() + "-" + copy.getCode();
        this.user = user;
        this.copy = copy;
    }

    public static Result<Loan> create(
        final User user,
        final Copy copy,
        final Clock clock
    ) {
        if (user.isBlocked()) {
            return Result.failure("O usuário está bloqueado.");
        }

        if (!copy.isAvailable()) {
            Result.failure("O exemplar não está disponível para empréstimo.");
        }

        copy.markAsLoaned();

        var createdAt = LocalDate.now(clock);
        var dueDate = user.calculateDueDate(createdAt);

        return Result.success(new Loan(user, copy, createdAt, dueDate));
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return user.getId();
    }
}
