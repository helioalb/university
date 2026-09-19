package me.helioalbano.university.library.domain.service;

import java.time.Clock;
import java.util.Objects;

import me.helioalbano.university.library.domain.model.Loan;
import me.helioalbano.university.library.domain.repository.CopyRepository;
import me.helioalbano.university.library.domain.repository.LoanRepository;
import me.helioalbano.university.library.domain.repository.UserRepository;
import me.helioalbano.university.shared.result.Result;

public class LoanService {
    private final UserRepository userRepository;
    private final CopyRepository copyRepository;
    private final LoanRepository loanRepository;
    private final Clock clock;

    public LoanService(
        final UserRepository userRepository,
        final CopyRepository copyRepository,
        final LoanRepository loanRepository
    ) {
        this(
            userRepository,
            copyRepository,
            loanRepository,
            Clock.systemDefaultZone()
        );
    }

    public LoanService(
        final UserRepository userRepository,
        final CopyRepository copyRepository,
        final LoanRepository loanRepository,
        final Clock clock
    ) {
        this.userRepository = userRepository;
        this.copyRepository = copyRepository;
        this.loanRepository = loanRepository;
        this.clock = clock;
    }

    public Result<Loan> createLoan(final String userId, final String copyCode) {
        if (userId == null || copyCode == null || userId.isBlank() || copyCode.isBlank()) {
            return Result.failure("userId e copyCode não podem ser nulos ou vazios");
        }

        var userResult = userRepository.findById(userId);
        if (!userResult.isSuccess()) {
            return Result.failure(userResult.getError());
        }

        var user = userResult.getValue();
        if (user.isBlocked()) {
            return Result.failure("O usuário está bloqueado.");
        }

        if (user.hasReachedLoanLimit()) {
            Result.failure("O usuário atingiu o limite de empréstimos ativos.");
        }

        if (user.hasOverdueLoans()) {
            Result.failure("O usuário possui empréstimos em atraso.");
        }

        var copyResult = copyRepository.findByCode(copyCode);
        if (!copyResult.isSuccess()) {
            return Result.failure(copyResult.getError());
        }

        var copy = copyResult.getValue();
        if (!copy.isAvailable()) {
            Result.failure("O exemplar não está disponível para empréstimo.");
        }

        final Loan loan = new Loan(user, copy, clock);


        var saveResult = loanRepository.save(loan);
        if (!saveResult.isSuccess()) {
            return Result.failure(saveResult.getError());
        }

        return Result.success(saveResult.getValue());
    }
}
